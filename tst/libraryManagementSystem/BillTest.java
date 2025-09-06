package libraryManagementSystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BillTest {
    IdGenerator idGenerator = mock(IdGenerator.class);

    @AfterEach
    void mockReset(){
        reset(idGenerator);
    }

    @Test
    void billIsCreated(){
        when(idGenerator.generateId()).thenReturn("random");
        Assertions.assertDoesNotThrow(()->new Bill(idGenerator,"123",2,"ABC",10));
    }

    @Test
    void returnsTrueIfBillIsPaid(){
        when(idGenerator.generateId()).thenReturn("random");
        Bill b = new Bill(idGenerator,"12",2,"AB",10);
        b.markAsPaid();
        Assertions.assertEquals(true,b.isPaid());
    }
    @Test
    void returnsFalseIfBillIsNotPaid(){
        when(idGenerator.generateId()).thenReturn("random");
        Bill b = new Bill(idGenerator,"12",2,"AB",10);
        Assertions.assertEquals(false,b.isPaid());
    }

    @Test
    void throwsExceptionWhenAmountIsLessThanZero(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Bill(idGenerator,"123",-2,"ABC",10));
    }
    @Test
    void throwsExceptionWhenAmountIsEqualToZero(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Bill(idGenerator,"123",0,"ABC",10));
    }
    @Test
    void throwsExceptionWhenBookNameIsEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Bill(idGenerator,"123",10,"",10));
    }
    @Test
    void throwsExceptionWhenBookNameIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Bill(idGenerator,"123",10,null,10));
    }
    @Test
    void throwsExceptionWhenBookIdIsEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Bill(idGenerator,"",10,"ab",10));
    }
    @Test
    void throwsExceptionWhenBookIdIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Bill(idGenerator,null,10,"ab",10));
    }
    @Test
    void throwsExceptionWhenDurationIsNegative(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Bill(idGenerator,null,10,"ab",-10));
    }
    @Test
    void throwsExceptionWhenDurationIsZero(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Bill(idGenerator,null,10,"ab",0));
    }
}