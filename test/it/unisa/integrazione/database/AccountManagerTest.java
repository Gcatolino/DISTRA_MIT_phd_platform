/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.integrazione.database;

import it.unisa.integrazione.model.Person;
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
public class AccountManagerTest {

    public AccountManagerTest() {
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
    }

    /**
     * Test of getInstance method, of class AccountManager.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        AccountManager result = AccountManager.getInstance();
        assertNotNull(result);
    }

    /**
     * Test of login method, of class AccountManager.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testLogin() throws Exception {
        System.out.println("login");
        String pUsername = "gemma.catolino";
        String pPassword = "gemma";

        AccountManager instance = AccountManager.getInstance();
        String expResultName = "Gemma";
        Person result = instance.login(pUsername, pPassword);

        assertEquals(expResultName, result.getName());

    }

}
