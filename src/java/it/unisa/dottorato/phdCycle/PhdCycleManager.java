package it.unisa.dottorato.phdCycle;

import it.unisa.dottorato.exception.ConnectionException;
import it.unisa.dottorato.exception.EntityNotFoundException;
import it.unisa.dottorato.utility.Utility;
import it.unisa.integrazione.database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhdCycleManager {

    /**
     * Il nome della tabella
     */
    private static final String TABLE_PHDCYCLE = "phdcycle";

    //	 istanza della classe
    private static PhdCycleManager instance;

    /**
     * Il costruttore della classe e' dichiarato privato, per evitare
     * l'istanziazione di oggetti della classe .
     */
    private PhdCycleManager() {
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
    public static synchronized PhdCycleManager getInstance() {
        if (instance == null) {
            instance = new PhdCycleManager();
        }
        return instance;
    }

    /**
     * Metodo della classe incaricato dell'inserimento di una nuova entita'
     * nella tabella phdCycle del database.
     *
     * @param pCycle
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     * @throws it.unisa.dottorato.exception.ConnectionException
     */
    public synchronized void insert(PhdCycle pCycle) throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException, ConnectionException {
        try (Connection connect = DBConnection.getConnection()) {

            /*
             * Prepariamo la stringa SQL per inserire un nuovo record 
             * nella tabella phdCycle
             */
            String tSql = "INSERT INTO "
                    + PhdCycleManager.TABLE_PHDCYCLE
                    + " (idPhdCycle, description, year, FK_professor)"
                    + " VALUES ('"
                    + pCycle.getIdPhdCycle()
                    + "','"
                    + pCycle.getDescription()
                    + "','"
                    + pCycle.getYear()
                    + "','"
                    + pCycle.getFK_Professor()
                    + "')";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        }
    }

    /**
     * Metodo della classe incaricato della modifica di un'entita' nella
     * tabella phdCycle del database.
     *
     * @param pCycle
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     * @throws it.unisa.dottorato.exception.ConnectionException
     */
    public synchronized void update(PhdCycle pCycle) throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException, ConnectionException {
        try (Connection connect = DBConnection.getConnection()) {

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "UPDATE "
                    + PhdCycleManager.TABLE_PHDCYCLE
                    + " set description = '"
                    + pCycle.getDescription()
                    + "', year = '"
                    + pCycle.getYear()
                    + "', FK_Professor = '"
                    + pCycle.getFK_Professor()
                    + "' WHERE idPhdCycle = '"
                    + pCycle.getIdPhdCycle() + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        }
    }

    /**
     * Metodo della classe incaricato della cancellazopme di un'entita'
     * nella tabella phdCycle del database.
     *
     * @param pCycle
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     * @throws it.unisa.dottorato.exception.ConnectionException
     */
    public synchronized void delete(PhdCycle pCycle) throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException, ConnectionException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "DELETE FROM "
                    + PhdCycleManager.TABLE_PHDCYCLE
                    + " WHERE idPhdCycle = '"
                    + pCycle.getIdPhdCycle() + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della ricerca delle informazioni di un 
     * ciclo contenuto nella tabella phdCycle.
     *
     * @param idPhdCycle
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     * @throws it.unisa.dottorato.exception.ConnectionException
     */
    public synchronized PhdCycle getPhdCycleById(int idPhdCycle) throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException, ConnectionException {
        Connection connect = null;
        try {
            PhdCycle cycle = new PhdCycle();
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "SELECT * FROM "
                    + PhdCycleManager.TABLE_PHDCYCLE
                    + " WHERE idPhdCycle = '"
                    + idPhdCycle + "'";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            if (result.next()) {
                cycle.setIdPhdCycle(result.getInt("idPhdCycle"));
                cycle.setDescription(result.getString("description"));
                cycle.setYear(result.getInt("year"));
                cycle.setFK_Professor(result.getString("FK_Professor"));
            }

            return cycle;

        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della ricerca dei cicli esistenti.
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     * @throws it.unisa.dottorato.exception.ConnectionException
     */
    public synchronized ArrayList<String> getPhdCyclesIds() throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException, ConnectionException {
        Connection connect = null;
        try {
            ArrayList<String> cycles = new ArrayList<>();
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "SELECT IdPhdCycle FROM "
                    + PhdCycleManager.TABLE_PHDCYCLE;

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            while (result.next()) {
                cycles.add(result.getString("IdPhdCycle"));
            }

            return cycles;

        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

}
