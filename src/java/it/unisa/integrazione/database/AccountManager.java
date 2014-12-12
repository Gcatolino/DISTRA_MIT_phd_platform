package it.unisa.integrazione.database;

import it.unisa.integrazione.database.exception.AccountNotActiveException;
import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.model.Account;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import it.unisa.model.Person;

/**
 *
 * @author gemmacatolino
 */
public class AccountManager {

    private static AccountManager instance;

    public static AccountManager getInstance() {

        if (instance == null) {
            instance = new AccountManager();
        }
        return instance;

    }

    public Person login(String pUsername, String pPassword) throws AccountNotActiveException,  SQLException, ConnectionException {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        Person person = null;

        String query = "select * from account where email='" + pUsername + "' and password='" + pPassword + "'";

        System.out.println("la query è:" +query);
                
        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }

            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                Account account = new Account();
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setTypeOfAccount(rs.getString("typeOfAccount"));
                account.setActive(rs.getBoolean("active"));
                
                if(!account.isActive()) {
                    throw new AccountNotActiveException();
                }

                person = PersonManager.getInstance().getPersonByEmail(account.getEmail());
            }

        } finally {
            if(rs != null)
                rs.close();
            
            if(stmt != null)
                stmt.close();
            
            if(connection != null)
                connection.close();
        }
        
        return person;
    }

    public void add(Account pAccount) throws SQLException {
        Connection connect = DBConnection.getConnection();

        String sql = "INSERT INTO account (email, account.password, typeOfAccount, account.active) VALUES ('" + pAccount.getEmail() + "','" + pAccount.getPassword() + "','" + pAccount.getTypeOfAccount() + "'," + pAccount.isActive() + ")";

        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(sql);
            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    } 
    
    public Account getAccoutnByEmail(String pEmail) throws SQLException, ConnectionException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        Account account = null;

        String query = "select * from account where email = '" + pEmail + "'";

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }

            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                account = new Account();
                
                account.setActive(rs.getBoolean("active"));
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setTypeOfAccount(rs.getString("typeOfAccount"));
            }
        } finally {

            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

        return account;
    }
}
