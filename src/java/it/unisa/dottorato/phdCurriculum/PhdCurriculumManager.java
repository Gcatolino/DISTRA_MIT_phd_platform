package it.unisa.dottorato.phdCurriculum;

import it.unisa.dottorato.exception.ConnectionException;
import it.unisa.dottorato.exception.EntityNotFoundException;
import it.unisa.dottorato.utility.Utility;
import it.unisa.integrazione.database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhdCurriculumManager {

    /**
     * I nomi delle tabelle
     */
    private static final String TABLE_PHDCURRICULUM = "phdcurriculum";
    private static final String TABLE_PHDCLASS = "phdclass";

    //	 istanza della classe
    private static PhdCurriculumManager instance;

    /**
     * Il costruttore della classe e' dichiarato privato, per evitare
     * l'istanziazione di oggetti della classe .
     */
    private PhdCurriculumManager() {
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
    public static synchronized PhdCurriculumManager getInstance() {
        if (instance == null) {
            instance = new PhdCurriculumManager();
        }
        return instance;
    }

    /**
     * Metodo della classe incaricato dell'inserimento di una nuova entita'
     * nella tabella phdCurriculum del database.
     *
     * @param pCurriculum
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     * @throws it.unisa.dottorato.exception.ConnectionException
     */
    public synchronized void insert(PhdCurriculum pCurriculum) throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException, ConnectionException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per inserire un nuovo record 
             * nella tabella phdCurriculum
             */
            String tSql = "INSERT INTO "
                    + PhdCurriculumManager.TABLE_PHDCURRICULUM
                    + " (name, description, FK_professor)"
                    + " VALUES ('"
                    + pCurriculum.getName()
                    + "','"
                    + pCurriculum.getDescription()
                    + "','"
                    + pCurriculum.getFK_Professor()
                    + "')";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della modifica di un'entita' nella tabella
     * phdCurriculum del database.
     *
     * @param pCurriculum
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     * @throws it.unisa.dottorato.exception.ConnectionException
     */
    public synchronized void update(PhdCurriculum pCurriculum) throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException, ConnectionException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "UPDATE "
                    + PhdCurriculumManager.TABLE_PHDCURRICULUM
                    + " set name = '"
                    + pCurriculum.getName()
                    + "', description = '"
                    + pCurriculum.getDescription()
                    + "', FK_Professor = '"
                    + pCurriculum.getFK_Professor()
                    + "' WHERE idPhdCurriculum = '"
                    + pCurriculum.getName() + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della cancellazopme di un'entita'
     * nella tabella phdCurriculum del database.
     *
     * @param pCurriculum
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     * @throws it.unisa.dottorato.exception.ConnectionException
     */
    public synchronized void delete(PhdCurriculum pCurriculum) throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException, ConnectionException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "DELETE FROM "
                    + PhdCurriculumManager.TABLE_PHDCURRICULUM
                    + " WHERE name = '"
                    + pCurriculum.getName() + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della ricerca delle informazioni di un
     * curriculum relativo ad un ciclo.
     *
     * @param idPhdCycle
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     * @throws it.unisa.dottorato.exception.ConnectionException
     */
    public synchronized ArrayList<String> getPhdCurriculumNameByCycle(int idPhdCycle) throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException, ConnectionException {
        Connection connect = null;
        try {
            ArrayList<String> curriculum = new ArrayList<>();
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "SELECT FK_PhdCurriculum FROM "
                    + PhdCurriculumManager.TABLE_PHDCLASS
                    + " WHERE FK_PhdCycle = '"
                    + idPhdCycle + "'";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            while (result.next()) {
                curriculum.add(result.getString("FK_PhdCurriculum"));
            }

            return curriculum;

        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della ricerca dei curriculum esistenti.
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     * @throws it.unisa.dottorato.exception.ConnectionException
     */
    public synchronized ArrayList<String> getPhdCurriculumNames() throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException, ConnectionException {
        Connection connect = null;
        try {
            ArrayList<String> curriculum = new ArrayList<>();
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "SELECT name FROM "
                    + PhdCurriculumManager.TABLE_PHDCURRICULUM;

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            while (result.next()) {
                curriculum.add(result.getString("name"));
            }

            return curriculum;

        } finally {
            DBConnection.releaseConnection(connect);
        }
    }
}