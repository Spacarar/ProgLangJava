/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proglangjava;

/**
 *
 * @author Wolfwood
 */
public interface Student extends Comparable<Student> {
    public double average();
    public char letterGrade();
}
