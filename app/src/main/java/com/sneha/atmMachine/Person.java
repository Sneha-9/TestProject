package com.sneha.atmMachine;

public class Person {
    private final String governmentId;

    Person(IdGenerator idGenerator) {
        this.governmentId = idGenerator.generateId();
    }

    public String getGovernmentId() {
        return governmentId;
    }
}
