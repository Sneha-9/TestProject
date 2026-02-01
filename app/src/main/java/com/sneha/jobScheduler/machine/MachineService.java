package com.sneha.jobScheduler.machine;

public class MachineService {

    private Machine machine;

    MachineService(Machine machine){

        this.machine = machine;
    }

    boolean machineOneHealth(){

        return machine.isServiceable();
    }

}
