/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.dottorato.phdCurriculum;

import it.unisa.dottorato.phdCycle.PhdCycleManager;
import it.unisa.dottorato.phdCycle.PhdCycleManagerTest;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PhdCurriculumManagerTest {
    
    public PhdCurriculumManagerTest() {
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
    public void tearDown() {
        
        try {
            PhdCycleManager.getInstance().delete("11");
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(PhdCycleManagerTest.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     * Test of getInstance method, of class PhdCycleManager.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        PhdCurriculumManager result = PhdCurriculumManager.getInstance();
        assertNotNull(result);
    }

    /**
     * Test of insert method, of class PhdCycleManager.
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        PhdCurriculum pCurriculum = new PhdCurriculum();
        PhdCurriculumManager instance = PhdCurriculumManager.getInstance();
        pCurriculum.setName("Informatica");
        pCurriculum.setDescription("descrizione");
        pCurriculum.setFK_Professor("CTLGMM91A71B519A");
        instance.insert(pCurriculum);
        
        PhdCurriculum result = instance.getPhdCurriculumById("Informatica");
        assertNotNull(result);
        
        tearDown();
    }
    
    
    @Test
    public void testInsertMinNameCurriculum() throws Exception {
        System.out.println("insert");
        PhdCurriculum pCurriculum = new PhdCurriculum();
        PhdCurriculumManager instance = PhdCurriculumManager.getInstance();
        pCurriculum.setName("info");
        pCurriculum.setDescription("descrizione");
        pCurriculum.setFK_Professor("CTLGMM91A71B519A");
        instance.insert(pCurriculum);
        
        PhdCurriculum result = instance.getPhdCurriculumById("Informatica");
        assertNotNull(result);
        
        tearDown();
    }
    
    @Test
    public void testInsertMaxNameCurriculum() throws Exception {
        System.out.println("insert");
        PhdCurriculum pCurriculum = new PhdCurriculum();
        PhdCurriculumManager instance = PhdCurriculumManager.getInstance();
        pCurriculum.setName("DGASHDGHASGDJHASGDHJGASHJDHJASGDGASJHGDJHASGJHDGASJHGDHJASGDJHASGJHDGASHJGDHASGJHDGASJHDGJHASGDJHASGJHDGJASHGDHJASGHJDGASHJGDJHSAGFDSHASHJDGASJHDGAHJSGDHJASGDJHASGJHDGASJHDGASHJGDHJASGDJHASGJDHASGJHDGASHJDGASHJDGHJASGDJHASGDJHAGHDJASGJJHDGASJHGD");
        pCurriculum.setDescription("descrizione");
        pCurriculum.setFK_Professor("CTLGMM91A71B519A");
        instance.insert(pCurriculum);
        
        PhdCurriculum result = instance.getPhdCurriculumById("Informatica");
        assertNotNull(result);
        
        tearDown();
    }
    
    @Test
    public void testInsertFormatNameCurriculum() throws Exception {
        System.out.println("insert");
        PhdCurriculum pCurriculum = new PhdCurriculum();
        PhdCurriculumManager instance = PhdCurriculumManager.getInstance();
        pCurriculum.setName("&&&&&&&&&&&&&&");
        pCurriculum.setDescription("descrizione");
        pCurriculum.setFK_Professor("CTLGMM91A71B519A");
        instance.insert(pCurriculum);
        
        PhdCurriculum result = instance.getPhdCurriculumById("Informatica");
        assertNotNull(result);
        
        tearDown();
    }
    
    

    /**
     * Test of update method, of class PhdCycleManager.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        PhdCurriculumManager instance = PhdCurriculumManager.getInstance();
        PhdCurriculum pCurriculum = new PhdCurriculum();
        String oldCurriculum = pCurriculum.getDescription();
        pCurriculum.setDescription("UpdateDescrizione");
        pCurriculum.setName("UpdateInformatica");
        pCurriculum.setFK_Professor("CTLGMM91A71B519A");
        
        instance.update(oldCurriculum, pCurriculum);
        assertEquals(oldCurriculum, pCurriculum);
        tearDown();
    }
    
    @Test
    public void testMinNameUpdate() throws Exception {
        System.out.println("update");
        PhdCurriculumManager instance = PhdCurriculumManager.getInstance();
        PhdCurriculum pCurriculum = new PhdCurriculum();
        String oldCurriculum = pCurriculum.getDescription();
        pCurriculum.setDescription("UpdateDescrizione");
        pCurriculum.setName("in");
        pCurriculum.setFK_Professor("CTLGMM91A71B519A");
        
        instance.update(oldCurriculum, pCurriculum);
        assertEquals(oldCurriculum, pCurriculum);
        tearDown();
    }
    
    @Test
    public void testMaxNameUpdate() throws Exception {
        System.out.println("update");
        PhdCurriculumManager instance = PhdCurriculumManager.getInstance();
        PhdCurriculum pCurriculum = new PhdCurriculum();
        String oldCurriculum = pCurriculum.getDescription();
        pCurriculum.setDescription("UpdateDescrizione");
        pCurriculum.setName("UpdateInfbkbdsjhfdsigfhsuishyfiusgfgdsjhfgjdshgfvjhcxbjhvfgdsjhfgcxjhgvfjhxcgjfhxgdsjhfgxcjhgfjhx<gcfhjxzgjhcgxhj<cg<xjhgdcjhz<gcjhxzgcjhgxjhvcgxjhgvcjhsdgjfhgsdjhgvcjhxgvjhcxgjhvgxcjhvgjhxgzvjhcxgzvjhgjxhfgjhdsgfjhgdsjhfgsjhdagfjhagjfsagfjhsaormatica");
        pCurriculum.setFK_Professor("CTLGMM91A71B519A");
        
        instance.update(oldCurriculum, pCurriculum);
        assertEquals(oldCurriculum, pCurriculum);
        tearDown();
    }
    
    @Test
    public void testFormatNameUpdate() throws Exception {
        System.out.println("update");
        PhdCurriculumManager instance = PhdCurriculumManager.getInstance();
        PhdCurriculum pCurriculum = new PhdCurriculum();
        String oldCurriculum = pCurriculum.getDescription();
        pCurriculum.setDescription("UpdateDescrizione");
        pCurriculum.setName("&&&&&");
        pCurriculum.setFK_Professor("CTLGMM91A71B519A");
        
        instance.update(oldCurriculum, pCurriculum);
        assertEquals(oldCurriculum, pCurriculum);
        tearDown();
    }
    

    /**
     * Test of delete method, of class PhdCycleManager.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        String idPhdCurriculumName = "Informatica";
        PhdCurriculumManager instance =  PhdCurriculumManager.getInstance().getInstance();
        instance.delete(idPhdCurriculumName);
        
        assertNull(instance);
        tearDown();
    }
//    
//
//    /**
//     * Test of getPhdCurriculumNameByCycle method, of class PhdCurriculumManager.
//     */
//    @Test
//    public void testGetPhdCurriculumNameByCycle() throws Exception {
//        System.out.println("getPhdCurriculumNameByCycle");
//        int idPhdCycle = 0;
//        PhdCurriculumManager instance = null;
//        ArrayList<String> expResult = null;
//        ArrayList<String> result = instance.getPhdCurriculumNameByCycle(idPhdCycle);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPhdCurriculumNames method, of class PhdCurriculumManager.
//     */
//    @Test
//    public void testGetPhdCurriculumNames() throws Exception {
//        System.out.println("getPhdCurriculumNames");
//        PhdCurriculumManager instance = null;
//        ArrayList<String> expResult = null;
//        ArrayList<String> result = instance.getPhdCurriculumNames();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPhdCurriculumById method, of class PhdCurriculumManager.
//     */
//    @Test
//    public void testGetPhdCurriculumById() throws Exception {
//        System.out.println("getPhdCurriculumById");
//        String phdCurriculumName = "";
//        PhdCurriculumManager instance = null;
//        PhdCurriculum expResult = null;
//        PhdCurriculum result = instance.getPhdCurriculumById(phdCurriculumName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
