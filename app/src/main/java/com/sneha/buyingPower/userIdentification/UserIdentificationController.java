package com.sneha.buyingPower.userIdentification;

import com.sneha.buyingPower.IdGenerator;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserIdentificationController {
    private IdGenerator idGenerator =  new IdGenerator();
    private UserIdentificationDatabase userIdentificationDatabase = new UserIdentificationDatabase();
    private UserIdentificationService userIdentificationService = new UserIdentificationService(userIdentificationDatabase);

    @GetMapping(value =  "/userIdentificationService/validate-user/{userId}", produces = "application/json")
    ValidateUserResponse validateUser(@PathVariable("userId") String userId){
        boolean response = userIdentificationService.validateUser(userId);
         return  new ValidateUserResponse(response);
    }
}
