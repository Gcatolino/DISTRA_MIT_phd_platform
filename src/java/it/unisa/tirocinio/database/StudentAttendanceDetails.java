package it.unisa.tirocinio.database;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import it.unisa.integrazione.database.*;
import it.unisa.integrazione.manager.concrete.*;
import it.unisa.integrazione.manager.interfaces.*;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author carlosborges
 */
public class StudentAttendanceDetails {

    private final Connection aConnection;

    public StudentAttendanceDetails() throws ClassNotFoundException, SQLException, IOException {
        aConnection = DBConnection.connect();
    }

    /**
     * Return for all students into the StudentAttendece table the Corresponding
     * Student fisicPerson and studentInformation object
     *
     * @return
     * @throws SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    public ArrayList<StudentTrainingInformation> getStudentDetails() throws SQLException, ClassNotFoundException, IOException {
        CallableStatement pcSelect = aConnection.prepareCall("{call getStudentAttendence()}");
        ArrayList<StudentTrainingInformation> studentsTrainingList = new ArrayList<StudentTrainingInformation>();//a list of information of student who are in waiting list
        StudentDBOperation studentInformation = new StudentDBOperation();
        FisicPersonInformation personInformation = new FisicPersonInformation();
        StudentInformationDBOperation studentAttendanceInfo = new StudentInformationDBOperation();     
        ArrayList<ConcreteStudentAttendence> studentList = new ArrayList<ConcreteStudentAttendence> ();
        ConcreteStudent aStudent;
        ResultSet rs = pcSelect.executeQuery();
        while (rs.next()) {//import into the arrayList all the records present into the StudentAttendence
            ConcreteStudentAttendence aStudentAttendence = new ConcreteStudentAttendence();
            aStudentAttendence.setFKStudent(rs.getString(3));
            aStudentAttendence.setPrimaryKey(rs.getInt(1));
            studentList.add(aStudentAttendence);
        }
        aConnection.close();
        for(ConcreteStudentAttendence aStudentAttendence: studentList){
            StudentTrainingInformation aStudentTraining = new StudentTrainingInformation();
            aStudent = studentInformation.getInformationbyPrimaryKey(aStudentAttendence.getFKStudent());
            aStudentTraining.setStudent(aStudent);
            aStudentTraining.setFisicPerson(personInformation.getFisicPersonInformation(aStudent.getFKFisicPerson()));
            aStudentTraining.setaStudentInformation(studentAttendanceInfo.getStudentInfoByPrimaryKey(aStudent.getFKidStudentInformation()));
            studentsTrainingList.add(aStudentTraining);
        }
        
        return studentsTrainingList;
    }
}
