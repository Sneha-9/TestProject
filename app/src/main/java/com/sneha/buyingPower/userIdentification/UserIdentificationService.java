package com.sneha.buyingPower.userIdentification;

public class UserIdentificationService {
    private final UserIdentificationDatabase userIdentificationDatabase;

    public UserIdentificationService(UserIdentificationDatabase userIdentificationDatabase) {
        this.userIdentificationDatabase = userIdentificationDatabase;
    }

    public boolean validateUser(String userId) {
        return userIdentificationDatabase.validateUser(userId);
    }
}
