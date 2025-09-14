package com.sneha.parkingLot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LotTest {

    private final IdGenerator idGenerator = mock(IdGenerator.class);
    private final TimeUtil timeUtil = mock(TimeUtil.class);


    @AfterEach
    void reset() {
        Mockito.reset(idGenerator, timeUtil);
    }

    @Test
    void testCreateNewLotForTwoWheelerSuccess() {
        when(idGenerator.generate()).thenReturn(UUID.randomUUID().toString());
        assertDoesNotThrow(() -> new Lot(idGenerator, Constants.TWO_WHEELER));
    }

    @Test
    void testCreateNewLotForFourWheelerSuccess() {
        when(idGenerator.generate()).thenReturn(UUID.randomUUID().toString());
        assertDoesNotThrow(() -> new Lot(idGenerator, Constants.FOUR_WHEELER));
    }

    @Test
    void throwsExceptionWhenIdDoesNotMatchPattern() {
        when(idGenerator.generate()).thenReturn("f472c3d479");
        assertThrows(IllegalArgumentException.class, () -> new Lot(idGenerator, Constants.TWO_WHEELER));
    }

    @Test
    void throwsExceptionWhenVehicleTypeDoesNotMatchPattern() {
        when(idGenerator.generate()).thenReturn("f472c3d479");
        assertThrows(IllegalArgumentException.class, () -> new Lot(idGenerator, "THREE_WHEELER"));
    }

    @Test
    void checkIfLotIsAvailable() {
        when(idGenerator.generate()).thenReturn(UUID.randomUUID().toString());

        Lot lot = new Lot(idGenerator, Constants.TWO_WHEELER);

        assertTrue(lot.isAvailable());
    }

    @Test
    void checkIfLotIsNotAvailable() {
        Vehicle vehicle = mock(Vehicle.class);
        when(idGenerator.generate()).thenReturn("f47ac10b-58cc-4372-a567-0e02b2c3d479");
        Lot lot = new Lot(idGenerator, Constants.TWO_WHEELER);
        lot.parkVehicle(vehicle);
        //when(vehicle.getVehicleType()).thenReturn("TWO_WHEELER");
        //when(vehicle.getVehicleNumber()).thenReturn("123");
        System.out.println(vehicle.getVehicleNumber() + " " + vehicle.getVehicleType() + " " + lot.isAvailable());

        assertFalse(lot.isAvailable());

    }

    @Test
    void checkIfVehicleIsUnparked() {
        Vehicle vehicle = mock(Vehicle.class);
        when(idGenerator.generate()).thenReturn("f47ac10b-58cc-4372-a567-0e02b2c3d479");
        Lot lot = new Lot(idGenerator, Constants.TWO_WHEELER);
        lot.parkVehicle(vehicle);
        lot.unparkVehicle();
        //System.out.println(vehicle.getVehicleNumber()+" "+ vehicle.getVehicleType()+ " "+ mockLot.isAvailable());

        assertTrue(lot.isAvailable());

    }
}