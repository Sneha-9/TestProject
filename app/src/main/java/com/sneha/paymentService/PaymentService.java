package com.sneha.paymentService;

import com.sneha.bankService.BankAccount;

public class PaymentService {

    void executeTransaction(Person payer, Person payee, int amount) {
        BankAccount payerAccount = payer.getBankAccount();
        BankAccount payeeAccount = payee.getBankAccount();

        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");

        }
        if (amount > payerAccount.getAmount()) {
            throw new IllegalArgumentException("Not enough balance to proceed with the transaction");
        }


        payerAccount.withrawBalance(amount);

        payeeAccount.addBalance(amount);

    }
}
