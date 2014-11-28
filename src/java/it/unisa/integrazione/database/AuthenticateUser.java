/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import it.unisa.integrazione.manager.concrete.*;
import java.io.IOException;

/**
 *
 * @author carlosborges
 */
public class AuthenticateUser {

    private Connection aConnection;
    
    public AuthenticateUser() throws ClassNotFoundException, SQLException, IOException {
        aConnection = DBConnection.connect();
    }

    public ConcreteAccount authenticate(String userName, String password) throws SQLException  {
        int rsResult = 0;
        ConcreteAccount loggedAccount = new ConcreteAccount();
        Statement aStatement = aConnection.createStatement();
        String query = "select * from Account where userName='" + userName + "' and password='" + password + "'";
        ResultSet rs = aStatement.executeQuery(query);
        while (rs.next()) {
            rsResult++;
            loggedAccount.setPrimaryKey(rs.getInt(1));
            loggedAccount.setUserName(rs.getString(2));
            loggedAccount.setTypeOfAccount(rs.getString(4));
            loggedAccount.setFKPermission(this.getAccountPermission(rs.getInt(5)));
        }
        
        aConnection.close();
        if (rsResult == 0) {
            return null;
        } else {
            return loggedAccount;
        }
        
    }
    
    /**
     * This method is used to load from DB the permission associated to the idAccount  
     * @param permissionId
     * @return
     * @throws SQLException 
     */
    private ConcretePermissions getAccountPermission(int permissionId) throws SQLException{
        ConcretePermissions aPermission = new ConcretePermissions();
        Statement aStatement = aConnection.createStatement();
        String query = "SELECT * from Permissions WHERE idPermissions="+permissionId;
        ResultSet rs = aStatement.executeQuery(query);
        while(rs.next()){
            aPermission.setPrimaryKey(rs.getInt(1));
            aPermission.setDescription(rs.getString(2));
            aPermission.setClassPermission(rs.getString(3));
        }
        return aPermission; 
    }

}                   
