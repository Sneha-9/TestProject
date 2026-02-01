package com.sneha.jobScheduler;

import java.util.List;

public class MachineService {

    MachineDatabase machineDatabase;
    MachineHealthCheck machineHealthCheck;
    MachineDataComputationService machineDataComputationService;

    MachineService(MachineDatabase machineDatabase, MachineHealthCheck machineHealthCheck, MachineDataComputationService machineDataComputationService){
        this.machineDatabase = machineDatabase;
        this.machineHealthCheck = machineHealthCheck;
        this.machineDataComputationService = machineDataComputationService;
    }

    MachineRegistry compute(int memory) throws Exception {

        //queries list of machines
        List<MachineRegistry> availableMachines = machineDatabase.getData(memory);

        // gets 2 sets of list - working and nonworking
        MachineHealth machineHealth = machineHealthCheck.getData(availableMachines);

        //finds the one machine where job will be processed
        MachineRegistry machine = machineDataComputationService.findAvailableMachine(machineHealth.getServiceable(), memory);

        if(machine  == null){
            //queue the job
            throw new Exception("no machine found to run the job");
        }

        //updates status of non working machines
        if(machineHealth.getUnserviceable() != null){
            for(MachineRegistry m : machineHealth.getUnserviceable()){
                updateMachineAvailability(m.getId(), m.getStatus());
            }
        }
       // update staus of working
//        if(machineHealth.getServiceable() != null){
//            for(MachineRegistry m : machineHealth.getServiceable()){
//                updateMachineAvailability(m.getId(), m.getStatus());
//            }
//        }


        return machine;
    }

    public void updateMachineAvailability(String id, String status) {

            machineDatabase.updateStatus(id, status);

    }
}
