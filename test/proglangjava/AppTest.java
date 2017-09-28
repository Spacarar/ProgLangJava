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
        System.out.println("main test skipped");
    }

    /**
     * Test of run method, of class App.
     */
    @Test
    public void testRun() throws Exception {
        System.out.println("run test skipped");

    }
    
    /**
     * Test of readInput method, of class App.
     */
    @Test
    public void testReadInput_Scanner() {
        System.out.println("readInput");
        Scanner in = new Scanner("3\n"
                + "ASDFGHJKL\n"
                + "CDOOOOOO\n"
                + "OCDOCDOCD\n");
        App instance = new App();
        instance.readInput(in);
        //the last string in the list should be current attack when this is finished
        assertEquals("OCDOCDOCD",instance.currentAttack);
    }

    /**
     * Test of checkAttack method, of class App.
     */
    @Test
    public void testCheckAttack() {
        System.out.println("checkAttack");
        String s = "CODCOD";
        App instance = new App();
        System.out.println("pre: "+s+" count: "+instance.count);
        instance.checkAttack(s);
        assertEquals(1,instance.count);//the first string should pass
        System.out.println(s+" count: "+instance.count);
        s="OCDCDOCD";
        System.out.println("pre: "+s+" count: "+instance.count);
        instance.checkAttack(s);
        System.out.println(s+" count: "+instance.count);
        assertEquals(1,instance.count);//the second string should fail
    }

    /**
     * Test of printOutput method, of class App.
     */
    @Test
    public void testPrintOutput() {
        System.out.println("printOutput skipped");
    }
    
}
