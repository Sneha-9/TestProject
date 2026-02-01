package com.sneha.jobScheduler.machine;

public class MachineJobAcknowledgementResponse {
    private String acknowledgement;

    MachineJobAcknowledgementResponse(String acknowledgement){
        this.acknowledgement = acknowledgement;
    }

    public String getAcknowledgement() {
        return acknowledgement;
    }
}
