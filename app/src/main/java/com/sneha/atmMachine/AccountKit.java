package com.sneha.atmMachine;

public class AccountKit {
    private final String accountId;
    private final Card card;

    AccountKit(Card card, String accountId) {
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("account id cannot be null or empty");
        }
        this.accountId = accountId;
        this.card = card;
    }

    public String getAccountId() {
        return accountId;
    }

    public Card getCard() {
        return card;
    }
}
