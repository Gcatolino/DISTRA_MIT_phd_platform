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
import java.util.GregorianCalendar;

/**
 *
 * @author katiasolomita
 */
public class StudentDBOperation {

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    private Connection aConnection;

    public StudentDBOperation() throws ClassNotFoundException, SQLException, IOException {
        aConnection = DBConnection.connect();
    }

    /**
     * 
     * @param FK_Account
     * @return
     * @throws SQLException
     */
    public ConcreteStudent getInformationbyFK_Account(int FK_Account) throws SQLException {
        ConcreteStudent aStudent = new ConcreteStudent();
        Statement aStatement = aConnection.createStatement();
        GregorianCalendar cal = new GregorianCalendar();
        String query = "select * from Student where FK_Account = '" + FK_Account + "'";
        ResultSet rs = aStatement.executeQuery(query);
        while (rs.next()) {
            aStudent.setPrimaryKey(rs.getString(1));
            aStudent.setCoverLetter(rs.getString(2));
            cal.setTime(rs.getDate(3));
            aStudent.setYearEnrollment(cal);
            aStudent.setCycle(rs.getInt(4));
            aStudent.setUniversityEmail(rs.getString(5));
            aStudent.setFKAccount(rs.getInt(6));
            aStudent.setFKFisicPerson(rs.getInt(7));
            aStudent.setFKDepartment(rs.getInt(8));
            aStudent.setFKStudentStatus(rs.getInt(9));
            aStudent.setFKClaimTraining(rs.getInt(10));
            aStudent.setFKidStudentInformation(rs.getInt(12));
        }
        aConnection.close();
        return aStudent;

    }

    /**
     *
     * @param PrimaryKey
     * @return
     * @throws SQLException
     */
    public ConcreteStudent getInformationbyPrimaryKey(String PrimaryKey) throws SQLException, ClassNotFoundException, IOException {
        aConnection = DBConnection.connect();
        ConcreteStudent aStudent = new ConcreteStudent();
        Statement aStatement = aConnection.createStatement();
        GregorianCalendar cal = new GregorianCalendar();
        String query = "select * from Student where serialNumber = '" + PrimaryKey + "'";
        ResultSet rs = aStatement.executeQuery(query);
        while (rs.next()) {
            aStudent.setPrimaryKey(rs.getString(1));
            aStudent.setCoverLetter(rs.getString(2));
            cal.setTime(rs.getDate(3));
            aStudent.setYearEnrollment(cal);
            aStudent.setCycle(rs.getInt(4));
            aStudent.setUniversityEmail(rs.getString(5));
            aStudent.setFKAccount(rs.getInt(6));
            aStudent.setFKFisicPerson(rs.getInt(7));
            aStudent.setFKDepartment(rs.getInt(8));
            aStudent.setFKStudentStatus(rs.getInt(9));
            aStudent.setFKClaimTraining(rs.getInt(10));
            aStudent.setFKidStudentInformation(rs.getInt(12));

        }
        aConnection.close();
        return aStudent;

    }
    
    /**
     *
     * @param FK_Account
     * @return
     * @throws SQLException
     */
    public ConcreteStudent getSerialNumberbyFK_Account(int FK_Account) throws SQLException {
        ConcreteStudent aStudent = new ConcreteStudent();
        Statement aStatement = aConnection.createStatement();
        String query = "select serialNumber from Student where FK_Account = '" + FK_Account + "'";
        ResultSet rs = aStatement.executeQuery(query);
        while (rs.next()) {
            aStudent.setPrimaryKey(rs.getString(1));
        }
        aConnection.close();
        return aStudent;
    }
    
}
