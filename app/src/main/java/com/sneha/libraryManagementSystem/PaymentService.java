package com.sneha.libraryManagementSystem;

public class PaymentService {

    public Bill payBill(Bill bill) {
        bill.markAsPaid();
        return bill;
    }
}
