package com.sneha.jobScheduler;

public class JobScheduler {
    private MachineDatabase machineDatabase;
    private JobProcessor jobProcessor;
    private JobQueue jobQueue;

    JobScheduler(JobProcessor jobProcessor, JobQueue jobQueue, MachineDatabase machineDatabase) {
        this.jobQueue = jobQueue;
        this.jobProcessor = jobProcessor;
        this.machineDatabase = machineDatabase;
    }

    String pushJobToQueue(String id, int memoryNeeded) throws Exception {
        //  add job to queue
        Job job = new Job(id, memoryNeeded);
        jobQueue.add(job);
        startJobProcessor();

        //MR. NIKHIL SONI COMMENT: DO NOT RETURN STRING
        return "Job received and is in the queue to process";
    }

    void startJobProcessor() throws Exception {
        //start job processor
        jobProcessor.process();
    }

    void updateMachineStatus(String id) throws Exception {
        // update status of machine when job is complete

        machineDatabase.updateStatus(id, "Available");
        startJobProcessor();

    }
}
