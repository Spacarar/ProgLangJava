/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proglangjava;

import java.util.Scanner;

/**
 *
 * @author Wolfwood
 */
public class App {
    public int count =0;
    public int numAttacks=0;
    public String currentAttack="";
    
    public static void main(String[] args) throws Exception{
        App app = new App();
        app.run();
    }
    
    void run() throws Exception{
        readInput();
        printOutput();
    }
    void readInput(){
        Scanner inp = new Scanner(System.in);
        readInput(inp);
    }
    void readInput(Scanner in){
        numAttacks=in.nextInt();
        //this line is added to stop it from reading the extra character
        in.nextLine();
        for(int i=0;i<numAttacks;i++){
            currentAttack=in.nextLine();
            checkAttack(currentAttack);
        }
    }
    void checkAttack(String s){
       // System.out.println(s);
        //System.out.println("contains CD?: "+ s.contains("CD"));
        if(s.contains("CD")==false &&s!="") count+=1;
    }
    void printOutput(){
        System.out.println(count);
    }
    
}
