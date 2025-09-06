package parkingLot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;

class FloorTest {
    private IdGenerator idGenerator = mock(IdGenerator.class);

    @AfterEach
    void resetMocks() {
        reset(idGenerator);
    }

    @Test
    void shouldCreateAFloor(){
        Lot mockLot = mock(Lot.class);
        Assertions.assertDoesNotThrow(() -> new Floor(idGenerator, mockLot));
    }

    @Test
    void shouldThrowExceptionWhenLotIsEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> new Floor(idGenerator));
    }

    @Test
    void shouldReturnDesiredLot(){
        Lot mockLot = mock(Lot.class);

        Floor floor= new Floor(idGenerator, mockLot);

        Assertions.assertEquals(mockLot, floor.findLot(mockLot.getId()));
    }

    @Test

    void shouldNotReturnLotIfLotIdIsNotFound(){
        Lot mockLot = mock(Lot.class);

        Floor floor= new Floor(idGenerator, mockLot);

        Assertions.assertNotEquals(UUID.randomUUID().toString(),floor.findLot(mockLot.getId()));
    }

    @Test
    void shouldReturnAvailableLots(){
        Lot mockLotOne = mock(Lot.class);
        when(mockLotOne.isAvailable()).thenReturn(true).thenReturn(false);

        Lot mockLotTwo = mock(Lot.class);
        when(mockLotTwo.isAvailable()).thenReturn(true).thenReturn(false);

        Floor floor= new Floor(idGenerator, mockLotOne, mockLotTwo);

        Assertions.assertEquals(mockLotOne, floor.getAvailableLot());
        Assertions.assertEquals(mockLotTwo, floor.getAvailableLot());
        Assertions.assertNull(floor.getAvailableLot());
    }


}