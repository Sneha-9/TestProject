package com.sneha.jobScheduler;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {
    // private Job job = new Job("2",2);
    private List<Job> jobQueueList = new ArrayList<>();
    private JobQueue jobQueue = new JobQueue(jobQueueList);
    private MachineDatabase machineDatabase = new MachineDatabase();
    private MachineHealthCheck machineHealthCheck = new MachineHealthCheck();
    private MachineDataComputationService machineDataComputationService = new MachineDataComputationService();
    private MachineService machineService = new MachineService(machineDatabase, machineHealthCheck, machineDataComputationService);
    private JobProcessor jobProcessor = new JobProcessor(machineService, jobQueue);
    private JobScheduler jobScheduler = new JobScheduler(jobProcessor, jobQueue, machineDatabase);

//    public JobController(JobQueue jobQueue) {
//        this.jobQueue = jobQueue;
//    }

    @PostMapping(value = "/jobScheduler/job", produces = "application/json")
    JobSchedulerResponse scheduleJob(@RequestBody JobSchedulerRequest jobSchedulerRequest) throws Exception {
        String response = jobScheduler.pushJobToQueue(jobSchedulerRequest.getId(), jobSchedulerRequest.getMemoryNeeded());
        return new JobSchedulerResponse(response);
    }

    @GetMapping(value = "/jobScheduler/trigger", produces = "application/json")
    void startJobProcessor() throws Exception {
        jobScheduler.startJobProcessor();
    }

    @PatchMapping(value = "/jobScheduler/job/{id}")
    void updateStatus(@PathVariable("id") String id) throws Exception {
        jobScheduler.updateMachineStatus(id);
    }

}
