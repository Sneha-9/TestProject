package com.sneha.buyingPower.income;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IncomeController {

        private IncomeDatabase incomeDatabase = new IncomeDatabase();
        private IncomeService incomeService = new IncomeService(incomeDatabase);

        @GetMapping(value = "/incomeService/userdata/{userId}", produces = "application/json")
        IncomeResponse getLoanData(@PathVariable("userId") String userId){
            List<IncomeEntry> result = incomeService.getEnteries(userId);
            return new IncomeResponse(result);

        }
    }

