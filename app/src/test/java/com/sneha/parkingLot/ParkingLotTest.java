package com.sneha.parkingLot;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.mockito.Mockito.*;

class ParkingLotTest {
    IdGenerator idGenerator = mock(IdGenerator.class);
    TimeUtil timeUtil = mock(TimeUtil.class);
    Terminal terminal = mock(Terminal.class);

    @AfterEach
    void resetMock() {
        reset(idGenerator);
    }

    @Test
    void shouldCreateFloorsInParkingLot() {
        Floor floor = mock(Floor.class);
        when(idGenerator.generate()).thenReturn(UUID.randomUUID().toString());
        ParkingLot parkingLot = new ParkingLot(idGenerator, timeUtil, terminal, floor);
        Assertions.assertDoesNotThrow(() -> parkingLot);

    }

    @Test
    void shouldThrowExceptionWhenFloorIsNotProvided() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ParkingLot(idGenerator, timeUtil, terminal));

    }

    @Test
    void shouldCreateTicket() {
        Vehicle vehicle = mock(Vehicle.class);
        Lot lot = mock(Lot.class);
        Floor floor = mock(Floor.class);
        Terminal terminal = mock(Terminal.class);

        when(floor.getAvailableLot()).thenReturn(lot);
        when(floor.getAvailableLot().isAvailable()).thenReturn(true);

        Ticket ticket = mock(Ticket.class);

        when(terminal.generateTicket(idGenerator, vehicle, lot, floor)).thenReturn(ticket);

        Ticket actualTicket = new ParkingLot(idGenerator, timeUtil, terminal, floor).parkVehicle(vehicle);

        Assertions.assertEquals(ticket, actualTicket);

    }

    @Test
    void throwExceptionIfLotIsNull() {
        Vehicle vehicle = mock(Vehicle.class);
        Floor floor = mock(Floor.class);
        Terminal terminal = mock(Terminal.class);

        Assertions.assertThrows(IllegalArgumentException.class, () -> new ParkingLot(idGenerator, timeUtil, terminal, floor).parkVehicle(vehicle));

    }

    @Test
    void shouldNotCreateTicket() {
        Vehicle vehicle = mock(Vehicle.class);
        Lot lot = mock(Lot.class);
        Floor floor = mock(Floor.class);
        Terminal terminal = mock(Terminal.class);

        when(floor.getAvailableLot()).thenReturn(lot);
        Assertions.assertThrows(IllegalArgumentException.class, () -> new ParkingLot(idGenerator, timeUtil, terminal, floor).parkVehicle(vehicle));
    }

    @Test
    void shouldCreateBill() {
        Ticket ticket = mock(Ticket.class);
        Floor floor = mock(Floor.class);
        Bill bill = mock(Bill.class);

        when(terminal.generateBill(ticket)).thenReturn(bill);

        Bill actualBill = new ParkingLot(idGenerator, timeUtil, terminal, floor).getBill(ticket);

        Assertions.assertEquals(bill, actualBill);

    }

    @Test
    void shouldFailToCreateToBill() {
        Ticket ticket = mock(Ticket.class);
        Floor floor = mock(Floor.class);
        when(terminal.generateBill(ticket)).thenThrow(new RuntimeException());
        Assertions.assertThrows(RuntimeException.class, () -> new ParkingLot(idGenerator, timeUtil, terminal, floor).getBill(ticket));

    }

    @Test
    void throwsExceptionWhenBillIsUnpaid(){
        Ticket ticket = mock(Ticket.class);
        Bill bill = mock(Bill.class);
        Floor floor =mock(Floor.class);

        when(bill.isPaid()).thenReturn(false);

        Assertions.assertThrows(UnpaidBillException.class,
                ()->new ParkingLot(idGenerator,timeUtil,terminal,floor).unPark(ticket,bill));
    }

    @Test
    void shouldUnparkVehicle() throws UnpaidBillException, FloorNotFoundException, LotNotFoundException {
        Vehicle vehicle=mock(Vehicle.class);
        Ticket ticket = mock(Ticket.class);

        Bill bill = mock(Bill.class);

        Floor floor =mock(Floor.class);

        when(bill.isPaid()).thenReturn(true);

        Lot lot = mock(Lot.class);

        when(ticket.getFloorId()).thenReturn("1234");

      when(floor.getId()).thenReturn("1234");

        when(ticket.getLotId()).thenReturn("12");

        when(floor.findLot(ticket.getLotId())).thenReturn(lot);
        when(lot.unparkVehicle()).thenReturn(vehicle);
        Assertions.assertEquals(vehicle,new ParkingLot(idGenerator,timeUtil,terminal,floor).unPark(ticket,bill));
    }
    @Test
    void shouldThrowExceptionWhenFloorIsNotFound() throws FloorNotFoundException, UnpaidBillException {
        Vehicle vehicle=mock(Vehicle.class);
        Ticket ticket = mock(Ticket.class);

        Bill bill = mock(Bill.class);

        Floor floor =mock(Floor.class);

        when(bill.isPaid()).thenReturn(true);

        Lot lot = mock(Lot.class);

        when(ticket.getFloorId()).thenReturn("1234");

    //    when(floor.getId()).thenReturn("1234");

       Assertions.assertThrows(FloorNotFoundException.class,()-> new ParkingLot(idGenerator,timeUtil,terminal,floor).unPark(ticket,bill));
    }
    @Test
    void shouldThrowExceptionWhenLotIsNotFound() throws FloorNotFoundException, UnpaidBillException {
        Vehicle vehicle=mock(Vehicle.class);
        Ticket ticket = mock(Ticket.class);

        Bill bill = mock(Bill.class);

        Floor floor =mock(Floor.class);

        when(bill.isPaid()).thenReturn(true);

        Lot lot = mock(Lot.class);

        when(ticket.getFloorId()).thenReturn("1234");

        when(floor.getId()).thenReturn("1234");


        Assertions.assertThrows(LotNotFoundException.class,()-> new ParkingLot(idGenerator,timeUtil,terminal,floor).unPark(ticket,bill));
    }
}