package it.unisa.dottorato.phdCurriculum;

import it.unisa.dottorato.exception.ConnectionException;
import it.unisa.dottorato.exception.EntityNotFoundException;
import it.unisa.dottorato.utility.Utility;
import it.unisa.integrazione.database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class ManagerPhdCurriculum {

    /**
     * Il nome della tabella
     */
    private static final String TABLE_PHDCURRICULUM = "phdcurriculum";

    //	 istanza della classe
    private static ManagerPhdCurriculum instance;

    /**
     * Il costruttore della classe e' dichiarato privato, per evitare
     * l'istanziazione di oggetti della classe .
     */
    private ManagerPhdCurriculum() {
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
    public static synchronized ManagerPhdCurriculum getInstance() {
        if (instance == null) {
            instance = new ManagerPhdCurriculum();
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
                    + ManagerPhdCurriculum.TABLE_PHDCURRICULUM
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
                    + ManagerPhdCurriculum.TABLE_PHDCURRICULUM
                    + " set name = '"
                    + pCurriculum.getName()
                    + "', description = '"
                    + pCurriculum.getDescription()
                    + "', FK_Professor = '"
                    + pCurriculum.getFK_Professor()
                    + "' WHERE idPhdCurriculum = '"
                    + pCurriculum.getIdPhdCurriculum() + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della cancellazopme di una nuova entita'
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
                    + ManagerPhdCurriculum.TABLE_PHDCURRICULUM
                    + " WHERE idPhdCurriculum = '"
                    + pCurriculum.getIdPhdCurriculum() + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }
}
