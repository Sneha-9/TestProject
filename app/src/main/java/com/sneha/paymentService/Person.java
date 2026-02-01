package com.sneha.paymentService;

import com.sneha.bankService.BankAccount;

public class Person {
    private final BankAccount bankAccount;

    Person(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
