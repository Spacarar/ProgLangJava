/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proglangjava;

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
public class JavaStudentTest {
    
    public JavaStudentTest() {
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
     * Test of average method, of class JavaStudent.
     */
    @Test
    public void testAverage() {
        System.out.println("average");
        JavaStudent instance = new JavaStudent("Bob",100,100,100);
        double expResult = 100.0;
        double result = instance.average();
        assertEquals(expResult, result, 0.0);
        expResult = 60.0;
        instance = new JavaStudent("tina",80,80,20);
        result=instance.average();
        assertEquals(expResult,result,0.0);

    }

    /**
     * Test of letterGrade method, of class JavaStudent.
     */
    @Test
    public void testLetterGrade() {
        System.out.println("letterGrade");
        JavaStudent instance = new JavaStudent("Bob",100,90,95);
        char expResult = 'A';
        char result = instance.letterGrade();
        assertEquals(expResult, result);
        instance=new JavaStudent("Tina",80,80,54);
        expResult='C';
        result = instance.letterGrade();
        assertEquals(expResult,result);

    }

    /**
     * Test of compareTo method, of class JavaStudent.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        JavaStudent bob = new JavaStudent("Bob",100,90,95);
        JavaStudent tina = new JavaStudent("Tina",80,60,45);
        assertEquals(bob.compareTo(tina),1);
        assertEquals(bob.compareTo(bob),0);
        assertEquals(tina.compareTo(bob),-1);
    }

    /**
     * Test of equals method, of class JavaStudent.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        JavaStudent bob = new JavaStudent("Bob",100,100,100);
        JavaStudent tina = new JavaStudent("Tina",100,100,100);
        assertEquals(bob,tina);
    }
    
}
