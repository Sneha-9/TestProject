package com.sneha.vendingMachine;

public class Product {
    private final String name;
    private final Amount amount;
    private final String id;

    Product(String name, String id, Amount amount) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be epty or null");

        }
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Id cannot be null or empty");
        }
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }
        this.amount = amount;
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
}
