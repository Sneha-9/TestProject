package com.sneha.bankService;

import com.sneha.atmMachine.IdGenerator;

public class BankAccount {
    private final String accountId;
    private final String governmentId;
    private final int maxValue = 10000;
    private final int minValue = 0;
    private float amount;

    public BankAccount(IdGenerator idGenerator, float amount, String governmentId) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        accountId = idGenerator.generateId();
        this.amount = amount;

        this.governmentId = governmentId;
    }

    public float getAmount() {
        return amount;
    }

    public String getAccountId() {
        return accountId;
    }

    public void addBalance(float amount) {
        if (amount > maxValue) {
            throw new IllegalArgumentException("Amount cannot exceed " + maxValue);
        }
        this.amount = this.amount + amount;
    }

    public void withrawBalance(float amount) {
        if (amount > maxValue) {
            throw new IllegalArgumentException("Maximum withdrawal cannot exceed " + maxValue);
        }

        if (amount > this.amount) {
            throw new IllegalArgumentException("Amount of withdrawal exceeds balance");
        }

        if (amount <= minValue) {
            throw new IllegalArgumentException(String.format("Amount cannot exceed %d or be negative", minValue));
        }

        this.amount = this.amount - amount;
    }

    public String getGovenmentId() {
        return governmentId;
    }
}
