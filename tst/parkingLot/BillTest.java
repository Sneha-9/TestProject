package parkingLot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shapes.Square;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BillTest {

    private IdGenerator idGenerator = mock(IdGenerator.class);

    @Test
    void returnsTrueWhenBillIsPaid(){
        Bill b = new Bill(idGenerator, 2,"123","sde",2);
        b.markAsPaid();

        Assertions.assertEquals(true ,b.isPaid() );

    }

    @Test
    void returnsFalseIfBillIsNotPaid(){
        Bill b = new Bill(idGenerator, 2,"123","sde",2);
        Assertions.assertEquals(false ,b.isPaid() );
    }

    @Test
    void throwsExceptionIfAmountOfTheTicketIsZero(){
        Assertions.assertThrows(IllegalArgumentException.class,() ->new Bill(idGenerator, 0,"123","sde",2).isPaid());
    }

    @Test
    void throwsExceptionIfAmountOfTheTicketIsLessThanZero(){
        Assertions.assertThrows(IllegalArgumentException.class,() ->new Bill(idGenerator, -8,"123","sde",2).isPaid());
    }
    @Test
    void throwsExceptionWhenVehicleNumberIsEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Bill(idGenerator,1,"","2s",2).isPaid());
    }

    @Test
    void throwsExceptionWhenVehicleNumberIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Bill(idGenerator,1,null,"2s",2).isPaid());
    }
    @Test
    void throwsExceptionWhenDurationIsZero(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Bill(idGenerator,1,"123","2s",0).isPaid());
    }
    @Test
    void throwsExceptionWhenDurationIsNegative(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Bill(idGenerator,1,"123","2s",-8).isPaid());
    }
    @Test
    void throwsExceptionWhenTicketIdIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Bill(idGenerator,1,"123","2s",0).isPaid());
    }
    @Test
    void throwsExceptionWhenDurationIsEmtpy(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Bill(idGenerator,1,"123","2s",-8).isPaid());
    }

  
}