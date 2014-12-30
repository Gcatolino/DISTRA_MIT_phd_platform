/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.dottorato.phdProfile.collaborations;

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
public class CollaborationManager {
    
    /**
     * Il nome della tabella
     */
    private static final String TABLE_COLLABORATION = "collaboration";
    
    //	 istanza della classe
    private static CollaborationManager instance;

    /**
     * Il costruttore della classe e' dichiarato privato, per evitare
     * l'istanziazione di oggetti della classe .
     */
    private CollaborationManager() {
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
    public static synchronized CollaborationManager getInstance() {
        if (instance == null) {
            instance = new CollaborationManager();
        }
        return instance;
    }
    
    public synchronized void insert(Collaboration pCollaboration) throws SQLException {
        try (Connection connect = DBConnection.getConnection()) {

            /*
             * Prepariamo la stringa SQL per inserire un nuovo record 
             * nella tabella phdCycle
             */
            String tSql = "INSERT INTO "
                    + CollaborationManager.TABLE_COLLABORATION
                    + " (istitution, description, startDate, endDate, FK_Student)"
                    + " VALUES ('"
                    + Utility.Replace(pCollaboration.getIstitution())
                    + "','"
                    + Utility.Replace(pCollaboration.getDescription())
                    + "','"
                    + pCollaboration.getStartDate()
                    + "','"
                    + pCollaboration.getEndDate() 
                    + "','"
                    + pCollaboration.getFK_Strudent()
                    + "')";

            System.out.println("La query: " +tSql);
            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        }
    }
          
    public synchronized void update(int oldCollaborationID, Collaboration pCollaboration) throws ClassNotFoundException, SQLException, IOException {
        try (Connection connect = DBConnection.getConnection()) {

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "UPDATE "
                    + CollaborationManager.TABLE_COLLABORATION
                    + " set istitution = '"
                    + Utility.Replace(pCollaboration.getIstitution())
                    + "', description = '"
                    + Utility.Replace(pCollaboration.getDescription())
                    + "', startDate = '"
                    + pCollaboration.getStartDate()
                    + "', endDate = '"
                    + pCollaboration.getEndDate()
                    + "' WHERE idCollaboration = "
                    + oldCollaborationID;           

            System.out.println(tSql);
            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        }
    }
    
    public synchronized void delete(String idCollaboration) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "DELETE FROM "
                    + CollaborationManager.TABLE_COLLABORATION
                    + " WHERE idCollaboration = '"
                    + idCollaboration + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }
    
    public synchronized Collaboration getCollaborationById(int pCollaborationID) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            Collaboration collaboration = new Collaboration();
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "SELECT * FROM "
                    + CollaborationManager.TABLE_COLLABORATION
                    + " WHERE idCollaboration = '"
                    + pCollaborationID + "'";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            if (result.next()) {
                collaboration.setIdCollaboration(result.getInt("idCollaboration"));
                collaboration.setIstitution(result.getString("istitution"));
                collaboration.setDescription(result.getString("description"));
                collaboration.setStartDate(result.getDate("startDate"));
                collaboration.setEndDate(result.getDate("endDate"));
                collaboration.setFK_Strudent(result.getString("FK_Student"));
            }

            return collaboration;

        } finally {
            DBConnection.releaseConnection(connect);
        }
    }
    
    public synchronized List<Collaboration> getAllCollaborationOf(Person pPerson) throws SQLException {
        List<Collaboration> collaborations = new ArrayList<Collaboration>();
        
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "SELECT * FROM "
                    + CollaborationManager.TABLE_COLLABORATION
                    + " WHERE FK_Student = '"
                    + pPerson.getSsn() + "'";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            while (result.next()) {
                Collaboration collaboration = new Collaboration();
                
                collaboration.setIdCollaboration(result.getInt("idCollaboration"));
                collaboration.setIstitution(result.getString("istitution"));
                collaboration.setDescription(result.getString("description"));
                collaboration.setStartDate(result.getDate("startDate"));
                collaboration.setEndDate(result.getDate("endDate"));
                collaboration.setFK_Strudent(result.getString("FK_Student"));
                
                collaborations.add(collaboration);
            }

        } finally {
            DBConnection.releaseConnection(connect);
        }
        
        
        return collaborations;
    }
}