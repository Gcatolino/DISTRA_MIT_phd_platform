/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.database;

import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.model.Degree;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alessandro, Antonio
 */
public class DegreeManager {

    private final Connection conn = null;
    private Statement stmt;
    public static String TABLE = "degree";
    public static String PKEY = "matricula";
    private ResultSet rs = null;

    private static DegreeManager instance = null;

    String esc = "\'";

    /**
     * Constructor for Singleton pattern
     */
    private DegreeManager() {
    }

    /**
     * Insert a Degree into the DB
     *
     * @param degree to insert into the DB
     * @return true if the insertion was successfull
     */
    public boolean createDegree(Degree degree) {
        try {
            stmt = DBConnection.getConnection().createStatement();
            String query = "INSERT INTO " + TABLE
                    + "(title, "
                    + "matricula,"
                    + "link,"
                    + "cycle_number,"
                    + "department_abbreviation, "
                    + "active) VALUES("
                    + degree.toStringQueryInsert() + ")";
            if (stmt.executeUpdate(query) == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Insertion Query failed!");
        } finally {
            DBConnection.releaseConnection(conn);
        }
        return false;
    }

    /**
     * Update a Degree into the DB
     *
     * @param matricula
     * @param degree to update into the DB
     * @return true if the update was successfull
     */
    public boolean updateDegree(String matricula, Degree degree) {
        try {
            stmt = DBConnection.getConnection().createStatement();
            String query = "UPDATE " + TABLE
                    + " SET " + degree.toString() + " WHERE "
                    + PKEY + "=" + esc + matricula + esc;
            if (stmt.executeUpdate(query) == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Update Query failed!");
        } finally {
            DBConnection.releaseConnection(conn);
        }
        return false;
    }

    /**
     * Read a given Degree from the DB
     *
     * @param matricula id the matricula of the degree
     * @return a Degree object if it is present in the DB, else empty Degree
     * bean
     */
    public Degree readDegree(String matricula) {
        if (matricula == null || matricula.equals("")) {
            throw new IllegalArgumentException("Can't read a degree from the Database using an empty matricula");
        } else {
            try {
                stmt = DBConnection.getConnection().createStatement();
                rs = stmt.executeQuery("SELECT * FROM " + TABLE
                        + " WHERE " + PKEY + "=\"" + matricula + "\"");
                while (rs.next()) {
                    return getDegreeFromResultSet(rs);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new RuntimeException("Read Query failed!");
            } finally {
                DBConnection.releaseConnection(conn);
            }
        }
        return null;
    }

    /**
     * Delete a given Degree from the DB
     *
     * @param matricula of the degree
     * @return true if deleted.
     */
    public boolean deleteDegree(String matricula) {
        try {
            stmt = DBConnection.getConnection().createStatement();
            if (stmt.executeUpdate("DELETE FROM " + TABLE
                    + " WHERE " + PKEY + "=\"" + matricula + "\"") == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Delete Query failed!");
        } finally {
            DBConnection.releaseConnection(conn);
        }
        return false;
    }

    /**
     * Get all the Degrees in the lists
     *
     * @return an ArrayList of Degrees
     */
    public ArrayList<Degree> getAllDegrees() {
        ArrayList<Degree> toReturn = new ArrayList<Degree>();
        try {
            stmt = DBConnection.getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM " + TABLE + " order by title");

            while (rs.next()) {
                Degree b = getDegreeFromResultSet(rs);
                toReturn.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.releaseConnection(conn);
        }
        return toReturn;
    }

    /**
     * Insert all the degrees in the list into the Database
     *
     * @param list is the list of degrees to insert
     * @return the list of degrees which had an error during the insertion
     * process. So, check if this list is empty to make sure of the insertion
     * process.
     */
    public ArrayList<Degree> insertDegree(ArrayList<Degree> list) {
        ArrayList<Degree> notInserted = new ArrayList<Degree>();

        for (Degree b : list) {
            if (!createDegree(b)) {
                notInserted.add(b);
            }
        }
        return notInserted;
    }

    public Degree getDegreeByTitle(String pTitle) throws ConnectionException, SQLException {
        Connection connection = null;
        Degree degree = null;

        String query = "select * from degree where title = '" + pTitle + "'";
        
        try {
            connection = DBConnection.getConnection();
            
            if (connection == null) {
                throw new ConnectionException();
            }

            this.stmt = connection.createStatement();
            this.rs = this.stmt.executeQuery(query);

            if (this.rs.next()) {
                degree = this.getDegreeFromResultSet(this.rs);
                
            }
        } finally {

            if (this.rs != null) {
                this.rs.close();
            }

            if (this.stmt != null) {
                this.stmt.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
  
        return degree;
    }
    
    /**
     * return all the degrees which belong to a given department
     *
     * @param abbreviation the department abbreviation
     * @return a List of degree
     */
    public ArrayList<Degree> getDegreesByDepartment(String abbreviation) {
        String esc = "\"";
        ArrayList<Degree> toReturn = new ArrayList<Degree>();
        try {
            stmt = DBConnection.getConnection().createStatement();
            rs = stmt.executeQuery("SELECT * FROM " + TABLE
                    + " WHERE department_abbreviation="
                    + esc + abbreviation + esc
                    + " order by title");
            while (rs.next()) {
                Degree b = getDegreeFromResultSet(rs);
                toReturn.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.releaseConnection(conn);
        }
        return toReturn;
    }

    /**
     * Get all the degrees in the lists with a given cycle
     *
     * @param cycle
     * @return ArrayList containing all the related Degrees
     */
    public ArrayList<Degree> getDegreesByCycle(int cycle) {
        ArrayList<Degree> toReturn = new ArrayList<Degree>();
        if (cycle < 1) {
            throw new IllegalArgumentException("Cycle must be greater than 1");
        } else {
            try {
                stmt = DBConnection.getConnection().createStatement();
                String query = "SELECT * FROM " + TABLE
                        + " WHERE cycle_number=" + cycle
                        + " order by title";
                rs = stmt.executeQuery(query);

                while (rs.next()) {
                    Degree b = getDegreeFromResultSet(rs);
                    toReturn.add(b);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.releaseConnection(conn);
            }
        }
        return toReturn;

    }

    /**
     * used to get the unique instance of this class
     *
     * @return
     */
    public static DegreeManager getInstance() {
        if (instance == null) {
            instance = new DegreeManager();
        }
        return instance;
    }

    private Degree getDegreeFromResultSet(ResultSet rs) {
        String matricula;
        try {
            matricula = rs.getString("matricula");
            String link = rs.getString("link");
            String title = rs.getString("title");
            int cycle = rs.getInt("cycle_number");
            String dep = rs.getString("department_abbreviation");
            int active = rs.getInt("active");
            return new Degree(matricula, link, title, cycle, dep, (active > 0));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Degree> getDegreesByDepartmentAndCycle(String depAbbreviation, int cycle) {
        List<Degree> toReturn = new ArrayList<Degree>();
        String esc = "\'";
        if (cycle < 1) {
            throw new IllegalArgumentException("Cycle must be greater than 1");
        } else {
            try {
                stmt = DBConnection.getConnection().createStatement();
                String query = "SELECT * FROM " + TABLE
                        + " WHERE cycle_number=" + cycle + " AND "
                        + "department_abbreviation=" + esc + depAbbreviation + esc
                        + " order by title";
                rs = stmt.executeQuery(query);

                while (rs.next()) {
                    Degree b = getDegreeFromResultSet(rs);
                    toReturn.add(b);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                DBConnection.releaseConnection(conn);
            }
        }

        return toReturn;

    }

}
