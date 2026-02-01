package com.sneha.buyingPower.loan;


import java.util.List;

public class LoanService {
    private final LoanDatabase loanDatabase;

    LoanService(LoanDatabase loanDatabase) {
        this.loanDatabase = loanDatabase;
    }

    public List<LoanEntry> getEntries(String userId) {
        return loanDatabase.getEntries(userId);
    }
}
