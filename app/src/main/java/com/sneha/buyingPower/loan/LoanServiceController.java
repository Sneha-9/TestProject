package com.sneha.buyingPower.loan;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanServiceController {
    private LoanDatabase loanDatabase = new LoanDatabase();
    private  LoanService loanService = new LoanService(loanDatabase);

    @GetMapping(value = "/loanService/userdata/{userId}", produces = "application/json")
    LoanResponse getLoanData(@PathVariable("userId") String userId){
        List<LoanEntry> result = loanService.getEntries(userId);
        return new LoanResponse(result);

    }
}
