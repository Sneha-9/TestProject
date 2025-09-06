package com.sneha.parkingLot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.configuration.IMockitoConfiguration;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TerminalTest {
    private TimeUtil timeUtil = mock(TimeUtil.class);
    private  IdGenerator idGenerator=mock(IdGenerator.class);
    private Ticket ticket = mock(Ticket.class);
    private Vehicle vehicle = mock(Vehicle.class);
    private Lot lot = mock(Lot.class);
    private Floor floor = mock(Floor.class);

    @AfterEach
    void resetAfter(){
        reset(idGenerator);
    }
    @Test
    void shouldGenerateTicket(){
        when(timeUtil.getCurrentTime()).thenReturn(10L);
        when(ticket.getTicketId()).thenReturn("123sgde");
        when(lot.getId()).thenReturn("b5");
        when(floor.getId()).thenReturn("2");
        when(idGenerator.generate()).thenReturn("random");

        when(vehicle.getVehicleNumber()).thenReturn("123");
        Ticket actualTicket = new Terminal(idGenerator,timeUtil).generateTicket(idGenerator,vehicle,lot,floor);

        Ticket expectedTicket = new Ticket(idGenerator,timeUtil,"123","b5","2");
//        System.out.println(actualTicket);
//        System.out.println(expectedTicket);
        assertEquals(expectedTicket,actualTicket);
    }
    @Test
    void shouldGenerateBill(){
        when(idGenerator.generate()).thenReturn("random");
        when(ticket.getTicketId()).thenReturn("123s");
        when(ticket.getStartTime()).thenReturn(10l);
        when(ticket.getVehicleNumber()).thenReturn("123");

        when(timeUtil.getCurrentTime()).thenReturn(20l);


        Bill actualBill = new Terminal(idGenerator,timeUtil).generateBill(ticket);
       // System.out.println(actualBill);
        Bill expectedBill = new Bill(idGenerator,100,"123","123s",10L);
      //  System.out.println(expectedBill);
        assertEquals(expectedBill,actualBill);

    }

    @Test
    void throwsExceptionWhenIddoesntmatchpattern(){
        when(idGenerator.generate()).thenReturn("f472c3d479");
        assertThrows(IllegalArgumentException.class,()->new Terminal(idGenerator,timeUtil));
    }
    @Test
    void IdMatchesPatternforUUid(){
        when(idGenerator.generate()).thenReturn("f47ac10b-58cc-4372-a567-0e02b2c3d479");

        String terminal = new Terminal(idGenerator,timeUtil).getId();
        assertEquals("f47ac10b-58cc-4372-a567-0e02b2c3d479",terminal);
    }



}