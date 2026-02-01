package com.sneha.buyingPower.loan;

import com.sneha.buyingPower.IdGenerator;

public class LoanEntry {
    private final String userId;
    private final String id;
    private final int amount;

    LoanEntry(String userId, IdGenerator idGenerator, int amount) {
        this.amount = amount;
        this.userId = userId;
        this.id = idGenerator.generate();
    }

  public   LoanEntry(String id, String userId, int amount){
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
