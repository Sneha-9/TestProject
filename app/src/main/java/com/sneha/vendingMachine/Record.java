package com.sneha.vendingMachine;

public class Record {
    private int quantity;
    private final int productNumber;
    private final String productId;

    Record(int quantity, int productNumber, String productId) {
        //q
        this.quantity = quantity;
        this.productId = productId;
        this.productNumber = productNumber;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decrementQuantity() {
        this.quantity = quantity - 1;
    }
}
