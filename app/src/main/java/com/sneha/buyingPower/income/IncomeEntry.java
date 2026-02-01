package com.sneha.buyingPower.income;

import com.sneha.buyingPower.IdGenerator;

public class IncomeEntry {
    private final String userId;
    private final String id;
    private final int amount;

    IncomeEntry(String userId, IdGenerator idGenerator, int amount) {
        this.amount = amount;
        this.userId = userId;
        this.id = idGenerator.generate();
    }
    public   IncomeEntry(String id, String userId, int amount){
        this.amount = amount;
        this.id = id;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }
}
