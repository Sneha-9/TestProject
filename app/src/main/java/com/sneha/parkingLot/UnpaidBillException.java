package com.sneha.parkingLot;

public class UnpaidBillException extends Exception{
   public UnpaidBillException(){
        super("Bill is not paid");
    }
}
