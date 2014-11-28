/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.database;


import it.unisa.integrazione.database.DBConnection;
import it.unisa.integrazione.manager.concrete.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author katiasolomita
 */
public class FisicPersonInformation {



    private Connection aConnection;
    
    public FisicPersonInformation() throws ClassNotFoundException, SQLException, IOException {
        aConnection = DBConnection.connect();
    }

    public ConcreteFisicPerson getFisicPersonInformation(int idFisicPerson) throws SQLException, ClassNotFoundException, IOException  {
        aConnection = DBConnection.connect();
        ConcreteFisicPerson afisicPerson = new ConcreteFisicPerson();
        Statement aStatement = aConnection.createStatement();
        String query = "select * from FisicPerson where idFisicPerson='" + idFisicPerson+"'";
        ResultSet rs = aStatement.executeQuery(query);
        while (rs.next()) {
            
            afisicPerson.setPrimaryKey(rs.getInt(1));
            afisicPerson.setName(rs.getString(2));
            afisicPerson.setLastName(rs.getString(3));
            afisicPerson.setPhoneNum(rs.getString(4));
            afisicPerson.setCity(rs.getString(5));
            afisicPerson.setAddress(rs.getString(6));
            afisicPerson.setCAP(rs.getString(7));
            afisicPerson.setSEX(rs.getString(8).charAt(0));
            afisicPerson.setCitizenship(rs.getString(9));
            afisicPerson.setCF(rs.getString(10));
            afisicPerson.setEmail(rs.getString(11));  
        }
           aConnection.close();
        
            return afisicPerson;
        }
}                   


