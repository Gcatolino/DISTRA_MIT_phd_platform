/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.tirocinio.database;

import it.unisa.integrazione.database.DBConnection;
import it.unisa.integrazione.manager.concrete.ConcreteDepartment;
import it.unisa.integrazione.manager.concrete.ConcreteProfessor;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Valentino
 */
public class ProfessorDBOperation {
    private Connection aConnection;

    public ProfessorDBOperation() throws ClassNotFoundException, SQLException, IOException{
         aConnection = DBConnection.connect();
    }
    
    public ConcreteProfessor getInformationForProfessorByPrimaryKey(int primaryKey) throws SQLException{
        ConcreteProfessor aProf = new ConcreteProfessor();
        Statement aStatement = aConnection.createStatement();
        String query = "select * from Professor where idProfessor = '" + primaryKey + "'";
        ResultSet rs = aStatement.executeQuery(query);
        while (rs.next()) {
            aProf.setIdProfessor(rs.getInt(1));
            aProf.setPosition(rs.getString(2));
            aProf.setOfficePhoneNum(rs.getString(3));
            aProf.setOfficeHours(rs.getString(4));
            aProf.setOfficeEmail(rs.getString(5));
            aProf.setFKAccount(rs.getInt(6));
            aProf.setFKFisicPerson(rs.getInt(7));
            aProf.setFKDepartment(rs.getInt(8));
        }
        //aConnection.close();
        return aProf;
    }
    
    public ConcreteProfessor getInformationForProfessorByFK_Account(int FKAccount) throws SQLException{
        ConcreteProfessor aProf = new ConcreteProfessor();
        Statement aStatement = aConnection.createStatement();
        String query = "select * from Professor where FK_Account = '" + FKAccount + "'";
        ResultSet rs = aStatement.executeQuery(query);
        while (rs.next()) {
            aProf.setIdProfessor(rs.getInt(1));
            aProf.setPosition(rs.getString(2));
            aProf.setOfficePhoneNum(rs.getString(3));
            aProf.setOfficeHours(rs.getString(4));
            aProf.setOfficeEmail(rs.getString(5));
            aProf.setFKAccount(rs.getInt(6));
            aProf.setFKFisicPerson(rs.getInt(7));
            aProf.setFKDepartment(rs.getInt(8));
        }
       // aConnection.close();
        return aProf;
    }
    
    public void setClaimTrainingByProfessorByPrimaryKey(String description, int primaryKeyProf) throws SQLException{
        ConcreteProfessor aProf = this.getInformationForProfessorByPrimaryKey(primaryKeyProf);
        ConcreteDepartment aDepart = new ConcreteDepartment();
        Statement aStatement = aConnection.createStatement();
        String query = "select * from department where idDepartment = '"+aProf.getFKDepartment()+"'";
        ResultSet rs = aStatement.executeQuery(query);
        while (rs.next()) {
            aDepart.setIdDepartment(rs.getInt(1));
        }
        query = "INSERT INTO ClaimTraining (Description,FK_ClaimStatus,FK_Professor,FKOrganization) VALUES ('"+description+"', '1', '"+aProf.getIdProfessor()+"', '"+aDepart.getIdDepartment()+"');";
        rs = aStatement.executeQuery(query);
        //aConnection.close();
        return;
    }
    
    public boolean setClaimTrainingByProfessorByFK_Account(String description, int FKAccount) throws SQLException{
        ConcreteProfessor aProf = this.getInformationForProfessorByFK_Account(FKAccount);
        ConcreteDepartment aDepart = new ConcreteDepartment();
        Statement aStatement = aConnection.createStatement();
        String query = "select * from department where idDepartment = '"+aProf.getFKDepartment()+"'";
        ResultSet rs = aStatement.executeQuery(query);
        while (rs.next()) {
            aDepart.setIdDepartment(rs.getInt(1));
        }
        
        String query1 = "INSERT INTO ClaimTraining (idClaimTraining,Description,FK_ClaimStatus,FK_Professor,FKOrganization) VALUES ('22', '"+description+"', '1', '"+aProf.getIdProfessor()+"', '"+aDepart.getIdDepartment()+"');";
        int result = aStatement.executeUpdate(query1);
        if (result == 1 )
            return true;
        return false;
    }
    
}
