package com.sneha.jobScheduler.machine;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MachineController {

    Machine machine = new Machine();
    MachineService machineService = new MachineService(machine) ;
//    MachineOneController(MachineOneService machineOneService){
//
//    }

    @GetMapping(value = "/machineOne/health-check", produces = "application/json")
    MachineHealthResponse getMachineOneHealth(){
        return new MachineHealthResponse(machineService.machineOneHealth());
    }

    @GetMapping(value = "/machineOne/job", produces = "application/json")
    MachineJobAcknowledgementResponse jobProcessor(){
       return new MachineJobAcknowledgementResponse("Received");
    }

}
