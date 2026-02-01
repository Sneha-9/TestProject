package com.sneha.atmMachine;

import com.sneha.bankService.AccountDataBase;
import com.sneha.atmMachine.database.CardDataBase;
import com.sneha.bankService.Bank;
import com.sneha.bankService.BankAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class BankTest {
    IdGenerator idGenerator = mock(IdGenerator.class);

    @AfterEach
    void mockReset() {
        reset(idGenerator);
    }

    @Test
    void shouldCreateAccount() {
        AccountDataBase accountDataBase = mock(AccountDataBase.class);
        CardDataBase cardDataBase = mock(CardDataBase.class);

        when(idGenerator.generateId()).thenReturn("accountId").thenReturn("cardId");

        Bank bank = new Bank(idGenerator, accountDataBase, cardDataBase);

        AccountKit accountKit = bank.createAccount("123");

        Assertions.assertNotNull(accountKit);
        assertEquals("accountId", accountKit.accountId());
        assertEquals("cardId", accountKit.card().id());
    }


    @Test
    void shouldThrowExceptionWhenGovernmentIdIsNull() {
        AccountDataBase accountDataBase = mock(AccountDataBase.class);
        BankAccount bankAccount = mock(BankAccount.class);
        CardDataBase cardDataBase = mock(CardDataBase.class);

        Bank bank = new Bank(idGenerator, accountDataBase, cardDataBase);
        Assertions.assertThrows(IllegalArgumentException.class, () -> bank.createAccount(null));
    }

    @Test
    void shouldThrowExceptionWhenGovernmentIdIsEmpty() {
        AccountDataBase accountDataBase = mock(AccountDataBase.class);
        BankAccount bankAccount = mock(BankAccount.class);
        CardDataBase cardDataBase = mock(CardDataBase.class);

        Bank bank = new Bank(idGenerator, accountDataBase, cardDataBase);
        Assertions.assertThrows(IllegalArgumentException.class, () -> bank.createAccount(""));
    }

    @Test
    void shouldThrowExceptionWhenGovernmentIdAlreadyExists() {
        AccountDataBase accountDataBase = mock(AccountDataBase.class);
        BankAccount bankAccount = mock(BankAccount.class);
        CardDataBase cardDataBase = mock(CardDataBase.class);

        when(bankAccount.getGovenmentId()).thenReturn("123");
        Bank bank = new Bank(idGenerator, accountDataBase, cardDataBase);

        Assertions.assertThrows(IllegalArgumentException.class, () -> bank.createAccount("123"));
    }

    @Test
    void shouldDepositMoney() {
        String accountId = "123";
        AccountDataBase accountDataBase = mock(AccountDataBase.class);
        CardDataBase cardDataBase = mock(CardDataBase.class);
        BankAccount bankAccount = mock(BankAccount.class);

        Bank bank = new Bank(idGenerator, accountDataBase, cardDataBase);

        //when(bankAccount.getAccountId()).thenReturn("123");
        when(accountDataBase.getAccountByAccountId("123")).thenReturn(bankAccount);

        doNothing().when(bankAccount).addBalance(100);

        when(bankAccount.getAmount()).thenReturn((float) 100);

        bank.depositMoney(100, "123");

        verify(bankAccount, times(1)).addBalance(100);
        verify(bankAccount, times(1)).getAmount();
    }

    @Test
    void shouldThrowExceptionWhenAmountIsNegative() {
        AccountDataBase accountDataBase = mock(AccountDataBase.class);
        CardDataBase cardDataBase = mock(CardDataBase.class);
        Bank bank = new Bank(idGenerator, accountDataBase, cardDataBase);

        Assertions.assertThrows(IllegalArgumentException.class, () -> bank.depositMoney(0, "123"));
    }

    @Test
    void shouldThrowExceptionWhenAmountExceed10000() {
        AccountDataBase accountDataBase = mock(AccountDataBase.class);
        CardDataBase cardDataBase = mock(CardDataBase.class);
        Bank bank = new Bank(idGenerator, accountDataBase, cardDataBase);

        Assertions.assertThrows(IllegalArgumentException.class, () -> bank.depositMoney(1000000, "123"));
    }

    @Test
    void shouldThrowExceptionWhenAccountIdIsEmpty() {
        AccountDataBase accountDataBase = mock(AccountDataBase.class);
        CardDataBase cardDataBase = mock(CardDataBase.class);
        Bank bank = new Bank(idGenerator, accountDataBase, cardDataBase);

        Assertions.assertThrows(IllegalArgumentException.class, () -> bank.depositMoney(100, ""));
    }

    @Test
    void shouldThrowExceptionWhenAccountIdIsNull() {
        AccountDataBase accountDataBase = mock(AccountDataBase.class);
        CardDataBase cardDataBase = mock(CardDataBase.class);
        Bank bank = new Bank(idGenerator, accountDataBase, cardDataBase);

        Assertions.assertThrows(IllegalArgumentException.class, () -> bank.depositMoney(100, null));
    }

    @Test
    void shouldValidateCardAsTrue() {
        AccountDataBase accountDataBase = mock(AccountDataBase.class);
        CardDataBase cardDataBase = mock(CardDataBase.class);
        Card card = mock(Card.class);
        Bank bank = new Bank(idGenerator, accountDataBase, cardDataBase);
        when(cardDataBase.validateCard(card)).thenReturn(card);

        assertTrue(bank.validateAccount(card));
        verify(cardDataBase, times(1)).validateCard(card);

    }


}