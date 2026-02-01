package com.sneha.atmMachine;


import com.sneha.atmMachine.database.CardDataBase;
import com.sneha.bankService.Bank;
import com.sneha.bankService.BankAccount;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class ATMTest {
    IdGenerator idGenerator = mock(IdGenerator.class);

    @AfterEach
    void mockReset() {
        reset(idGenerator);
    }

    @Test
    void shouldWithdrawAmount() {

        CardDataBase cardDatabase = mock(CardDataBase.class);
        Card card = mock(Card.class);


        when(card.id()).thenReturn("123");
        when(card.accountId()).thenReturn("123456");


        Bank bank = mock(Bank.class);

        when(bank.validateAccount(card)).thenReturn(true);
        BankAccount bankAccount = mock(BankAccount.class);

        when(cardDatabase.validateCard(card)).thenReturn(card);
        when(bank.getAccountDetails("123456")).thenReturn(bankAccount);

        when(bankAccount.getAmount()).thenReturn(100f);

        ATM atm = new ATM(bank, cardDatabase);
        Assertions.assertEquals(100f, atm.withdrawMoney(card, 100f));
        verify(bankAccount, times(1)).withrawBalance(100f);

    }


    @Test
    void shouldCheckBalance() {
        CardDataBase cardDatabase = mock(CardDataBase.class);
        Card card = mock(Card.class);

        Bank bank = mock(Bank.class);
        when(card.id()).thenReturn("123");
        when(card.accountId()).thenReturn("123456");


        when(bank.validateAccount(card)).thenReturn(true);
        when(cardDatabase.validateCard(card)).thenReturn(card);

        BankAccount bankAccount = mock(BankAccount.class);
        when(bank.getAccountDetails("123456")).thenReturn(bankAccount);
        when(bankAccount.getAmount()).thenReturn(100f);
        ATM atm = new ATM(bank, cardDatabase);

        Assertions.assertEquals(100f, atm.checkBalance(card));
        verify(bankAccount, times(1)).getAmount();
    }
}