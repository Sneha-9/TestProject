package com.sneha.parkingLot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class BillGenerationSystemTest {

    private final TimeUtil timeUtil = mock(TimeUtil.class);
    private final IdGenerator idGenerator = mock(IdGenerator.class);
    private final Ticket ticket = mock(Ticket.class);

    @AfterEach
    void resetMocks() {
        reset(timeUtil);
    }


    @Test
    void shouldGenerateBill() {

        when(ticket.getStartTime()).thenReturn(10L);
        when(ticket.getVehicleNumber()).thenReturn("123");
        when(ticket.getTicketId()).thenReturn("12s0");
        when(timeUtil.getCurrentTime()).thenReturn(20L);

        when(idGenerator.generate()).thenReturn("randomId");

        Bill actualBill = new BillGenerationSystem(idGenerator, timeUtil).generateBill(ticket);
        System.out.println(actualBill);

        Bill expectedBill = new Bill(idGenerator, 100, ticket.getVehicleNumber(), ticket.getTicketId(), 10L);
        System.out.println(expectedBill);
        Assertions.assertEquals(expectedBill, actualBill);
    }

    @Test
    void throwsExceptionWhenIddoesntmatchpattern() {
        when(idGenerator.generate()).thenReturn("f472c3d479");
        assertThrows(IllegalArgumentException.class, () -> new Terminal(idGenerator, timeUtil));
    }

    @Test
    void IdMatchesPatternforUUid() {
        when(idGenerator.generate()).thenReturn("f47ac10b-58cc-4372-a567-0e02b2c3d479");

        String terminal = new Terminal(idGenerator, timeUtil).getId();
        assertEquals("f47ac10b-58cc-4372-a567-0e02b2c3d479", terminal);
    }


}