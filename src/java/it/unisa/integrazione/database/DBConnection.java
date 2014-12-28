package it.unisa.integrazione.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class simulates a db connection pool
 * 
 * @author gemmacatolino
 * @version 1.0
 */
public class DBConnection {
    private static String dbPath = "jdbc:mysql://localhost:3306/db_distra";
    private static String dbUsername = "root";
    private static String dbPassword = ""; 

    static {
        freeDbConnections = new ArrayList<Connection>();
        try {
            DBConnection.loadDbProperties();
            DBConnection.loadDbDriver();
        } catch (ClassNotFoundException e) {
            System.err.println("DB DRIVER NOT FOUND!");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("DB CONNECTION POOL ERROR!");
            System.exit(2);
        }
    }

    /**
     * The db properties (driver, url, login, and password)
     */
    private static Properties dbProperties;

    /**
     * The free connection queue
     */
    private static List<Connection> freeDbConnections;

    /**
     * Returns a free db connection accessing to the free db connection queue.
     * If the queue is empty a new db connection will be created.
     * 
     * @return A db connection
     * @throws SQLException
     */
    public static synchronized Connection getConnection() throws SQLException {
        Connection connection;
    
        if (!freeDbConnections.isEmpty()) {
            // Extract a connection from the free db connection queue
            connection = (Connection)freeDbConnections.get(0);
            DBConnection.freeDbConnections.remove(0);

            try {
                // If the connection is not valid, a new connection will be
                // analyzed
                if (connection.isClosed())
                    connection = DBConnection.getConnection();
            } catch (SQLException e) {
                connection = DBConnection.getConnection();
            }
        }
        else
            // The free db connection queue is empty, so a new connection will
            // be created
            connection = DBConnection.createDBConnection();

        return connection;
    }

    /**
     * Releases the connection represented by <code>pReleasedConnection</code>
     * parameter
     * 
     * @param pReleasedConnection
     *        The db connection to release
     */
    public static synchronized void releaseConnection(
            Connection pReleasedConnection) {
        try {
            // Add the connection to the free db connection queue
            DBConnection.freeDbConnections.add(pReleasedConnection);
            pReleasedConnection.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates a new db connection
     * 
     * @return A db connection
     * @throws SQLException
     */
    private static Connection createDBConnection() throws SQLException {
        Connection newConnection = null;

        // Create a new db connection using the db properties
        newConnection = DriverManager.getConnection(
                DBConnection.dbProperties.getProperty("url"),
                DBConnection.dbProperties.getProperty("username"),
                DBConnection.dbProperties.getProperty("password"));

        newConnection.setAutoCommit(false);

        return newConnection;
    }

    private static void loadDbDriver() throws ClassNotFoundException {
       Class.forName(DBConnection.dbProperties.getProperty("driver"));
    	
    }

    /**
     * Loads the db properties
     * 
     * @throws IOException
     */
    private static void loadDbProperties() throws IOException {
//   	InputStream fileProperties = new FileInputStream("database.properties");
//      DBConnection.dbProperties.load(fileProperties);
        DBConnection.dbProperties = new Properties();
        
        DBConnection.dbProperties.setProperty("driver", "com.mysql.jdbc.Driver");
        DBConnection.dbProperties.setProperty("url", DBConnection.dbPath);
        DBConnection.dbProperties.setProperty("username", DBConnection.dbUsername);
        DBConnection.dbProperties.setProperty("password", DBConnection.dbPassword);
    }
}

