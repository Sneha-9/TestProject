package com.sneha.jobScheduler;

public class JobSchedulerRequest {
  private String id;
  private int memoryNeeded;

    JobSchedulerRequest(String id, int memoryNeeded){
      this.id = id;
      this.memoryNeeded = memoryNeeded;
    }

    public String getId() {
        return id;
    }

    public int getMemoryNeeded() {
        return memoryNeeded;
    }
}
