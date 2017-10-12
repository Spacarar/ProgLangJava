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
public class JavaStudent implements Student {
    public double test1,test2,test3;
    public String name;
    
    JavaStudent(String nam, double t1, double t2, double t3){
        name=name;
        test1=t1;
        test2=t2;
        test3=t3;
    }
    @Override
    public double average(){
        return (test1+test2+test3)/3;
    }
    @Override
    public char letterGrade(){
        double g=average();
        if(g>=90.0)return 'A';
        else if(g>=80)return 'B';
        else if(g>=70)return 'C';
        else if(g>=60)return 'D';
        else return 'F';
    }
    @Override
    public int compareTo(Student to){
        if(to instanceof JavaStudent){
            JavaStudent jstudent =(JavaStudent)to;
            if(average()<jstudent.average())return -1;
            if(average()>jstudent.average())return 1;
            return 0;
        }
        else return this.getClass().getName().compareTo(to.getClass().getName());
    }
    
        @Override 
        public boolean equals(Object o) {
            return compareTo((Student) o) == 0;
        }
}

