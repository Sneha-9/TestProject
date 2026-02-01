package com.sneha.jobScheduler.machine;


public class MachineHealthResponse {
    private boolean response;
    MachineHealthResponse(boolean response){
        this.response = response;
    }

    public boolean isResponse() {
        return response;
    }
}
