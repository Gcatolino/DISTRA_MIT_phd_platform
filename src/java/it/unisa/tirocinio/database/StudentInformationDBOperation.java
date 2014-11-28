/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.database;

import it.unisa.integrazione.database.DBConnection;
import it.unisa.integrazione.manager.concrete.*;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author carlosborges
 */
public class StudentInformationDBOperation {

    private final Connection aConnection;

    public StudentInformationDBOperation() throws ClassNotFoundException, SQLException, IOException {
        aConnection = DBConnection.connect();
    }

    public ConcreteStudentInformation getStudentInfoByPrimaryKey(int primaryKey) throws SQLException {
        ConcreteStudentInformation studentInfo = new ConcreteStudentInformation();
        CallableStatement pcSelect = aConnection.prepareCall("{call getStudentInformation(?)}");
        pcSelect.setInt("primaryKey", primaryKey);
        ResultSet rs = pcSelect.executeQuery();
        while (rs.next()) {
            studentInfo.setPrimaryKey(rs.getInt(1));
            studentInfo.setCurriculumVitaePATH(rs.getString(2));
            studentInfo.setAccademicTranscriptPATH(rs.getString(3));
        }
        //rs.close();
        //pcSelect.close();
        aConnection.close();
        return studentInfo;

    }
    
    
    
    
}
