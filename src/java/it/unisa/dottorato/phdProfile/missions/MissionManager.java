/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.dottorato.phdProfile.missions;

import it.unisa.dottorato.utility.Utility;
import it.unisa.integrazione.database.DBConnection;
import it.unisa.integrazione.model.Person;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gemmacatolino
 */
public class MissionManager {
    
    /**
     * Il nome della tabella
     */
    private static final String TABLE_MISSION = "mission";
    
    //	 istanza della classe
    private static MissionManager instance;

    /**
     * Il costruttore della classe e' dichiarato privato, per evitare
     * l'istanziazione di oggetti della classe .
     */
    private MissionManager() {
        super();
    }

    /**
     * Metodo della classe incaricato della produzione degli oggetti, tale
     * metodo deve essere chiamato per restituire l'istanza del Singleton.
     * L'oggetto Singleton sara' istanziato solo alla prima invocazione del
     * metodo. Nelle successive invocazioni, invece, sara' restituito un
     * riferimento allo stesso oggetto.
     *
     * @return L'istanza della classe
     */
    public static synchronized MissionManager getInstance() {
        if (instance == null) {
            instance = new MissionManager();
        }
        return instance;
    }
    
    public synchronized void insert(Mission pMission) throws SQLException {
        try (Connection connect = DBConnection.getConnection()) {

            /*
             * Prepariamo la stringa SQL per inserire un nuovo record 
             * nella tabella phdCycle
             */
            String tSql = "INSERT INTO "
                    + MissionManager.TABLE_MISSION
                    + " (place, description, startDate, endDate, FK_Student)"
                    + " VALUES ('"
                    + Utility.Replace(pMission.getPlace())
                    + "','"
                    + Utility.Replace(pMission.getDescription())
                    + "','"
                    + pMission.getStartDate()
                    + "','"
                    + pMission.getEndDate() 
                    + "','"
                    + pMission.getFK_Student()
                    + "')";

            System.out.println("La query: " +tSql);
            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        }
    }
          
    public synchronized void update(int oldMissionID, Mission pMission) throws ClassNotFoundException, SQLException, IOException {
        try (Connection connect = DBConnection.getConnection()) {

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "UPDATE "
                    + MissionManager.TABLE_MISSION
                    + " set place = '"
                    + Utility.Replace(pMission.getPlace())
                    + "', description = '"
                    + Utility.Replace(pMission.getDescription())
                    + "', startDate = '"
                    + pMission.getStartDate()
                    + "', endDate = '"
                    + pMission.getEndDate()
                    + "' WHERE idMission = "
                    + oldMissionID + "";           

            System.out.println(tSql);
            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        }
    }
    
    public synchronized void delete(String idMission) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "DELETE FROM "
                    + MissionManager.TABLE_MISSION
                    + " WHERE idMission = '"
                    + idMission + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }
    
    public synchronized Mission getMissionById(int pMissionID) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            Mission mission = new Mission();
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "SELECT * FROM "
                    + MissionManager.TABLE_MISSION
                    + " WHERE idMission = '"
                    + pMissionID + "'";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            if (result.next()) {
                mission.setIdMission(result.getInt("idMission"));
                mission.setPlace(result.getString("place"));
                mission.setDescription(result.getString("description"));
                mission.setStartDate(result.getDate("startDate"));
                mission.setEndDate(result.getDate("endDate"));
                mission.setFK_Student(result.getString("FK_Student"));
            }

            return mission;

        } finally {
            DBConnection.releaseConnection(connect);
        }
    }
    
    public synchronized List<Mission> getAllMissionsOf(Person pPerson) throws SQLException {
        List<Mission> missions = new ArrayList<Mission>();
        
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "SELECT * FROM "
                    + MissionManager.TABLE_MISSION
                    + " WHERE FK_Student = '"
                    + pPerson.getSsn() + "'";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            while (result.next()) {
                Mission mission = new Mission();
                
                mission.setIdMission(result.getInt("idMission"));
                mission.setPlace(result.getString("place"));
                mission.setDescription(result.getString("description"));
                mission.setStartDate(result.getDate("startDate"));
                mission.setEndDate(result.getDate("endDate"));
                mission.setFK_Student(result.getString("FK_Student"));
                
                missions.add(mission);
            }

        } finally {
            DBConnection.releaseConnection(connect);
        }
        
        
        return missions;
    }
}