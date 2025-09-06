package com.sneha.atmMachine;

public class Person {
    private String governmentId;

    Person(IdGenerator idGenerator){
        this.governmentId = idGenerator.generateId();
    }

    public String getGovernmentId() {
        return governmentId;
    }
}
