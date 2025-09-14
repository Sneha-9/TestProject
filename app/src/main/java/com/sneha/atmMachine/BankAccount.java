package com.sneha.atmMachine;

public class BankAccount {
    private final String accountId;
    private float amount;
    private final String govenmentId;

    private final int maxValue = 10000;
    private final int minValue = 0;

    public BankAccount(IdGenerator idGenerator, float amount, String govenmentId) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }

        accountId = idGenerator.generateId();
        this.amount = amount;

        this.govenmentId = govenmentId;
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
            throw new IllegalArgumentException("Maxmium withdrawal cannot exceed " + maxValue);
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
        return govenmentId;
    }
}
