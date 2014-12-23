/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.database;

import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.integrazione.model.Department;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author gemmacatolino
 */
public class DepartmentManager {
    
    private static DepartmentManager instance;
    
    public static DepartmentManager getInstance() {
        if (instance == null) {
            instance = new DepartmentManager();
        }
        return instance;
    }
    
    public void add(Department pDepartment) throws SQLException {
        Connection connect = DBConnection.getConnection();

        String sql = "INSERT INTO department (abbreviation, title, url_moodle, token) VALUES ('" + pDepartment.getAbbreviation() + "'," + "'" + pDepartment.getTitle() + "','" + pDepartment.getUrlMoodle() + "'," + pDepartment.getToken() + ")";

       
        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(sql);
            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }
    
    public Collection<Department> getAllDepartments() throws SQLException, ConnectionException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        Collection<Department> departments = new ArrayList<Department>();
        

        String query = "select * from department";
        
        try {
            connection = DBConnection.getConnection();
            
            if (connection == null) {
                throw new ConnectionException();
            }

            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                
                Department department = new Department();
                department.setAbbreviation(rs.getString("abbreviation"));
                department.setTitle(rs.getString("title"));
                department.setToken(rs.getString("token"));
                department.setUrlMoodle(rs.getString("url_moodle"));
                
                departments.add(department);
                
            }
        } finally {DBConnection.releaseConnection(connection);
        }

        return departments;
    }
    
    public Department getDepartmentByAbbreviation(String pAbbreviation) throws SQLException, ConnectionException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        Department department = null;

        String query = "select * from department where abbreviation = '" + pAbbreviation + "'";
        
        try {
            connection = DBConnection.getConnection();
            
            if (connection == null) {
                throw new ConnectionException();
            }

            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                department = new Department();
                department.setAbbreviation(rs.getString("abbreviation"));
                department.setTitle(rs.getString("title"));
                department.setToken(rs.getString("token"));
                department.setUrlMoodle(rs.getString("url_moodle"));
                
            }
        } finally {DBConnection.releaseConnection(connection);
        }

        return department;
    }
    
}
