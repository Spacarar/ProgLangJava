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
    public int h,w,n;
    int[] x;
    
    class Lars{
        boolean annoyed = false;
        int nextBrickHeight = 0;
        int nextBrickOffset=0;
        int nextBrickIndex=0;
        
        void work(){
            if(annoyed)return;
            if(nextBrickIndex>=n){
                annoyed=true;
                return;
            }
            if(x[nextBrickIndex]+nextBrickOffset>w){
                annoyed=true;
                return;
            }
            nextBrickOffset=x[nextBrickIndex]+nextBrickOffset;
            nextBrickIndex=nextBrickIndex+1;
            if(nextBrickOffset==w){
                nextBrickOffset=0;
                nextBrickHeight=nextBrickHeight+1;
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        App app = new App();
        app.run();
    }
    
    void run() throws Exception{
        readInput();
        solveProblem();
        writeOutput();
    }
    void readInput(Scanner in){
        h=in.nextInt();
        w=in.nextInt();
        n=in.nextInt();
        
        if(h<1||h>100){
            throw new IllegalStateException("Invalid value of h: " +h);
        }
        if(w<1||w>100){
            throw new IllegalStateException("Invalid value of w: " +w);
        }
        if(n<1||n>10_000){
            throw new IllegalStateException("Invalid value of h: " +n);
        }
        x = new int[n];
        for(int i=0;i<n;i++){
            x[i]=in.nextInt();
            if(x[i]<1||x[i]>10){
                throw new IllegalStateException("Invalid value of x: " +x[i]);
            }
        }
    }
    
    void solveProblem(){
        
    }
    
    void writeOutput(){
        
    }
    
    void readInput(){
        Scanner inp = new Scanner(System.in);
        readInput(inp);
    }
    
}
