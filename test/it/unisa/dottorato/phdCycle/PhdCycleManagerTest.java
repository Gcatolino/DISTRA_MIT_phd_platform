package it.unisa.dottorato.phdCycle;

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
public class PhdCycleManagerTest {
    
    public PhdCycleManagerTest() {
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
        PhdCycleManager result = PhdCycleManager.getInstance();
        assertNotNull(result);
    }

    /**
     * Test of insert method, of class PhdCycleManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testInsert() throws Exception {
        System.out.println("insert");
        PhdCycle pCycle = new PhdCycle();
        PhdCycleManager instance = PhdCycleManager.getInstance();
        pCycle.setDescription("descrizione");
        pCycle.setIdPhdCycle(11);
        pCycle.setYear(2014);
        pCycle.setFK_Professor("ertghyuijhtredfg");
        instance.insert(pCycle);
        
        PhdCycle result = instance.getPhdCycleById(11);
        assertNotNull(result);
        
        tearDown();
    }
    
    
    @Test
    public void testInsertEmptyIdPhdCycle() throws Exception {
        System.out.println("insert");
        PhdCycle pCycle = new PhdCycle();
        PhdCycleManager instance = PhdCycleManager.getInstance();
        pCycle.setDescription("descrizione");
        pCycle.setIdPhdCycle(0);
        pCycle.setYear(2014);
        pCycle.setFK_Professor("ertghyuijhtredfg");
        instance.insert(pCycle);
        
        PhdCycle result = instance.getPhdCycleById(11);
        assertNull(result);
        
        tearDown();
    }
    
    
    @Test
    public void testInsertMaxValueIdPhdCycle() throws Exception {
        System.out.println("insert");
        PhdCycle pCycle = new PhdCycle();
        PhdCycleManager instance = PhdCycleManager.getInstance();
        pCycle.setDescription("descrizione");
        pCycle.setIdPhdCycle(111);
        pCycle.setYear(2014);
        pCycle.setFK_Professor("CTLGMM91A71B519A");
        instance.insert(pCycle);
        
        PhdCycle result = instance.getPhdCycleById(11);
        assertNull(result);
        
        tearDown();
    }
    
     @Test
    public void testInsertStringIdPhdCycle() throws Exception {
        System.out.println("insert");
        PhdCycle pCycle = new PhdCycle();
        PhdCycleManager instance = PhdCycleManager.getInstance();
        pCycle.setDescription("descrizione");
        pCycle.setIdPhdCycle(14);
        pCycle.setYear(2014);
        pCycle.setFK_Professor("CTLGMM91A71B519A");
        instance.insert(pCycle);
        
        PhdCycle result = instance.getPhdCycleById(11);
        assertNull(result);
        
        tearDown();
    }
    
     @Test
    public void testInsertAlreadyExistIdPhdCycle() throws Exception {
        System.out.println("insert");
        PhdCycle pCycle = new PhdCycle();
        PhdCycleManager instance = PhdCycleManager.getInstance();
        pCycle.setDescription("descrizione");
        pCycle.setIdPhdCycle(11);
        pCycle.setYear(2014);
        pCycle.setFK_Professor("CTLGMM91A71B519A");
        instance.insert(pCycle);
        instance.insert(pCycle);
        
        PhdCycle result = instance.getPhdCycleById(11);
        assertNull(result);
        
        tearDown();
    }
    
    @Test
    public void testInsertMinimunYear() throws Exception {
        System.out.println("insert");
        PhdCycle pCycle = new PhdCycle();
        PhdCycleManager instance = PhdCycleManager.getInstance();
        pCycle.setDescription("descrizione");
        pCycle.setIdPhdCycle(11);
        pCycle.setYear(201);
        pCycle.setFK_Professor("CTLGMM91A71B519A");
        instance.insert(pCycle);
        
        PhdCycle result = instance.getPhdCycleById(11);
        assertNull(result);
        
        tearDown();
    }
    
    
    @Test
    public void testInsertMaxYear() throws Exception {
        System.out.println("insert");
        PhdCycle pCycle = new PhdCycle();
        PhdCycleManager instance = PhdCycleManager.getInstance();
        pCycle.setDescription("descrizione");
        pCycle.setIdPhdCycle(11);
        pCycle.setYear(20141);
        pCycle.setFK_Professor("CTLGMM91A71B519A");
        instance.insert(pCycle);
        PhdCycle result = instance.getPhdCycleById(11);
        assertNull(result);
        
        tearDown();
    }
    
       
    @Test
    public void testInsertNullFK_Professor() throws Exception {
        System.out.println("insert");
        PhdCycle pCycle = new PhdCycle();
        PhdCycleManager instance = PhdCycleManager.getInstance();
        pCycle.setDescription("descrizione");
        pCycle.setIdPhdCycle(11);
        pCycle.setYear(2014);
        pCycle.setFK_Professor(null);
        instance.insert(pCycle);
        
        PhdCycle result = instance.getPhdCycleById(11);
        assertNull(result);
        tearDown();
    }

    /**
     * Test of update method, of class PhdCycleManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        PhdCycleManager instance = PhdCycleManager.getInstance();
        PhdCycle pCycle = new PhdCycle();
        String oldIdPhdCycle = pCycle.getDescription();
        pCycle.setDescription("UpdateDescrizione");
        pCycle.setYear(2016);
        pCycle.setIdPhdCycle(18);
        pCycle.setFK_Professor("CTLGMM91A71B519A");
        
        instance.update(oldIdPhdCycle, pCycle);
        assertEquals(oldIdPhdCycle, pCycle);
        tearDown();
    }
    
    @Test
    public void testEmptyIDUpdate() throws Exception {
        System.out.println("update");
        PhdCycleManager instance = PhdCycleManager.getInstance();
        PhdCycle pCycle = new PhdCycle();
        String oldIdPhdCycle = pCycle.getDescription();
        pCycle.setDescription("UpdateDescrizione");
        pCycle.setYear(2016);
        pCycle.setIdPhdCycle(0);
        pCycle.setFK_Professor("CTLGMM91A71B519A");
        
        instance.update(oldIdPhdCycle, pCycle);
        assertEquals(oldIdPhdCycle, pCycle);
        tearDown();
    }
    @Test
    public void testMaxIDUpdate() throws Exception {
        System.out.println("update");
        PhdCycleManager instance = PhdCycleManager.getInstance();
        PhdCycle pCycle = new PhdCycle();
        String oldIdPhdCycle = pCycle.getDescription();
        pCycle.setDescription("UpdateDescrizione");
        pCycle.setYear(2016);
        pCycle.setIdPhdCycle(188);
        pCycle.setFK_Professor("CTLGMM91A71B519A");
        
        instance.update(oldIdPhdCycle, pCycle);
        assertEquals(oldIdPhdCycle, pCycle);
        tearDown();
    }
    
    @Test
    public void testFormatIDUpdate() throws Exception {
        System.out.println("update");
        PhdCycleManager instance = PhdCycleManager.getInstance();
        PhdCycle pCycle = new PhdCycle();
        String oldIdPhdCycle = pCycle.getDescription();
        pCycle.setDescription("UpdateDescrizione");
        pCycle.setYear(2016);
        pCycle.setIdPhdCycle(14);
        pCycle.setFK_Professor("CTLGMM91A71B519A");
        
        instance.update(oldIdPhdCycle, pCycle);
        assertEquals(oldIdPhdCycle, pCycle);
        tearDown();
    }
    
    @Test
    public void testExistUpdate() throws Exception {
        System.out.println("update");
        PhdCycleManager instance = PhdCycleManager.getInstance();
        PhdCycle pCycle = new PhdCycle();
        String oldIdPhdCycle = pCycle.getDescription();
        pCycle.setDescription("UpdateDescrizione");
        pCycle.setYear(2016);
        pCycle.setIdPhdCycle(18);
        pCycle.setFK_Professor("CTLGMM91A71B519A");
        
        instance.update(oldIdPhdCycle, pCycle);
        instance.update(oldIdPhdCycle, pCycle);
        assertEquals(oldIdPhdCycle, pCycle);
        tearDown();
    }
    
    @Test
    public void testMinYearUpdate() throws Exception {
        System.out.println("update");
        PhdCycleManager instance = PhdCycleManager.getInstance();
        PhdCycle pCycle = new PhdCycle();
        String oldIdPhdCycle = pCycle.getDescription();
        pCycle.setDescription("UpdateDescrizione");
        pCycle.setYear(201);
        pCycle.setIdPhdCycle(18);
        pCycle.setFK_Professor("CTLGMM91A71B519A");
        
        instance.update(oldIdPhdCycle, pCycle);
        assertEquals(oldIdPhdCycle, pCycle);
        tearDown();
    }
    
    @Test
    public void testMaxYearUpdate() throws Exception {
        System.out.println("update");
        PhdCycleManager instance = PhdCycleManager.getInstance();
        PhdCycle pCycle = new PhdCycle();
        String oldIdPhdCycle = pCycle.getDescription();
        pCycle.setDescription("UpdateDescrizione");
        pCycle.setYear(201111);
        pCycle.setIdPhdCycle(18);
        pCycle.setFK_Professor("CTLGMM91A71B519A");
        
        instance.update(oldIdPhdCycle, pCycle);
        assertEquals(oldIdPhdCycle, pCycle);
        tearDown();
    }
    
    
    @Test
    public void testFormatYearUpdate() throws Exception {
        System.out.println("update");
        PhdCycleManager instance = PhdCycleManager.getInstance();
        PhdCycle pCycle = new PhdCycle();
        String oldIdPhdCycle = pCycle.getDescription();
        pCycle.setDescription("UpdateDescrizione");
        pCycle.setYear(2015);
        pCycle.setIdPhdCycle(18);
        pCycle.setFK_Professor("CTLGMM91A71B519A");
        
        instance.update(oldIdPhdCycle, pCycle);
        assertEquals(oldIdPhdCycle, pCycle);
        tearDown();
    }
    

    /**
     * Test of delete method, of class PhdCycleManager.
     * @throws java.lang.Exception
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        String idPhdCycle = "15";
        PhdCycleManager instance =  PhdCycleManager.getInstance();
        instance.delete(idPhdCycle);
        
        assertNull(instance);
        tearDown();
    }
    
    
    
//
//    /**
//     * Test of getPhdCycleById method, of class PhdCycleManager.
//     */
//    @Test
//    public void testGetPhdCycleById() throws Exception {
//        System.out.println("getPhdCycleById");
//        int idPhdCycle = 0;
//        PhdCycleManager instance = null;
//        PhdCycle expResult = null;
//        PhdCycle result = instance.getPhdCycleById(idPhdCycle);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPhdCyclesIds method, of class PhdCycleManager.
//     */
//    @Test
//    public void testGetPhdCyclesIds() throws Exception {
//        System.out.println("getPhdCyclesIds");
//        PhdCycleManager instance = null;
//        ArrayList<String> expResult = null;
//        ArrayList<String> result = instance.getPhdCyclesIds();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
