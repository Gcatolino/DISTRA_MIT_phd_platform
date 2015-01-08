package it.unisa.dottorato.phdPeople;

import it.unisa.dottorato.utility.Utility;
import it.unisa.integrazione.database.DBConnection;
import it.unisa.integrazione.model.Person;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Elisa D'Eugenio
 */
public class PhdPeopleManager {

    /**
     * I nomi delle tabelle
     */
    private static final String TABLE_PERSON = "person";
    private static final String TABLE_STUDENT_PHDCLASS = "student_phdclass";
    private static final String TABLE_PROFESSOR_PHDCYCLE = "professor_phdcycle";
    private static final String TABLE_PROFESSOR_PHDCURRICULUM = "professor_phdcurriculum";
    private static final String TABLE_PROFESSOR_STUDENT = "professor_student";
    private static final String TABLE_ACCOUNT = "account";

    //	 istanza della classe
    private static PhdPeopleManager instance;

    /**
     * Il costruttore della classe e' dichiarato privato, per evitare
     * l'istanziazione di oggetti della classe .
     */
    private PhdPeopleManager() {
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
    public static synchronized PhdPeopleManager getInstance() {
        if (instance == null) {
            instance = new PhdPeopleManager();
        }
        return instance;
    }

    /**
     * Metodo della classe incaricato della ricerca degli studenti di dottorato.
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized ArrayList<Person> getPhdStudents() throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;

        ArrayList<Person> students = new ArrayList<>();
        Person student = null;
        // Otteniamo una Connessione al DataBase
        connect = DBConnection.getConnection();

        /*
         * Prepariamo la stringa SQL per la ricerca dei record 
         * nella tabella Persone
         */
        String tSql = "SELECT * FROM "
                + PhdPeopleManager.TABLE_PERSON
                + " JOIN "
                + PhdPeopleManager.TABLE_STUDENT_PHDCLASS
                + " ON "
                + PhdPeopleManager.TABLE_PERSON
                + ".ssn = "
                + PhdPeopleManager.TABLE_STUDENT_PHDCLASS
                + ".FK_Student ORDER BY "
                + PhdPeopleManager.TABLE_PERSON
                + ".surname";

        //Inviamo la Query al DataBase
        ResultSet result = Utility.queryOperation(connect, tSql);

        while (result.next()) {
            student = new Person();
            student.setSsn(result.getString("ssn"));
            student.setName(result.getString("name"));
            student.setSurname(result.getString("surname"));
            student.setWebPage(result.getString("web_page"));
            students.add(student);
        }
        DBConnection.releaseConnection(connect);
        return students;

    }

    /**
     * Metodo della classe incaricato della ricerca delle informazioni di un
     * professore relativo ad un ciclo.
     *
     * @param idPhdCycle
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized ArrayList<Person> getProfessorByCycle(int idPhdCycle) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            ArrayList<Person> professors = new ArrayList<>();
            Person professor = null;
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella Person
             */
            String tSql = "SELECT * FROM "
                    + PhdPeopleManager.TABLE_PERSON
                    + "  JOIN "
                    + PhdPeopleManager.TABLE_PROFESSOR_PHDCYCLE
                    + " ON "
                    + PhdPeopleManager.TABLE_PERSON
                    + ".ssn = "
                    + PhdPeopleManager.TABLE_PROFESSOR_PHDCYCLE
                    + ".FK_Professor "
                    + " WHERE FK_PhdCycle = '"
                    + idPhdCycle + "'";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            while (result.next()) {
                professor = new Person();
                professor.setSsn(result.getString("ssn"));
                professor.setName(result.getString("name"));
                professor.setSurname(result.getString("surname"));
                professors.add(professor);
            }

            return professors;

        } finally {
            DBConnection.releaseConnection(connect);
        }

    }

    /**
     * Metodo della classe incaricato della ricerca delle informazioni di un
     * professore relativo ad un curriculum.
     *
     * @param idPhdCurriculum
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized ArrayList<Person> getProfessorByCurriculum(String idPhdCurriculum) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            ArrayList<Person> professors = new ArrayList<>();
            Person professor = null;
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella person
             */
            String tSql = "SELECT * FROM "
                    + PhdPeopleManager.TABLE_PERSON
                    + "  JOIN "
                    + PhdPeopleManager.TABLE_PROFESSOR_PHDCURRICULUM
                    + " ON "
                    + PhdPeopleManager.TABLE_PERSON
                    + ".ssn = "
                    + PhdPeopleManager.TABLE_PROFESSOR_PHDCURRICULUM
                    + ".FK_Professor "
                    + " WHERE FK_PhdCurriculum = '"
                    + idPhdCurriculum + "'";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            while (result.next()) {
                professor = new Person();
                professor.setSsn(result.getString("ssn"));
                professor.setName(result.getString("name"));
                professor.setSurname(result.getString("surname"));
                professors.add(professor);
            }

            return professors;

        } finally {
            DBConnection.releaseConnection(connect);
        }

    }

    /**
     * Metodo della classe incaricato della cancellazopme di un'entita' nella
     * tabella professor_phdCycle del database.
     *
     * @param idPhdCycle
     * @param idProfessor
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized void DeletProfessorFromCycle(String idPhdCycle, String idProfessor) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per la cancellazione un record 
             * nella tabella professor_phdCycle
             */
            String tSql = "DELETE FROM "
                    + PhdPeopleManager.TABLE_PROFESSOR_PHDCYCLE
                    + " WHERE FK_Professor = '"
                    + idProfessor + "' AND FK_PhdCycle = '"
                    + Integer.parseInt(idPhdCycle) + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della cancellazopme di un'entita' nella
     * tabella professor_phdCurriculum del database.
     *
     * @param idPhdCurriculum
     * @param idProfessor
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized void DeletProfessorFromCurriculum(String idPhdCurriculum, String idProfessor) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella professor_phdCurriculum
             */
            String tSql = "DELETE FROM "
                    + PhdPeopleManager.TABLE_PROFESSOR_PHDCURRICULUM
                    + " WHERE FK_Professor = '"
                    + idProfessor + "' AND FK_PhdCurriculum = '"
                    + idPhdCurriculum + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della ricerca dei professori non relativi ad un ciclo.
     *
     * @param idPhdCycle
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized ArrayList<Person> getPhdProfessorByDifferentCycle(int idPhdCycle) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            ArrayList<Person> professors = new ArrayList<>();
            Person professor = null;
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per la ricerca un record 
             * nella tabella professor_phdCycle
             */
            String tSql = "SELECT "
                    + PhdPeopleManager.TABLE_PERSON
                    + ".name FROM "
                    + PhdPeopleManager.TABLE_PERSON
                    + "  JOIN "
                    + PhdPeopleManager.TABLE_PROFESSOR_PHDCYCLE
                    + " ON "
                    + PhdPeopleManager.TABLE_PERSON
                    + ".ssn = "
                    + PhdPeopleManager.TABLE_PROFESSOR_PHDCYCLE
                    + ".FK_Professor "
                    + " WHERE "
                    + PhdPeopleManager.TABLE_PROFESSOR_PHDCYCLE
                    + ".FK_PhdCycle = '"
                    + +idPhdCycle
                    + "'";

            String tSql2 = "SELECT "
                    + PhdPeopleManager.TABLE_PERSON
                    + ".* FROM "
                    + PhdPeopleManager.TABLE_PERSON
                    + "  JOIN "
                    + PhdPeopleManager.TABLE_ACCOUNT
                    + " ON "
                    + PhdPeopleManager.TABLE_PERSON
                    + ".Account_email = "
                    + PhdPeopleManager.TABLE_ACCOUNT
                    + ".email "
                    + " WHERE "
                    + PhdPeopleManager.TABLE_ACCOUNT
                    + ".typeOfAccount = 'professor' and "
                    + PhdPeopleManager.TABLE_PERSON
                    + ".name not in ( "
                    + tSql
                    + " )";

            System.out.println(tSql2);
            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql2);

            while (result.next()) {
                professor = new Person();
                professor.setSsn(result.getString("ssn"));
                professor.setName(result.getString("name"));
                professor.setSurname(result.getString("surname"));
                professors.add(professor);
            }

            return professors;

        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della ricerca dei professori non relativi ad un ciclo.
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized ArrayList<Person> getPhdProfessorByDifferentCurriculum(String idPhdCurriculum) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            ArrayList<Person> professors = new ArrayList<>();
            Person professor = null;
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per la ricerca di un record 
             * nella tabella professor_phdCurriculum
             */
            String tSql = "SELECT "
                    + PhdPeopleManager.TABLE_PERSON
                    + ".name FROM "
                    + PhdPeopleManager.TABLE_PERSON
                    + "  JOIN "
                    + PhdPeopleManager.TABLE_PROFESSOR_PHDCURRICULUM
                    + " ON "
                    + PhdPeopleManager.TABLE_PERSON
                    + ".ssn = "
                    + PhdPeopleManager.TABLE_PROFESSOR_PHDCURRICULUM
                    + ".FK_Professor "
                    + " WHERE "
                    + PhdPeopleManager.TABLE_PROFESSOR_PHDCURRICULUM
                    + ".FK_PhdCurriculum = '"
                    + idPhdCurriculum
                    + "'";

            String tSql2 = "SELECT "
                    + PhdPeopleManager.TABLE_PERSON
                    + ".* FROM "
                    + PhdPeopleManager.TABLE_PERSON
                    + "  JOIN "
                    + PhdPeopleManager.TABLE_ACCOUNT
                    + " ON "
                    + PhdPeopleManager.TABLE_PERSON
                    + ".Account_email = "
                    + PhdPeopleManager.TABLE_ACCOUNT
                    + ".email "
                    + " WHERE "
                    + PhdPeopleManager.TABLE_ACCOUNT
                    + ".typeOfAccount = 'professor' and "
                    + PhdPeopleManager.TABLE_PERSON
                    + ".name not in ( "
                    + tSql
                    + " )";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql2);

            while (result.next()) {
                professor = new Person();
                professor.setSsn(result.getString("ssn"));
                professor.setName(result.getString("name"));
                professor.setSurname(result.getString("surname"));
                professors.add(professor);
            }

            return professors;

        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato dell'inserimento di una nuova entita'
     * nella tabella professor_phdClycle del database.
     *
     * @param aProfessor
     * @param aCycle
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized void insertProfessorPhdClass(String aProfessor, String aCycle) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per inserire un nuovo record 
             * nella tabella professor_phdClycle
             */
            String tSql = "INSERT INTO "
                    + PhdPeopleManager.TABLE_PROFESSOR_PHDCYCLE
                    + " (FK_professor, FK_PhdCycle)"
                    + " VALUES ('"
                    + aProfessor
                    + "','"
                    + aCycle
                    + "')";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato dell'inserimento di una nuova entita'
     * nella tabella professor_phdCurriculum del database.
     *
     * @param aProfCurriculum
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized void insertProfessorPhdCurriculum(Professor_phdCurriculum aProfCurriculum) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per inserire un nuovo record 
             * nella tabella professor_phdCurriculum
             */
            String tSql = "INSERT INTO "
                    + PhdPeopleManager.TABLE_PROFESSOR_PHDCURRICULUM
                    + " (FK_professor, FK_PhdCurriculum)"
                    + " VALUES ('"
                    + aProfCurriculum.getFK_Professor()
                    + "','"
                    + aProfCurriculum.getFK_PhdCurriculum()
                    + "')";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato dell'inserimento di una nuova entita'
     * nella tabella professor_student del database.
     *
     * @param tutor
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized void insertStudentTutor(Professor_student tutor) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per inserire un nuovo record 
             * nella tabella professor_student
             */
            String tSql = "INSERT INTO "
                    + PhdPeopleManager.TABLE_PROFESSOR_STUDENT
                    + " (FK_Professor, FK_Student)"
                    + " VALUES ('"
                    + tutor.getFK_Professor()
                    + "','"
                    + tutor.getFK_Student()
                    + "')";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della ricerca delle informazioni del tutor
     * relativo a uno studente.
     *
     * @param idStudent
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized Person getTutor(String idStudent) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            Person professor = null;
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per la ricerca di un record 
             * nella tabella professor_Student
             */
            String tSql = "SELECT * FROM "
                    + PhdPeopleManager.TABLE_PERSON
                    + "  JOIN "
                    + PhdPeopleManager.TABLE_PROFESSOR_STUDENT
                    + " ON "
                    + PhdPeopleManager.TABLE_PERSON
                    + ".ssn = "
                    + PhdPeopleManager.TABLE_PROFESSOR_STUDENT
                    + ".FK_Professor "
                    + " WHERE FK_Student = '"
                    + idStudent + "'";

            //Inviamo la Query al DataBase
            ResultSet result = Utility.queryOperation(connect, tSql);

            while (result.next()) {
                professor = new Person();
                professor.setSsn(result.getString("ssn"));
                professor.setName(result.getString("name"));
                professor.setSurname(result.getString("surname"));
            }

            return professor;

        } finally {
            DBConnection.releaseConnection(connect);
        }

    }

    /**
     * Metodo della classe incaricato della modifica di un'entita' nella tabella
     * professor_student del database.
     *
     * @param tutor
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized void updateStudentTutor(Professor_student tutor) throws ClassNotFoundException, SQLException, IOException {
        try (Connection connect = DBConnection.getConnection()) {

            /*
             * Prepariamo la stringa SQL per modificare un record 
             * nella tabella professor_student
             */
            String tSql = "UPDATE "
                    + PhdPeopleManager.TABLE_PROFESSOR_STUDENT
                    + " set FK_Professor = '"
                    + tutor.getFK_Professor()
                    + "' WHERE FK_Student = '"
                    + tutor.getFK_Student() + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        }
    }

    /**
     * Metodo della classe incaricato della cancellazopme di un'entita' nella
     * tabella professor_student del database.
     *
     * @param idStudent
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized void deleteStudentTutor(String idStudent) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;
        try {
            // Otteniamo una Connessione al DataBase
            connect = DBConnection.getConnection();

            /*
             * Prepariamo la stringa SQL per la cancellazione di un record 
             * nella tabella professor_student
             */
            String tSql = "DELETE FROM "
                    + PhdPeopleManager.TABLE_PROFESSOR_STUDENT
                    + " WHERE FK_Student = '"
                    + idStudent + "'";

            //Inviamo la Query al DataBase
            Utility.executeOperation(connect, tSql);

            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    /**
     * Metodo della classe incaricato della ricerca della lista docenti.
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized ArrayList<Person> getPhdProfessors() throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;

        ArrayList<Person> professors = new ArrayList<>();
        Person professor = null;
        // Otteniamo una Connessione al DataBase
        connect = DBConnection.getConnection();

        /*
         * Prepariamo la stringa SQL per la ricerca dei record 
         * nella tabella person
         */
        String tSql = "(SELECT "
                + TABLE_PERSON
                + ".* FROM "
                + PhdPeopleManager.TABLE_PERSON
                + " JOIN "
                + PhdPeopleManager.TABLE_PROFESSOR_PHDCYCLE
                + " ON "
                + PhdPeopleManager.TABLE_PERSON
                + ".ssn = "
                + PhdPeopleManager.TABLE_PROFESSOR_PHDCYCLE
                + ".FK_Professor ORDER BY "
                + PhdPeopleManager.TABLE_PERSON
                + ".surname) UNION (SELECT "
                + TABLE_PERSON
                + ".* FROM "
                + PhdPeopleManager.TABLE_PERSON
                + " JOIN "
                + PhdPeopleManager.TABLE_PROFESSOR_PHDCURRICULUM
                + " ON "
                + PhdPeopleManager.TABLE_PERSON
                + ".ssn = "
                + PhdPeopleManager.TABLE_PROFESSOR_PHDCURRICULUM
                + ".FK_Professor ORDER BY "
                + PhdPeopleManager.TABLE_PERSON
                + ".surname) ";

        //Inviamo la Query al DataBase
        ResultSet result = Utility.queryOperation(connect, tSql);

        while (result.next()) {
            professor = new Person();
            professor.setSsn(result.getString("ssn"));
            professor.setName(result.getString("name"));
            professor.setSurname(result.getString("surname"));
            professor.setWebPage(result.getString("web_page"));
            professors.add(professor);
        }
        DBConnection.releaseConnection(connect);
        return professors;

    }

    /**
     * Metodo della classe incaricato della ricerca delle informazioni di un
     * professore relativo ad un ciclo.
     *
     * @param aProfessor
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized ArrayList<String> getPhdProfessorCycle(String aProfessor) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;

        ArrayList<String> cycles = new ArrayList<>();
        // Otteniamo una Connessione al DataBase
        connect = DBConnection.getConnection();

        /*
         * Prepariamo la stringa SQL per modificare un record 
         * nella tabella professor_phdCycle
         */
        String tSql = "SELECT * FROM "
                + PhdPeopleManager.TABLE_PROFESSOR_PHDCYCLE
                + " WHERE FK_Professor = '"
                + aProfessor + "'";

        //Inviamo la Query al DataBase
        ResultSet result = Utility.queryOperation(connect, tSql);

        while (result.next()) {
            cycles.add(result.getString("FK_PhdCycle"));
        }
        DBConnection.releaseConnection(connect);
        return cycles;

    }
    
    /**
     * Metodo della classe incaricato della ricerca delle informazioni di un
     * professor relativo ad un curriculum.
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.io.IOException
     */
    public synchronized ArrayList<String> getPhdProfessorCurriculum(String aProfessor) throws ClassNotFoundException, SQLException, IOException {
        Connection connect = null;

        ArrayList<String> curriculums = new ArrayList<>();
        // Otteniamo una Connessione al DataBase
        connect = DBConnection.getConnection();

        /*
         * Prepariamo la stringa SQL per la ricerca di un record 
         * nella tabella professor_phdCurriculum
         */
        String tSql = "SELECT * FROM "
                + PhdPeopleManager.TABLE_PROFESSOR_PHDCURRICULUM
                + " WHERE FK_Professor = '"
                + aProfessor + "'";

        //Inviamo la Query al DataBase
        ResultSet result = Utility.queryOperation(connect, tSql);

        while (result.next()) {
            curriculums.add(result.getString("FK_PhdCurriculum"));
        }
        DBConnection.releaseConnection(connect);
        return curriculums;

    }
}
