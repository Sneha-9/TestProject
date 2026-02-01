package com.sneha.jobScheduler;

public class Job {
    private  String id;
    private  int memoryNeeded;

    Job(String id, int memoryNeeded) {
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
