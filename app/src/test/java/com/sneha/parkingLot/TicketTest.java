package com.sneha.parkingLot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class TicketTest {
    private final TimeUtil timeUtil = mock(TimeUtil.class);
    private final IdGenerator idGenerator = mock(IdGenerator.class);

    @Test
    void throwsExceptionWhenLotIdIsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ticket(idGenerator, timeUtil, "", "12", "123s").getLotId());
    }

    @Test
    void throwsExceptionWhenLotIdIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ticket(idGenerator, timeUtil, null, "12", "123s").getLotId());
    }

    @Test
    void throwsExceptionWhenFloorIdIsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ticket(idGenerator, timeUtil, "s3", "", "123s").getFloorId());
    }

    @Test
    void throwsExceptionWhenFloorIdIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ticket(idGenerator, timeUtil, "s3", null, "123s").getFloorId());
    }

    @Test
    void throwsExceptionWhenVehicleNumberIsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ticket(idGenerator, timeUtil, "s3", "12", "123s").getVehicleNumber());
    }

    @Test
    void throwsExceptionWhenVehicleNumberIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Ticket(idGenerator, timeUtil, "s3", "12", "123s").getVehicleNumber());
    }

    @Test
    void validatesAssignedVehicleNumber() {
        assertEquals("123s", new Ticket(idGenerator, timeUtil, "s3", "12", "123s").getVehicleNumber());
    }

    @Test
    void validatesAssignedLotId() {
        assertEquals("s3", new Ticket(idGenerator, timeUtil, "s3", "12", "123s").getLotId());
    }

    @Test
    void validatesAssignedFloorId() {
        assertEquals("12", new Ticket(idGenerator, timeUtil, "s3", "12", "123s").getFloorId());
    }

}