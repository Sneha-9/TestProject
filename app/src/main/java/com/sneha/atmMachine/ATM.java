package com.sneha.atmMachine;

import com.sneha.atmMachine.database.CardDataBase;
import com.sneha.bankService.Bank;
import com.sneha.bankService.BankAccount;

public class ATM {
    private final Bank bank;
    private final CardDataBase cardDataBase;

    ATM(Bank bank, CardDataBase cardDataBase) {
        this.bank = bank;
        this.cardDataBase = cardDataBase;
    }

    public float withdrawMoney(Card card, float withdrawAmount) {
        boolean validateCard = bank.validateAccount(card);
        if (!validateCard) {
            throw new IllegalArgumentException("Card is not valid");
        }

        Card cardEntry = cardDataBase.validateCard(card);
        BankAccount accountDetails = bank.getAccountDetails(cardEntry.getAccountId());

        float balance = accountDetails.getAmount();

        if (balance < withdrawAmount) {
            throw new IllegalArgumentException("Withdraw Amount cannot exceed balance");
        }

        if (withdrawAmount > 10000) {
            throw new IllegalArgumentException("Maximum withdrawal shouldn't exceed 10,1000");
        }

        accountDetails.withrawBalance(withdrawAmount);

        return accountDetails.getAmount();

    }

    public float checkBalance(Card card) {
        boolean validateCard = bank.validateAccount(card);
        if (!validateCard) {
            throw new IllegalArgumentException("Card is not valid");
        }

        Card cardEntry = cardDataBase.validateCard(card); //get card

        BankAccount accountDetails = bank.getAccountDetails(cardEntry.getAccountId());

        return accountDetails.getAmount();
    }
}
