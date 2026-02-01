package com.sneha.buyingPower.buyingPower;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyingPowerController {
    ComputationService computationService = new ComputationService();
    ComputationDataService computationDataService = new ComputationDataService();
    BuyingPowerService buyingPowerService = new BuyingPowerService(computationService,computationDataService);


    @GetMapping(value = "buyingPower/user/{userId}", produces = "application/json")
    BuyingPowerResponse getBuyingPower(@PathVariable("userId") String userId) throws Exception {
       int value =  buyingPowerService.getBuyingPower(userId);
       System.out.println("Controller " + value);
       return new BuyingPowerResponse(value);
    }
}
