package com.sneha.splitwise;

public class Debt {
    private Amount amountOwed;
    private String payer;
    private String payee;
    Debt(Amount amountOwed,String payee,String payer){
        this.amountOwed=amountOwed;
        this.payee = payee;
        this.payer = payer;
    }

    public Amount getAmountOwed() {
        return amountOwed;
    }

    public String getPayee() {
        return payee;
    }

    public String getPayer() {
        return payer;
    }
}
