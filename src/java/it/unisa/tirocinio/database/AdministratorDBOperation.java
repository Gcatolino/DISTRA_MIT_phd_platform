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
public class AdministratorDBOperation {

    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    private Connection aConnection;

    public AdministratorDBOperation() throws ClassNotFoundException, SQLException, IOException {
        aConnection = DBConnection.connect();
    }

    /**
     * 
     * @param FK_Account
     * @return
     * @throws SQLException
     */
    public ConcreteStaff getInformationbyFK_Account(int FK_Account) throws SQLException {
        ConcreteStaff aAdmin = new ConcreteStaff();
        Statement aStatement = aConnection.createStatement();
        String query = "select * from Staff where FK_Account = '" + FK_Account + "'";
        ResultSet rs = aStatement.executeQuery(query);
        while (rs.next()) {
            aAdmin.setIdStaff(rs.getInt(1));
            aAdmin.setOfficePhoneNum(rs.getString(2));
            aAdmin.setOfficeMail(rs.getString(3));
            aAdmin.setFKDepartment(rs.getInt(4));
            aAdmin.setFKAccount(rs.getInt(5));
            aAdmin.setFKFisicPerson(rs.getInt(6));
        }        
        aConnection.close();
        return aAdmin;
    }

    /**
     *
     * @param PrimaryKey
     * @return
     * @throws SQLException
     */
    public ConcreteStaff getInformationbyPrimaryKey(int PrimaryKey) throws SQLException, ClassNotFoundException, IOException {
        aConnection = DBConnection.connect();
        ConcreteStaff aAdmin = new ConcreteStaff();
        Statement aStatement = aConnection.createStatement();
        String query = "select * from Staff where idStaff = '" + PrimaryKey + "'";
        ResultSet rs = aStatement.executeQuery(query);
        while (rs.next()) {
            aAdmin.setIdStaff(rs.getInt(1));
            aAdmin.setOfficePhoneNum(rs.getString(2));
            aAdmin.setOfficeMail(rs.getString(3));
            aAdmin.setFKDepartment(rs.getInt(4));
            aAdmin.setFKAccount(rs.getInt(5));
            aAdmin.setFKFisicPerson(rs.getInt(6));
        }
        aConnection.close();
        return aAdmin;
    }
    
    
    /**
     *
     * @param FK_Account
     * @return
     * @throws SQLException
     */
    public ConcreteDepartment getFK_DepartmentbyFK_Account(int FK_Account) throws SQLException {
        ConcreteStaff aAdmin = new ConcreteStaff();
        Statement aStatement = aConnection.createStatement();
        String query = "select FK_Department from Staff where FK_Account = '" + FK_Account + "'";
        ResultSet rs = aStatement.executeQuery(query);
        while (rs.next()) {
            aAdmin.setFKDepartment(rs.getInt(1));
        }
        ConcreteDepartment aDepart = new ConcreteDepartment();
        query = "select * from Department where idDepartment = '" + aAdmin.getFKDepartment() + "'";
        rs = aStatement.executeQuery(query);
        
        while (rs.next()) {
            aDepart.setIdDepartment(rs.getInt(1));
            aDepart.setDescription(rs.getString(2));
        }
        aConnection.close();
        return aDepart;
    }
    
    public ConcreteOrganization getInformationForOrganizationByPrimaryKey(int primaryKey) throws SQLException{
        ConcreteOrganization aOrga  = new ConcreteOrganization();
        Statement aStatement = aConnection.createStatement();
        String query = "select * from Organization where idOrganization = '" + primaryKey + "'";
        ResultSet rs = aStatement.executeQuery(query);
        while (rs.next()) {
            aOrga.setIdOrganization(rs.getInt(1));
            aOrga.setCompanyName(rs.getString(2));
        }
        aConnection.close();
        return aOrga;
    }
    
    public ConcreteOrganization getInformationForOrganizationByFK_Account(int FKAccount) throws SQLException{
        ConcreteOrganization aOrga  = new ConcreteOrganization();
        Statement aStatement = aConnection.createStatement();
        String query = "select * from Organization where FK_Account = '" + FKAccount + "'";
        ResultSet rs = aStatement.executeQuery(query);
        while (rs.next()) {
            aOrga.setIdOrganization(rs.getInt(1));
            aOrga.setCompanyName(rs.getString(2));
        }
        aConnection.close();
        return aOrga;
    }
    
    /*public void setAssociateProfAtTheOrganization(int primaryKeyProf, int primaryKeyOrga) throws SQLException{
        ConcreteProfessor aProf = this.getInformationForProfessorByPrimaryKey(primaryKeyProf);
        ConcreteOrganization aOrga = this.getInformationForOrganizationByPrimaryKey(primaryKeyProf);
        
    }*/
}
