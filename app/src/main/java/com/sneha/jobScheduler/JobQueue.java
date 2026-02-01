package com.sneha.jobScheduler;

import java.util.List;

public class JobQueue {

    private List<Job> jobsQueue;

    JobQueue(List<Job> jobsQueue) {
        this.jobsQueue = jobsQueue;
    }

    void add(Job job) {
        jobsQueue.add(job);
    }


    Job fetch() {
        //gives back  job that needs to be processed
        return jobsQueue.get(0);
    }

    void remove(Job job) {
        jobsQueue.remove(job);
    }
}
