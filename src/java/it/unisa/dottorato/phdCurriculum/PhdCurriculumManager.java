package it.unisa.dottorato.phdCurriculum;

import it.unisa.dottorato.utility.Utility;
import it.unisa.integrazione.database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Elisa D'Eugenio
 */
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
     * @throws java.io.IOException
     */
    public synchronized void insert(PhdCurriculum pCurriculum) throws ClassNotFoundException, SQLException, IOException {
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
                    + Utility.Replace(pCurriculum.getName())
                    + "','"
                    + Utility.Replace(pCurriculum.getDescription())
                    + "',"
                    + Utility.emptyValue(pCurriculum.getFK_Professor())
                    + ")";

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
     * @param oldNamePhdCurriculum
     * @param pCurriculum
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized void update(String oldNamePhdCurriculum, PhdCurriculum pCurriculum) throws ClassNotFoundException, SQLException, IOException {
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
                    + Utility.Replace(pCurriculum.getName())
                    + "', description = '"
                    + Utility.Replace(pCurriculum.getDescription())
                    + "', FK_Professor = "
                    + Utility.emptyValue(pCurriculum.getFK_Professor())
                    + " WHERE name = '"
                    + oldNamePhdCurriculum + "'";
            System.out.println(tSql);
            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della cancellazopme di un'entita' nella
     * tabella phdCurriculum del database.
     *
     * @param phdCurriculumName
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized void delete(String phdCurriculumName) throws ClassNotFoundException, SQLException, IOException {
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
                    + Utility.Replace(phdCurriculumName) + "'";

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
     * @throws java.io.IOException
     */
    public synchronized ArrayList<String> getPhdCurriculumNameByCycle(int idPhdCycle) throws ClassNotFoundException, SQLException, IOException {
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
                    + PhdCurriculumManager.TABLE_PHDCURRICULUM
                    + "  JOIN "
                    + PhdCurriculumManager.TABLE_PHDCLASS
                    + " ON "
                    + PhdCurriculumManager.TABLE_PHDCURRICULUM
                    + ".name = "
                    + PhdCurriculumManager.TABLE_PHDCLASS
                    + ".FK_PhdCurriculum "
                    + " WHERE FK_PhdCycle = '"
                    + idPhdCycle + "'";

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
    
    
    /**
     * Metodo della classe incaricato della ricerca delle informazioni di un
     * curriculum non relativo ad un ciclo.
     *
     * @param idPhdCycle
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized ArrayList<String> getPhdCurriculumNameByDifferentCycle(int idPhdCycle) throws ClassNotFoundException, SQLException, IOException {
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
                    + PhdCurriculumManager.TABLE_PHDCURRICULUM
                    + "  JOIN "
                    + PhdCurriculumManager.TABLE_PHDCLASS
                    + " ON "
                    + PhdCurriculumManager.TABLE_PHDCURRICULUM
                    + ".name = "
                    + PhdCurriculumManager.TABLE_PHDCLASS
                    + ".FK_PhdCurriculum "
                    + " WHERE FK_PhdCycle = '"
                    + idPhdCycle + "'";
            
            String tSql2 = "SELECT name FROM "
                    + PhdCurriculumManager.TABLE_PHDCURRICULUM
                    + " WHERE name not in ( "
                    + tSql
                    + " )";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql2);

            while (result.next()) {
                curriculum.add(result.getString("name"));
            }

            return curriculum;

        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della ricerca di un curriculum esistente.
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized ArrayList<String> getPhdCurriculumNames() throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            ArrayList<String> curriculum = new ArrayList<>();
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCurriculum
             */
            String tSql = "SELECT name FROM "
                    + PhdCurriculumManager.TABLE_PHDCURRICULUM
                    + " ORDER BY name desc";

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

    /**
     * Metodo della classe incaricato della ricerca delle informazioni di un
     * curriculum contenuto nella tabella phdCurriculum.
     *
     * @param phdCurriculumName
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized PhdCurriculum getPhdCurriculumById(String phdCurriculumName) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            PhdCurriculum curriculum = new PhdCurriculum();
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCurriculum
             */
            String tSql = "SELECT * FROM "
                    + PhdCurriculumManager.TABLE_PHDCURRICULUM
                    + " WHERE name = '"
                    + phdCurriculumName + "'";
            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            if (result.next()) {
                curriculum.setDescription(result.getString("description"));
                curriculum.setName(result.getString("name"));
                curriculum.setFK_Professor(result.getString("FK_Professor"));
            }

            return curriculum;

        } finally {
            DBConnection.releaseConnection(connect);
        }
    }
}
