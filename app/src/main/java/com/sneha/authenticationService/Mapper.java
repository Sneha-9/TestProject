package com.sneha.authenticationService;

public class Mapper {
    private final IdGenerator idGenerator;
    private final TimeUtil timeUtil;

    public Mapper(IdGenerator idGenerator, TimeUtil timeUtil) {
        this.idGenerator = idGenerator;
        this.timeUtil = timeUtil;
    }

    User mapCreateUserRequestToUser(String username, String password) {
        return new User(idGenerator, timeUtil, username, password);
    }


    TokenGenerationResponse mapTokenGenerationResponseToId(String id) {
        return new TokenGenerationResponse(id);
    }


}
