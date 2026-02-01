package com.sneha.buyingPower.cibilScore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CibilController {
    private CibilScoreDatabase cibilScoreDatabase = new CibilScoreDatabase();
    private CibilScoreService cibilScoreService = new CibilScoreService(cibilScoreDatabase);

    @GetMapping(value = "/cibilScoreService/userdata/{userId}", produces = "application/json")
    CibilScoreResponse getLoanData(@PathVariable("userId") String userId){
      int result = cibilScoreService.getEnteries(userId);
        return new CibilScoreResponse(result);

    }
}
