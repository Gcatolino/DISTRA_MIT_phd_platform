/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.dottorato.phdProfile.publications;

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
public class PublicationManager {
    
    /**
     * Il nome della tabella
     */
    private static final String TABLE_PUBLICATION = "publication";
    
    //	 istanza della classe
    private static PublicationManager instance;

    /**
     * Il costruttore della classe e' dichiarato privato, per evitare
     * l'istanziazione di oggetti della classe .
     */
    private PublicationManager() {
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
    public static synchronized PublicationManager getInstance() {
        if (instance == null) {
            instance = new PublicationManager();
        }
        return instance;
    }
    
    public synchronized void insert(Publication pPublication) throws SQLException {
        try (Connection connect = DBConnection.getConnection()) {

            /*
             * Prepariamo la stringa SQL per inserire un nuovo record 
             * nella tabella phdCycle
             */
            String tSql = "INSERT INTO "
                    + PublicationManager.TABLE_PUBLICATION
                    + " (title, authors, abstract, year, type, publicationIssue, numberPages, FK_Student)"
                    + " VALUES ('"
                    + Utility.Replace(pPublication.getTitle())
                    + "','"
                    + Utility.Replace(pPublication.getAuthors())
                    + "','"
                    + Utility.Replace(pPublication.getAbstractText())
                    + "','"
                    + Utility.Replace(pPublication.getYear())
                    + "','"
                    + Utility.Replace(pPublication.getType())
                    + "','"
                    + Utility.Replace(pPublication.getPublicationIssue())
                    + "',"
                    + pPublication.getNumberPages()
                    + ",'"
                    + pPublication.getFK_Strudent()
                    + "')";

            System.out.println("La query: " +tSql);
            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        }
    }
          
    public synchronized void update(int oldPublicationID, Publication pPublication) throws ClassNotFoundException, SQLException, IOException {
        try (Connection connect = DBConnection.getConnection()) {

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "UPDATE "
                    + PublicationManager.TABLE_PUBLICATION
                    + " set title = '"
                    + Utility.Replace(pPublication.getTitle())
                    + "', authors = '"
                    + Utility.Replace(pPublication.getAuthors())
                    + "', abstract = '"
                    + Utility.Replace(pPublication.getAbstractText())
                    + "', year = '"
                    + pPublication.getYear()
                    + "', type = '"
                    + Utility.Replace(pPublication.getType())
                    + "', publicationIssue = '"
                    + Utility.Replace(pPublication.getPublicationIssue())
                    + "', numberPages = "
                    + pPublication.getNumberPages()
                    + " WHERE idPublication = "
                    + oldPublicationID + "";           

            System.out.println(tSql);
            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        }
    }
    
    public synchronized void delete(String idPublication) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "DELETE FROM "
                    + PublicationManager.TABLE_PUBLICATION
                    + " WHERE idPublication = '"
                    + idPublication + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }
    
    public synchronized Publication getPublicationById(int pPublicationID) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            Publication publication = new Publication();
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "SELECT * FROM "
                    + PublicationManager.TABLE_PUBLICATION
                    + " WHERE idPublication = '"
                    + pPublicationID + "'";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            if (result.next()) {
                publication.setIdPublication(result.getInt("idPublication"));
                publication.setTitle(result.getString("title"));
                publication.setAuthors(result.getString("authors"));
                publication.setAbstractText(result.getString("abstract"));
                publication.setFilePath(result.getString("file"));
                publication.setYear(result.getString("year"));
                publication.setType(result.getString("type"));
                publication.setPublicationIssue(result.getString("publicationIssue"));
                publication.setNumberPages(result.getInt("numberPages"));
                publication.setFK_Student(result.getString("FK_Student"));
            }

            return publication;

        } finally {
            DBConnection.releaseConnection(connect);
        }
    }
    
    public synchronized List<Publication> getAllPublicationsOf(Person pPerson) throws SQLException {
        List<Publication> publications = new ArrayList<Publication>();
        
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "SELECT * FROM "
                    + PublicationManager.TABLE_PUBLICATION
                    + " WHERE FK_Student = '"
                    + pPerson.getSsn() + "'";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            while (result.next()) {
                Publication publication = new Publication();
                
                publication.setIdPublication(result.getInt("idPublication"));
                publication.setTitle(result.getString("title"));
                publication.setAuthors(result.getString("authors"));
                publication.setAbstractText(result.getString("abstract"));
                publication.setFilePath(result.getString("file"));
                publication.setYear(result.getString("year"));
                publication.setType(result.getString("type"));
                publication.setPublicationIssue(result.getString("publicationIssue"));
                publication.setNumberPages(result.getInt("numberPages"));
                publication.setFK_Student(result.getString("FK_Student"));
                
                publications.add(publication);
            }

        } finally {
            DBConnection.releaseConnection(connect);
        }
        
        
        return publications;
    }
}