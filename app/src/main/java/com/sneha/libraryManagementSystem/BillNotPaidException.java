package com.sneha.libraryManagementSystem;

public class BillNotPaidException extends Exception {
    public BillNotPaidException() {
        super("Bill not paid");
    }
}
