package com.sneha.buyingPower.loan;

import java.util.List;

public class LoanResponse {
    private List<LoanEntry> loanEntryList;
    LoanResponse(List<LoanEntry> loanEntryList){
        this.loanEntryList = loanEntryList;
    }

    public List<LoanEntry> getLoanEntryList() {
        return loanEntryList;
    }
}
