/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.database;

import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.integrazione.model.Cycle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author gemmacatolino
 */
public class CycleManager {

    private static CycleManager instance;

    public static CycleManager getInstance() {

        if (instance == null) {
            instance = new CycleManager();
        }
        return instance;

    }

    public void add(Cycle pCycle) throws SQLException {
        Connection connect = DBConnection.getConnection();

        String sql = "INSERT INTO cycle (cycle_number, title) VALUES (" + pCycle.getCycleNumber() + ", '" + pCycle.getTitle() + "')";

        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(sql);
            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    public Cycle getCycleByCycleNumber(int pCycleNumber) throws SQLException, ConnectionException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        Cycle cycle = null;

        String query = "select * from cycle where cycle_number = " + pCycleNumber;

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }

            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                cycle = new Cycle();
                cycle.setCycleNumber(rs.getInt("cycle_number"));
                cycle.setTitle(rs.getString("title"));
            }
        } finally {

            DBConnection.releaseConnection(connection);
        }

        return cycle;
    }
}
