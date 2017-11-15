/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proglangjava;

import java.util.Random;

/**
 *
 * @author Wolfwood
 */
public class App {

    public static void main(String[] args) throws Exception{
        App app = new App();
        app.run();
    }
   Job[] createJobList(){
       int numJobs = 10;
        String[] actions ={"Sweeping","Mopping","Doing the dishes","Taking the trash out","Cleaning the windows","Organizing the boxes","taking a break"};
        Random r= new Random();
        Job[] joblist=new Job[numJobs];
        for(int i=0;i<numJobs;i++){
           joblist[i]=new Job(actions[r.nextInt(7)],r.nextInt(1500));
        }
        return joblist;
   }
    void run() throws Exception{
        Job[] joblist= createJobList();
        Thread bob = new Thread(new Worker("Bob",joblist));
        joblist=createJobList();
        Thread tina = new Thread(new Worker("Tina",joblist));
        bob.start();
        tina.start();
    }
    
}
