/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.dottorato.phdProfile.missions;

import it.unisa.integrazione.database.exception.ConnectionException;
import it.unisa.integrazione.database.exception.MissingDataException;
import it.unisa.integrazione.model.Account;
import it.unisa.integrazione.model.Cycle;
import it.unisa.integrazione.model.Department;
import it.unisa.integrazione.model.Person;
import java.sql.Date;
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
public class MissionManagerTest {
    static Account pAccount = null;
    static Department aDepartment = null;
    static Person pPerson = null;
    static Cycle aCycle = null;
    static Mission pMission = null;
    static MissionManager instance = MissionManager.getInstance();
    
    public MissionManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws SQLException, ConnectionException, MissingDataException {
        
        System.out.println("Inserimento iniziale dell'utente Mario Rossi nel database.");
        
        pAccount = new Account();
        pAccount.setActive(true);
        pAccount.setEmail("test2@unisa.it");
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
        pPerson.setSsn("QWERTYUROPASDFGH");
        pPerson.setName("Antonio");
        pPerson.setSurname("Verdi");
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
    
 @Test
    public void testInsert() throws Exception {
        System.out.println("Inserimento di una pubblicazione");
        pMission = new Mission();
        pMission.setFK_Student("QWERTYUROPASDFGH");
        pMission.setDescription("Descrizione");
        pMission.setPlace("Place");
        pMission.setStartDate(new Date(2013, 12, 12));
        pMission.setEndDate(new Date(2014, 03, 03));
        
        instance.insert(pMission);        
        
        assertNotNull(instance.getMissionById(pMission.getIdMission()));
    }
    
}
