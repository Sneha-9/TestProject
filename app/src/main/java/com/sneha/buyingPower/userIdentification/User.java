package com.sneha.buyingPower.userIdentification;

import com.sneha.buyingPower.IdGenerator;

public class User {
    private final String id;
    private final String name;

    User(IdGenerator id, String name) {
        this.id = id.generate();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
