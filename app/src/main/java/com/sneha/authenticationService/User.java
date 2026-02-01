package com.sneha.authenticationService;

public class User {
    private final String name;
    private final String password;
    // private String email;
    private final long createdAt;
    private final long updatedAt;
    private final String id;

    User(IdGenerator idGenerator, TimeUtil timeUtil, String name, String password) {
        this.name = name;
        this.password = password;
        //this.email = email;
        this.createdAt = timeUtil.getCurrentTime();
        this.updatedAt = timeUtil.getCurrentTime();
        this.id = idGenerator.generate();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }


    public String getId() {
        return id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }
}
