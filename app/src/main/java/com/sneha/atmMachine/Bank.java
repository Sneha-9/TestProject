package com.sneha.atmMachine;

import atmMachine.database.AccountDataBase;
import atmMachine.database.CardDataBase;
import list.stack.Stack;

import java.util.Objects;

public class Bank {
    private CardDataBase cardDataBase;
    private AccountDataBase accountDataBase;
    private IdGenerator idGenerator;

    private final int maxWithdrawalLimit = 10000;
    private final int minWithdrawalLimit = 0;

    public Bank(IdGenerator idGenerator, AccountDataBase accountDataBase, CardDataBase cardDataBase) {
        this.accountDataBase = accountDataBase;
        this.idGenerator = idGenerator;
        this.cardDataBase = cardDataBase;
    }

    public AccountKit createAccount(String governmentId) {
        if (governmentId == null || governmentId.isEmpty()) {
            throw new IllegalArgumentException("Government id cannot be null or empty");
        }

        BankAccount accountDetails = accountDataBase.getEntryByGovernmentId(governmentId);
        if (accountDetails != null) {
            throw new IllegalArgumentException("Government Id already exists in system");
        }

        BankAccount newAccount = new BankAccount(idGenerator, 0, governmentId);
        Card newCard = new Card(idGenerator, newAccount.getAccountId());

        accountDataBase.addAccount(newAccount);
        cardDataBase.addCard(newCard);

        return issueKit(newCard, newAccount.getAccountId());
    }

    public float depositMoney(float amount, String accountId) {
        if (amount > maxWithdrawalLimit) {
            throw new IllegalArgumentException("Deposit Amount shouldn't exceed 10,000");
        }

        if (amount <= minWithdrawalLimit) {
            throw new IllegalArgumentException("Amount cannot be less than or equal to zero");
        }

        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("Account id cannot be null or empty");
        }

        BankAccount bankAccount = accountDataBase.getAccountByAccountId(accountId);
        if (bankAccount == null) {
            throw new IllegalArgumentException("Account does not exist");
        }

        bankAccount.addBalance(amount);

        return bankAccount.getAmount();
    }

    public boolean validateAccount(Card card) {
        Card cardEntry = cardDataBase.validateCard(card);
        return cardEntry != null;
    }

    public BankAccount getAccountDetails(String accountId) {
        BankAccount accountDetails = accountDataBase.getAccountByAccountId(accountId);
        return accountDetails;
    }

    private AccountKit issueKit(Card card, String accountId) {
        return new AccountKit(card, accountId);
    }
}
