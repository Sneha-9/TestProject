package com.sneha.atmMachine;

public record AccountKit(Card card, String accountId) {
    public AccountKit {
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("account id cannot be null or empty");
        }
    }
}
