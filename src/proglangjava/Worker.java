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
public class Worker implements Runnable {

    String name;
    Job job;
    Job[] joblist;
    int jobCount;

    public void giveJob(Job _job) {
        job = _job;
    }

    void getNextJob() {
        if (jobCount < joblist.length-1) {
            jobCount++;
        }
        //System.out.println(name + " is getting next job");
        giveJob(joblist[jobCount]);
    }

    Worker(String _name, Job[] _joblist) {
        name = _name;
        joblist = _joblist;
        job = joblist[0];
        jobCount = 0;

    }

    @Override
    public void run() {
        while (jobCount < joblist.length-1) {
            System.out.println(name + " is " + job.action);
            try {
                Thread.sleep(job.duration);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            getNextJob();
        }
    }

}
