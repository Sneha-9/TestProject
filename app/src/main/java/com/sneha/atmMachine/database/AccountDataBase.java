package com.sneha.atmMachine.database;

import com.sneha.atmMachine.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class AccountDataBase {

    List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount bankAccount) {
        accounts.add(bankAccount);
    }

    public BankAccount getAccountByAccountId(String accountId) {
        for (BankAccount account : accounts) {
            if (account.getAccountId().equals(accountId)) {
                return account;
            }
        }
        return null;
    }

    public BankAccount getEntryByGovernmentId(String governmentId) {
        for (BankAccount account : accounts) {
            if (account.getGovenmentId().equals(governmentId)) {
                return account;
            }
        }
        return null;
    }


//    private BankAccount getAccount(Function<BankAccount, String> function, String key) {
//        for (BankAccount account : accounts) {
//            if (function.apply(account).equals(key)) {
//                return account;
//            }
//        }
//
//        return null;
//    }
}
