package com.sneha.jobScheduler;

import java.util.List;

//MR. NIKHIL SONI COMMENT: RENAME
public class MachineDataComputationService {


    MachineRegistry findAvailableMachine(List<MachineRegistry> machineList, int memory) throws Exception {
        //runs logic to compute the machine where job will run out of all working machines
        if (machineList == null) {
            throw new Exception("No machine found");
        }

        for (MachineRegistry m : machineList) {
            if (m.getMemorySupported() == memory) {
                return m;
            }
        }

        return null;
    }
}
