/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proglangjava;

import java.util.Scanner;
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
        System.out.println("main");
        String[] args = null;
        App.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class App.
     */
    @Test
    public void testRun() throws Exception {
        System.out.println("run");
        App instance = new App();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readInput method, of class App.
     */
    @Test
    public void testReadInput_Scanner() {
        System.out.println("readInput");
        Scanner in = new Scanner("2 10 7\n" +
                                 "5 5 5 5 5 5 5");
        App app = new App();
       app.readInput(in);
       assertEquals(2, app.h);
       assertEquals(10,app.w);
       assertEquals(7,app.n);
       assertArrayEquals(new int[] {5,5,5,5,5,5,5},app.x);
    }

    /**
     * Test of solveProblem method, of class App.
     */
    @Test
    public void testSolveProblem() {
        System.out.println("solveProblem");
        App instance = new App();
        instance.solveProblem();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeOutput method, of class App.
     */
    @Test
    public void testWriteOutput() {
        System.out.println("writeOutput");
        App instance = new App();
        instance.writeOutput();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readInput method, of class App.
     */
    @Test
    public void testReadInput_0args() {
        System.out.println("readInput");
        App instance = new App();
        instance.readInput();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
