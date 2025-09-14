package com.sneha.splitwise;

public class Person {
    private final Amount amountSpent;
    private final String name;

    Person(String name, Amount amountSpent) {
        this.amountSpent = amountSpent;
        this.name = name;
    }

    public Amount getAmountSpent() {
        return amountSpent;
    }

    public String getName() {
        return name;
    }
}
