package it.unisa.integrazione.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author carlosborges
 */
public class DBConnection {

    public static Connection connect() throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        String userPath = System.getProperty("user.home");
        final InputStream cfg = new FileInputStream(userPath+"/TPConfig/config.cfg");
        Properties configFile = new java.util.Properties();
        configFile.load(cfg);
        Class.forName("com.mysql.jdbc.Driver");
        Connection aConnection;
        aConnection = DriverManager.getConnection(configFile.getProperty("serverConn"), configFile.getProperty("userName"), configFile.getProperty("password"));
        return aConnection;
    }
}
