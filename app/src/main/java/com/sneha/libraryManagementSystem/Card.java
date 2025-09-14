package com.sneha.libraryManagementSystem;


public class Card {
    private final String id;

    Card(IdGenerator idGenerator) {
        this.id = idGenerator.generateId();
    }

    public String getId() {
        return id;
    }

}
