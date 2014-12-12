/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.database;

import it.unisa.model.Account;
import it.unisa.model.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gemmacatolino
 */
public class PersonManagerTest {

    public PersonManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        
    }

    @After
    public void tearDown() {}

    /**
     * Test of getInstance method, of class PersonManager.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        PersonManager result = PersonManager.getInstance();
        assertNotNull(result);
    }

    /**
     * Test of add method, of class PersonManager.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        
        Account account = new Account();
        account.setActive(false);
        account.setEmail("prova@prova.it");
        account.setPassword("password");
        account.setTypeOfAccount("studente");
        
        Person person = new Person();

        person.setAccount(account);
        person.setAddress("Address");
        person.setCitizenship("Italiana");
        person.setCity("Salerno");

        person.setCycle(CycleManager.getInstance().getCycleByCycleNumber(2));
        person.setDepartment(DepartmentManager.getInstance().getDepartmentByAbbreviation("distra"));
        person.setDegree(DegreeManager.getInstance().getDegreeByTitle("MIT"));
                
        person.setGender("M");
        person.setMatricula("0057500157");
        person.setName("Gemma");
        person.setSurname("Catolino");
        person.setPhone("3491827332");
        person.setPosition("studente magistrale");
        person.setSsn("ABCDEF91M03F839I");
        person.setUniversity("University of Salerno");
        person.setWebPage("http://sito.jsp");
        person.setZipCode("84084");

        PersonManager.getInstance().add(person);

    }

    /**
     * Test of getPersonBySSN method, of class PersonManager.
     */
    @Test
    public void testGetPersonBySSN() throws Exception {
        System.out.println("getPersonBySSN");
        String ssn = "ABCDEF91M03F839I";
        
        Person result = PersonManager.getInstance().getPersonBySSN(ssn);
        assertEquals(ssn, result.getSsn());
    }

    /**
     * Test of getPersonByEmail method, of class PersonManager.
     */
    @Test
    public void testGetPersonByEmail() throws Exception {
        System.out.println("getPersonByEmail");
        String email = "prova@prova.it";
        
        Person result = PersonManager.getInstance().getPersonByEmail(email);
        assertEquals(email, result.getAccount().getEmail());
    }

}
