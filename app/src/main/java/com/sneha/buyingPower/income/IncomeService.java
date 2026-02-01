package com.sneha.buyingPower.income;


import java.util.List;

public class IncomeService {

    private final IncomeDatabase incomeDatabase;

    IncomeService(IncomeDatabase incomeDatabase) {
        this.incomeDatabase = incomeDatabase;
    }

    public List<IncomeEntry> getEnteries(String userId) {
        return incomeDatabase.getEnteries(userId);
    }
}
