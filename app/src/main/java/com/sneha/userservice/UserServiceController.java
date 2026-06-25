package com.sneha.userservice;

import com.sneha.userservice.exception.ValidationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceController {

    private UserService userService;

    @PostMapping(value = "/register/user")
    void registerUser(String name, String email) throws ValidationException {
        userService.registerUser(name,email);
    }

    @PostMapping(value = "/validate/user")
    void validateUser(String id){
        userService.validateUserById(id);

    }




}
