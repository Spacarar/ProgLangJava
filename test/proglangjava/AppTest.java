/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proglangjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
 * @author Wolfwood
 */
public class AppTest {

    App instance = new App();

    public AppTest() {
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
     * Test of main method, of class App.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main skipped");
    }

    /**
     * Test of insertPerson method, of class App.
     */
    @Test
    public void testInsertPerson() {
        System.out.println("insertPerson");
        instance.reset();
        String name = "Greg";
        long expResult = 1;
        long result = 0;
        try {
            result = instance.insertPerson(name);
        } catch (Exception e) {
            System.out.println("error inserting person!");
        }
        assertEquals(expResult, result);

    }

    /**
     * Test of getPreparedStatement method, of class App.
     */
    @Test
    public void testGetPreparedStatement() {
        System.out.println("getPreparedStatement skipped");

    }

    /**
     * Test of sql method, of class App.
     */
    @Test
    public void testSql_String_ObjectArr() {
        System.out.println("sql skipped");
    }

    /**
     * Test of getPerson method, of class App.
     */
    @Test
    public void testGetPerson() {
        System.out.println("getPerson");
        long id;
        instance.reset();
        id = instance.insertPerson("Bob");
        String expResult = "Bob";
        String result = instance.getPerson(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of run method, of class App.
     */
    @Test
    public void testRun() {
        System.out.println("run skipped");
    }

}
