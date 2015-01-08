package it.unisa.dottorato.phdProfile.publications;

import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.integrazione.database.exception.MissingDataException;
import it.unisa.integrazione.model.Account;
import it.unisa.integrazione.model.Cycle;
import it.unisa.integrazione.model.Department;
import it.unisa.integrazione.model.Person;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fudo
 */
public class PublicationManagerTest {
    
    static Account pAccount = null;
    static Department aDepartment = null;
    static Person pPerson = null;
    static Cycle aCycle = null;
    static Publication pPublication = null;
    static PublicationManager instance = PublicationManager.getInstance();
    
    public PublicationManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException, ConnectionException, MissingDataException {
        
        System.out.println("Inserimento iniziale dell'utente Mario Rossi nel database.");
        
        pAccount = new Account();
        pAccount.setActive(true);
        pAccount.setEmail("test@unisa.it");
        pAccount.setPassword("test");
        pAccount.setTypeOfAccount("phd");
        
        aDepartment = new Department();
        aDepartment.setTitle("Dipartimento di Economia");
        aDepartment.setAbbreviation("die");
        
        aCycle = new Cycle();
        aCycle.setCycleNumber(10);
        aCycle.setTitle("Ciclo di test");
        
        pPerson = new Person();
        pPerson.setAccount(pAccount);
        pPerson.setSsn("QWERTYUIOPASDFGH");
        pPerson.setName("Mario");
        pPerson.setSurname("Rossi");
        pPerson.setDepartment(aDepartment);
        pPerson.setCycle(aCycle);
        pPerson.setAddress(null);
        pPerson.setCitizenship(null);
        pPerson.setCity(null);
        pPerson.setDegree(null);
        pPerson.setGender("M");
        pPerson.setMatricula(null);
        pPerson.setPhone(null);
        pPerson.setPosition(null);
        pPerson.setUniversity(null);
        pPerson.setWebPage(null);
        pPerson.setZipCode(null);
        
        
        //DepartmentManager.getInstance().add(aDepartment);
        //CycleManager.getInstance().add(aCycle);
        //PersonManager.getInstance().add(pPerson);
  
    }
    
    @AfterClass
    public static void tearDownClass() {        
        
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }



    /**
     * Test of insert method, of class PublicationManager.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("Inserimento di una pubblicazione");
        pPublication = new Publication();
        pPublication.setFK_Student("QWERTYUIOPASDFGH");
        pPublication.setTitle("Lo sviluppo del settore terziazio");
        pPublication.setAuthors("Mario Rossi, Luigi Verdi, Davide Bianchi");
        pPublication.setYear("2013");
        pPublication.setAbstractText("La pubblicazione si occupa di descrivere le modalità...");
        pPublication.setType("Journal");
        pPublication.setPublicationIssue("Journal Economy");
        pPublication.setNumberPages(20);
        
        instance.insert(pPublication);        
        
        assertNotNull(instance.getPublicationById(pPublication.getIdPublication()));
    }
    
   /**
     * Test of insert method, of class PublicationManager.
     */
    @Test
    public void testInsertTitle() throws Exception {
        System.out.println("Inserimento di una pubblicazione");
        pPublication = new Publication();
        pPublication.setFK_Student("QWERTYUIOPASDFGH");
        pPublication.setTitle("");
        pPublication.setAuthors("Mario Rossi, Luigi Verdi, Davide Bianchi");
        pPublication.setYear("2013");
        pPublication.setAbstractText("La pubblicazione si occupa di descrivere le modalità...");
        pPublication.setType("Journal");
        pPublication.setPublicationIssue("Journal Economy");
        pPublication.setNumberPages(20);
        
        instance.insert(pPublication);        
        
        assertNotNull(instance.getPublicationById(pPublication.getIdPublication()));
    }
    
       /**
     * Test of insert method, of class PublicationManager.
     */
    @Test
    public void testInsertYear() throws Exception {
        System.out.println("Inserimento di una pubblicazione");
        pPublication = new Publication();
        pPublication.setFK_Student("QWERTYUIOPASDFGH");
        pPublication.setTitle("Lo sviluppo del settore terziazio");
        pPublication.setAuthors("Mario Rossi, Luigi Verdi, Davide Bianchi");
        pPublication.setYear("");
        pPublication.setAbstractText("La pubblicazione si occupa di descrivere le modalità...");
        pPublication.setType("Journal");
        pPublication.setPublicationIssue("Journal Economy");
        pPublication.setNumberPages(20);
        
        instance.insert(pPublication);        
        
        assertNotNull(instance.getPublicationById(pPublication.getIdPublication()));
    }
    
       /**
     * Test of insert method, of class PublicationManager.
     */
    @Test
    public void testInsertNumPages() throws Exception {
        System.out.println("Inserimento di una pubblicazione");
        pPublication = new Publication();
        pPublication.setFK_Student("QWERTYUIOPASDFGH");
        pPublication.setTitle("Lo sviluppo del settore terziazio");
        pPublication.setAuthors("Mario Rossi, Luigi Verdi, Davide Bianchi");
        pPublication.setYear("2013");
        pPublication.setAbstractText("La pubblicazione si occupa di descrivere le modalità...");
        pPublication.setType("Journal");
        pPublication.setPublicationIssue("Journal Economy");
        pPublication.setNumberPages(-1);
        
        instance.insert(pPublication);        
        
        assertNotNull(instance.getPublicationById(pPublication.getIdPublication()));
    }
    
}
