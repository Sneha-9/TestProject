package com.sneha.parkingLot;

public class PaymentService {

    public PaymentService() {

    }

    public Bill payBill(Bill bill) {
        bill.markAsPaid();
        return bill;
    }
}
