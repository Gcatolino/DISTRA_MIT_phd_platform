/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.dottorato.phdClass;

import it.unisa.dottorato.exception.EntityNotFoundException;
import it.unisa.dottorato.phdCurriculum.PhdCurriculumManager;
import it.unisa.dottorato.phdCycle.PhdCycle;
import it.unisa.dottorato.phdCycle.PhdCycleManager;
import it.unisa.dottorato.utility.Utility;
import it.unisa.integrazione.database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Elisa
 */
public class PhdClassManager {

    private static final String TABLE_PHDCLASS = "phdclass";
    private static final String TABLE_PHDSTUDENT_PHDCLASS = "student_phdclass";
    private static final String TABLE_PERSON = "person";

    //	 istanza della classe
    private static PhdClassManager instance;

    /**
     * Il costruttore della classe e' dichiarato privato, per evitare
     * l'istanziazione di oggetti della classe .
     */
    private PhdClassManager() {
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
    public static synchronized PhdClassManager getInstance() {
        if (instance == null) {
            instance = new PhdClassManager();
        }
        return instance;
    }

    /**
     * Metodo della classe incaricato dell'inserimento di una nuova entita'
     * nella tabella phdCycle del database.
     *
     * @param pClass
     * @param pCycle
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     */
    public synchronized void insert(PhdClass pClass) throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException {
        try (Connection connect = DBConnection.getConnection()) {

            /*
             * Prepariamo la stringa SQL per inserire un nuovo record 
             * nella tabella phdCycle
             */
            String tSql = "INSERT INTO "
                    + PhdClassManager.TABLE_PHDCLASS
                    + " (FK_PhdCurriculum, FK_PhdCycle)"
                    + " VALUES ('"
                    + pClass.getFK_PhdCurriculum()
                    + "','"
                    + pClass.getFK_PhdCycle()
                    + "')";

            System.out.println(tSql);
            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        }
    }

    /**
     * Metodo della classe incaricato dell'inserimento di una nuova entita'
     * nella tabella phdCycle del database.
     *
     * @param pClass
     * @param pCycle
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     */
    public synchronized void insertStudentPhdClass(Student_phdClass studentClass) throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException {
        try (Connection connect = DBConnection.getConnection()) {

            /*
             * Prepariamo la stringa SQL per inserire un nuovo record 
             * nella tabella phdCycle
             */
            String tSql = "INSERT INTO "
                    + PhdClassManager.TABLE_PHDSTUDENT_PHDCLASS
                    + " (FK_Student, FK_PhdClass)"
                    + " VALUES ('"
                    + studentClass.getFK_Student()
                    + "','"
                    + studentClass.getFK_PhdClass()
                    + "')";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        }
    }

    /**
     * Metodo della classe incaricato della modifica di un'entita' nella tabella
     * phdCycle del database.
     *
     * @param oldIdPhdCycle
     * @param pCycle
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     */
    public synchronized void updateStudentPhdClass(Student_phdClass studentClass) throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException {
        try (Connection connect = DBConnection.getConnection()) {

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "UPDATE "
                    + PhdClassManager.TABLE_PHDSTUDENT_PHDCLASS
                    + " set FK_PhdClass = '"
                    + studentClass.getFK_PhdClass()
                    + "' WHERE FK_Student = '"
                    + studentClass.getFK_Student() + "'";

            System.out.println(tSql);

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        }
    }

    /**
     * Metodo della classe incaricato della cancellazopme di un'entita' nella
     * tabella phdCurriculum del database.
     *
     * @param phdCurriculumName
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     */
    public synchronized void delete(String idPhdCycle, String idPhdCurriculum) throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "DELETE FROM "
                    + PhdClassManager.TABLE_PHDCLASS
                    + " WHERE FK_PhdCycle = '"
                    + idPhdCycle + "' AND "
                    +" FK_PhdCurriculum = '"
                    + Utility.Replace(idPhdCurriculum) + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della cancellazopme di un'entita' nella
     * tabella phdCycle del database.
     *
     * @param idPhdCycle
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws it.unisa.dottorato.exception.EntityNotFoundException
     * @throws java.io.IOException
     */
    public synchronized void deleteStudentPhdClass(String pSSN) throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "DELETE FROM "
                    + PhdClassManager.TABLE_PHDSTUDENT_PHDCLASS
                    + " WHERE FK_Student = '"
                    + pSSN + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
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
     */
    public synchronized ArrayList<PhdClass> getPhdClassList() throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException {
        Connection connect = null;
        try {
            ArrayList<PhdClass> classList = new ArrayList<>();
            PhdClass aPhdClass;
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "SELECT * FROM "
                    + PhdClassManager.TABLE_PHDCLASS
                    + " ORDER BY idClass desc";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            while (result.next()) {
                aPhdClass = new PhdClass();
                aPhdClass.setIdClass(result.getInt("idClass"));
                aPhdClass.setFK_PhdCycle(result.getInt("FK_PhdCycle"));
                aPhdClass.setFK_PhdCurriculum(result.getString("FK_PhdCurriculum"));

                classList.add(aPhdClass);
            }

            return classList;

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
     */
    public synchronized PhdClass getPhdClassBySSN(String pSSN) throws ClassNotFoundException, SQLException, IOException, EntityNotFoundException {
        Connection connect = null;
        try {
            PhdClass aPhdClass = null;
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella phdCycle
             */
            String tSql = "SELECT "
                    + PhdClassManager.TABLE_PHDCLASS
                    + ".* FROM "
                    + PhdClassManager.TABLE_PHDSTUDENT_PHDCLASS
                    + " JOIN "
                    + PhdClassManager.TABLE_PERSON
                    + " ON "
                    + PhdClassManager.TABLE_PERSON
                    + ".SSN = "
                    + PhdClassManager.TABLE_PHDSTUDENT_PHDCLASS
                    + ".FK_Student "
                    + " JOIN "
                    + PhdClassManager.TABLE_PHDCLASS
                    + " ON "
                    + PhdClassManager.TABLE_PHDSTUDENT_PHDCLASS
                    + ".FK_PhdClass = "
                    + PhdClassManager.TABLE_PHDCLASS
                    + ".idClass "
                    + " WHERE "
                    + PhdClassManager.TABLE_PERSON
                    + ".SSN = '"
                    + pSSN + "'";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            if (result.next()) {
                aPhdClass = new PhdClass();
                aPhdClass.setIdClass(result.getInt("idClass"));
                aPhdClass.setFK_PhdCycle(result.getInt("FK_PhdCycle"));
                aPhdClass.setFK_PhdCurriculum(result.getString("FK_PhdCurriculum"));

            }

            return aPhdClass;

        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

}
