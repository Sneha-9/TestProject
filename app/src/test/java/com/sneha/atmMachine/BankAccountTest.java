package com.sneha.atmMachine;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BankAccountTest {
    IdGenerator idGenerator = mock(IdGenerator.class);
    Person person = mock(Person.class);

    @AfterEach
    void mockReset(){
        reset(idGenerator);
    }


    @Test
    void throwExceptionWhenAmountIsLessThanZero(){
        Card mockcard= mock(Card.class);
        when(mockcard.getId()).thenReturn("123");
        when(idGenerator.generateId()).thenReturn("random");

        Assertions.assertThrows(IllegalArgumentException.class,()->new BankAccount(idGenerator,-10,person.getGovernmentId()));
    }

    @Test
    void throwExceptionWhenAmountIsGreaterThanTenThousand(){
        Card mockcard= mock(Card.class);
        when(mockcard.getId()).thenReturn("123");
        when(idGenerator.generateId()).thenReturn("random");

        Assertions.assertThrows(IllegalArgumentException.class,()->new BankAccount(idGenerator,10,person.getGovernmentId()).addBalance(100000));
    }
    @Test
    void throwExceptionWhenWithdrawalMoneyIsNegative(){
        Card mockcard= mock(Card.class);
        when(mockcard.getId()).thenReturn("123");
        when(idGenerator.generateId()).thenReturn("random");
        Assertions.assertThrows(IllegalArgumentException.class,()->new BankAccount(idGenerator,10,person.getGovernmentId()).withrawBalance(-10));
    }
    @Test
    void throwExceptionWhenWithdrawalMoneyIsGreaterThanTenThousand(){
        Card mockcard= mock(Card.class);
        when(mockcard.getId()).thenReturn("123");
        when(idGenerator.generateId()).thenReturn("random");
        Assertions.assertThrows(IllegalArgumentException.class,()->new BankAccount(idGenerator,10,person.getGovernmentId()).withrawBalance(100000));
    }
    @Test
    void throwExceptionWhenWithdrawalMoneyIsEqualToZero(){
        Card mockcard= mock(Card.class);
        when(mockcard.getId()).thenReturn("123");
        when(idGenerator.generateId()).thenReturn("random");
        Assertions.assertThrows(IllegalArgumentException.class,()->new BankAccount(idGenerator,10,person.getGovernmentId()).withrawBalance(0));
    }

    @Test
    void throwExceptionWhenWithdrawalMoneyIsGreaterThanBalance(){
        Card mockcard= mock(Card.class);
        when(mockcard.getId()).thenReturn("123");
        when(idGenerator.generateId()).thenReturn("random");
        Assertions.assertThrows(IllegalArgumentException.class,()->new BankAccount(idGenerator,10,person.getGovernmentId()).withrawBalance(100000));
    }




}