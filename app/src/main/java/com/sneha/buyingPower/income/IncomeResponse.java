package com.sneha.buyingPower.income;

import java.util.List;

public class IncomeResponse {
    private List<IncomeEntry> incomeEntries;
    IncomeResponse(List<IncomeEntry> incomeEntries){
        this.incomeEntries = incomeEntries;
    }

    public List<IncomeEntry> getIncomeEntries() {
        return incomeEntries;
    }
}
