package com.sneha.jobScheduler;

import com.google.gson.Gson;
import com.sneha.jobScheduler.machine.MachineJobAcknowledgementResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JobProcessor {
    MachineService machineService;
    JobQueue jobQueue;
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    JobProcessor(MachineService machineService, JobQueue jobQueue) {
        this.jobQueue = jobQueue;
        this.machineService = machineService;
    }


    void process() throws Exception {
        // fetch job from queue
        Job job = jobQueue.fetch();

        //get the machine where job needs to be processed
        MachineRegistry machine = machineService.compute(job.getMemoryNeeded());

//        //use http 200 status code and update status of machine
        String response = assingJobToMachine(job);
        if (response == null) {
            throw new Exception("Response is null");
        }
        if (response.equals("Received")) {
            System.out.println("Job status updated");

            jobQueue.remove(job);
            machineService.updateMachineAvailability(machine.getId(), "Booked");

        } else {
            //MR. NIKHIL SONI COMMENTS: WE ARE ADDING HERE WITHOUTH REMOVING
            jobQueue.add(job);
        }


    }

    private String assingJobToMachine(Job job) throws Exception {
        String url = String.format("http://localhost:8080/machineOne/job");

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            MachineJobAcknowledgementResponse result = gson.fromJson(response.body().string(), MachineJobAcknowledgementResponse.class);
            return result.getAcknowledgement();
        } catch (Exception e) {
            throw new Exception("There was issue while calling Machine Service");
        }
    }
}
