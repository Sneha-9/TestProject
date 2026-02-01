package com.sneha.buyingPower.collateral;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CollateralController {
    private CollateralDatabase collateralDatabase = new CollateralDatabase();
    private CollateralService collateralService = new CollateralService(collateralDatabase);

    @GetMapping(value = "/collateralService/userdata/{userId}", produces = "application/json")
    CollateralResponse getLoanData(@PathVariable("userId") String userId){
        List<CollateralEntry> result = collateralService.getEnteries(userId);
        return new CollateralResponse(result);

    }
}
