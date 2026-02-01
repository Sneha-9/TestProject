package com.sneha.buyingPower.collateral;

import com.sneha.buyingPower.IdGenerator;

public class CollateralEntry {
    private final String userId;
    private final String id;
    private final int amount;
    private final String type;

    CollateralEntry(String type, String userId, IdGenerator idGenerator, int amount) {
        this.amount = amount;
        this.userId = userId;
        this.id = idGenerator.generate();
        this.type = type;
    }

    public   CollateralEntry(String id, String userId,String type, int amount){
        this.amount = amount;
        this.id = id;
        this.userId = userId;
        this.type = type;
    }


    public String getType() {
        return type;
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
