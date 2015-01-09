package it.unisa.integrazione.database;

import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.integrazione.database.exception.MissingDataException;
import it.unisa.integrazione.database.utility.Utilities;
import it.unisa.integrazione.model.Person;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author gemmacatolino
 */
public class PersonManager {

    private static PersonManager instance;

    public static PersonManager getInstance() {

        if (instance == null) {
            instance = new PersonManager();
        }
        return instance;

    }

    public void add(Person pPerson) throws SQLException, ConnectionException, MissingDataException {
        Connection connect = DBConnection.getConnection();

        if (CycleManager.getInstance().getCycleByCycleNumber(pPerson.getCycle().getCycleNumber()) == null) {
            throw new MissingDataException();
        }

        if (DepartmentManager.getInstance().getDepartmentByAbbreviation(pPerson.getDepartment().getAbbreviation()) == null) {
            DepartmentManager.getInstance().add(pPerson.getDepartment());
        }

        AccountManager.getInstance().add(pPerson.getAccount());

        String sql = "INSERT INTO person (SSN, person.name, surname, phone, "
                + "city, address, zip_code, gender, citizenship, Account_email, "
                + "Department_abbreviation, web_page, university, matricula, "
                + "position, cycle";

        if (pPerson.getDegree() != null) {
            sql += ",  degree_matricula, cover_letter) VALUES (";
        } else {
            sql += ", cover_letter) VALUES ( ";
        }

        sql += "\"" + pPerson.getSsn() + "\",\""
                + Utilities.emptyValue(pPerson.getName()) + "\",\"" + Utilities.emptyValue(pPerson.getSurname()) + "\",\""
                + Utilities.emptyValue(pPerson.getPhone()) + "\",\"" + Utilities.emptyValue(pPerson.getCity()) + "\",\""
                + Utilities.emptyValue(pPerson.getAddress()) + "\",\"" + Utilities.emptyValue(pPerson.getZipCode()) + "\",\""
                + Utilities.emptyValue(pPerson.getGender()) + "\",\"" + Utilities.emptyValue(pPerson.getCitizenship()) + "\",\""
                + pPerson.getAccount().getEmail() + "\",\""
                + Utilities.emptyValue(pPerson.getDepartment().getAbbreviation()) + "\",\""
                + Utilities.emptyValue(pPerson.getWebPage()) + "\",\"" + Utilities.emptyValue(pPerson.getUniversity()) + "\",\""
                + Utilities.emptyValue(pPerson.getMatricula()) + "\",\"" + Utilities.emptyValue(pPerson.getPosition()) + "\","
                + pPerson.getCycle().getCycleNumber();

        if (pPerson.getDegree() != null) {
            sql += ",\""
                    + Utilities.emptyValue(pPerson.getDegree().getMatricula()) + "\",\""
                    + Utilities.emptyValue(pPerson.getCoverLetter()) + "\")";
        } else {
            sql += ",\""
                    + Utilities.emptyValue(pPerson.getCoverLetter()) + "\")";
        }

        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(sql);
            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    public void update(Person pPerson) throws SQLException, ConnectionException, MissingDataException {
        Connection connect = DBConnection.getConnection();

        if (CycleManager.getInstance().getCycleByCycleNumber(pPerson.getCycle().getCycleNumber()) == null) {
            throw new MissingDataException();
        }

        if (DepartmentManager.getInstance().getDepartmentByAbbreviation(pPerson.getDepartment().getAbbreviation()) == null) {
            DepartmentManager.getInstance().add(pPerson.getDepartment());
        }

        String sql = "UPDATE person "
                + "set person.name = '"
                + pPerson.getName()
                + "', surname = '"
                + pPerson.getSurname()
                + "', phone = '"
                + pPerson.getPhone()
                + "', city = '"
                + pPerson.getCity()
                + "', address = '"
                + pPerson.getAddress()
                + "', zip_code = '"
                + pPerson.getZipCode()
                + "', gender = '"
                + pPerson.getGender()
                + "', citizenship = '"
                + pPerson.getCitizenship()
                + "', Account_email = '"
                + pPerson.getAccount().getEmail()
                + "', Department_abbreviation = '"
                + pPerson.getDepartment().getAbbreviation()
                + "', web_page = '"
                + pPerson.getWebPage()
                + "', university = '"
                + pPerson.getUniversity()
                + "', matricula = '"
                + pPerson.getMatricula()
                + "', position = '"
                + pPerson.getPosition()
                + "', cycle = '"
                + pPerson.getCycle().getCycleNumber()
                + "'";

        if (pPerson.getDegree() != null) {
            sql += ", degree_matricula = '"
                    + pPerson.getDegree().getMatricula()
                    + "'";
        }

        if (pPerson.getCoverLetter() != null) {
            sql += ", cover_letter = '"
                    + pPerson.getCoverLetter()
                    + "'";
        }

        sql += " WHERE SSN = '"
                + pPerson.getSsn()
                + "'";

        try {
            Statement stmt = connect.createStatement();
            stmt.executeUpdate(sql);
            connect.commit();
        } finally {
            DBConnection.releaseConnection(connect);
        }
    }

    public Person getPersonBySSN(String pSSN) throws SQLException, ConnectionException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        Person person = null;

        String query = "select * from person where SSN = '" + pSSN + "'";

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }

            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                person = new Person();
                person.setSsn(rs.getString("SSN"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setPhone(rs.getString("phone"));
                person.setCity(rs.getString("city"));
                person.setAddress(rs.getString("address"));
                person.setZipCode(rs.getString("zip_code"));
                person.setGender(rs.getString("gender"));
                person.setCitizenship(rs.getString("citizenship"));
                person.setWebPage(rs.getString("web_page"));
                person.setUniversity(rs.getString("university"));
                person.setMatricula(rs.getString("matricula"));
                person.setPosition(rs.getString("position"));
                person.setCoverLetter(rs.getString("cover_letter"));

                person.setDepartment(DepartmentManager.getInstance().getDepartmentByAbbreviation(rs.getString("Department_abbreviation")));
                person.setCycle(CycleManager.getInstance().getCycleByCycleNumber(rs.getInt("cycle")));
                person.setAccount(AccountManager.getInstance().getAccoutnByEmail(rs.getString("Account_email")));

                if (rs.getString("degree_matricula") != null) {
                    person.setDegree(DegreeManager.getInstance().readDegree(person.getMatricula()));
                }

            }
        } finally {
            DBConnection.releaseConnection(connection);
        }

        return person;
    }

    public Person getPersonByEmail(String pEmail) throws SQLException, ConnectionException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        Person person = null;

        String query = "select * from person where Account_email = '" + pEmail + "'";

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }

            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            if (rs.next()) {
                person = new Person();
                person.setSsn(rs.getString("SSN"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setPhone(rs.getString("phone"));
                person.setCity(rs.getString("city"));
                person.setAddress(rs.getString("address"));
                person.setZipCode(rs.getString("zip_code"));
                person.setGender(rs.getString("gender"));
                person.setCitizenship(rs.getString("citizenship"));
                person.setWebPage(rs.getString("web_page"));
                person.setUniversity(rs.getString("university"));
                person.setMatricula(rs.getString("matricula"));
                person.setPosition(rs.getString("position"));
                person.setCoverLetter(rs.getString("cover_letter"));

                person.setDepartment(DepartmentManager.getInstance().getDepartmentByAbbreviation(rs.getString("Department_abbreviation")));
                person.setCycle(CycleManager.getInstance().getCycleByCycleNumber(rs.getInt("cycle")));
                person.setAccount(AccountManager.getInstance().getAccoutnByEmail(pEmail));

                if (rs.getString("degree_matricula") != null) {
                    person.setDegree(DegreeManager.getInstance().readDegree(person.getMatricula()));
                }

            }
        } finally {

            DBConnection.releaseConnection(connection);
        }

        return person;
    }

    public void updateCoverLetter(String pCoverLetter, String pSnn) throws SQLException, ConnectionException {

        Statement stmt = null;
        Connection connection = null;

        String query = "update `db_distra`.`person` set cover_letter = '" + pCoverLetter + "' where SSN = '" + pSnn + "'";

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            connection.commit();
        } finally {
            DBConnection.releaseConnection(connection);
        }

    }
    
    public ArrayList<Person> getPersonByTypeOfAccount(String typeOfACcount) throws SQLException, ConnectionException {
        Statement stmt = null;
        ResultSet rs = null;
        Connection connection = null;
        Person aPerson = new Person();
        ArrayList<Person> person = new ArrayList<>();

        String query = "select * from person join account on account.email = person.Account_email where account.typeOfAccount = '" + typeOfACcount + "'";

        try {
            connection = DBConnection.getConnection();

            if (connection == null) {
                throw new ConnectionException();
            }

            stmt = connection.createStatement();
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                aPerson = new Person();
                aPerson.setSsn(rs.getString("SSN"));
                aPerson.setName(rs.getString("name"));
                aPerson.setSurname(rs.getString("surname"));
                aPerson.setPhone(rs.getString("phone"));
                aPerson.setCity(rs.getString("city"));
                aPerson.setAddress(rs.getString("address"));
                aPerson.setZipCode(rs.getString("zip_code"));
                aPerson.setGender(rs.getString("gender"));
                aPerson.setCitizenship(rs.getString("citizenship"));
                aPerson.setWebPage(rs.getString("web_page"));
                aPerson.setUniversity(rs.getString("university"));
                aPerson.setMatricula(rs.getString("matricula"));
                aPerson.setPosition(rs.getString("position"));
                
                person.add(aPerson);

            }
        } finally {

            if (rs != null) {
                rs.close();
            }

            if (stmt != null) {
                stmt.close();
            }

            if (connection != null) {
                connection.close();
            }
        }

        return person;
    }
}
