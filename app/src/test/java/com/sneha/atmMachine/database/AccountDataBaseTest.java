package com.sneha.atmMachine.database;

import com.sneha.atmMachine.BankAccount;
import com.sneha.atmMachine.IdGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AccountDataBaseTest {
    IdGenerator idGenerator = mock(IdGenerator.class);

    @AfterEach
    void mockReset() {
        reset(idGenerator);
    }

    @Test
    void shouldGetAccountByAccountId() {
        BankAccount bankAccount = mock(BankAccount.class);
        when(bankAccount.getAccountId()).thenReturn("123456");
        when(bankAccount.getGovenmentId()).thenReturn("123");


        AccountDataBase accountDataBase = new AccountDataBase();
        accountDataBase.addAccount(bankAccount);

        assertEquals(bankAccount, accountDataBase.getAccountByAccountId("123456"));
    }

    @Test
    void shouldGetNulltIfAccountIdNotFound() {
        BankAccount bankAccount = mock(BankAccount.class);
        when(bankAccount.getAccountId()).thenReturn("123456");
        when(bankAccount.getGovenmentId()).thenReturn("123");


        AccountDataBase accountDataBase = new AccountDataBase();


        Assertions.assertNull(accountDataBase.getAccountByAccountId("123456"));
    }

    @Test
    void shouldGetNulltIfGovernmentIdNotFound() {
        BankAccount bankAccount = mock(BankAccount.class);
        when(bankAccount.getAccountId()).thenReturn("123456");
        when(bankAccount.getGovenmentId()).thenReturn("123");


        AccountDataBase accountDataBase = new AccountDataBase();


        Assertions.assertNull(accountDataBase.getEntryByGovernmentId("123456"));
    }

    @Test
    void shouldGetAccountByGovernmentId() {
        BankAccount bankAccount = mock(BankAccount.class);
        when(bankAccount.getAccountId()).thenReturn("123456");
        when(bankAccount.getGovenmentId()).thenReturn("123");


        AccountDataBase accountDataBase = new AccountDataBase();
        accountDataBase.addAccount(bankAccount);

        assertEquals(bankAccount, accountDataBase.getEntryByGovernmentId("123"));
    }
}