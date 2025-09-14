package com.sneha.libraryManagementSystem;

import java.util.UUID;

public class IdGenerator {

    private final String regex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[1-5][0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";

    public String generateId() throws IllegalArgumentException {
        String id = UUID.randomUUID().toString();

        if (!id.matches(regex)) {
            throw new IllegalArgumentException("Id generated invalid");
        }

        return id;
    }


}
