package com.sneha.atmMachine;

public class Card{
    public String id;
    private String accountId;
    public Card(IdGenerator id, String accountId) {
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("Account Id cannot be empty");
        }
        this.id = id.generateId();
        this.accountId = accountId;
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }
}
