package com.sneha.userservice;

import com.sneha.userservice.exception.ValidationException;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserServiceDatabase userServiceDatabase;


    void registerUser(String name, String email) throws ValidationException {
        if(name == null || name.isEmpty()){
            throw new ValidationException("Name cannot be empty");
        }
        if(email == null || email.isEmpty()){
            throw new ValidationException("Email cannot be empty");
        }

        if(validateUserByEmail(email)){
            throw new ValidationException("User with this email already exist");
        }

        userServiceDatabase.addUser(name, email);
    }

    boolean validateUserById(String id){
        return userServiceDatabase.validateUser(id);
    }

    boolean validateUserByEmail(String email){
        return false;
    }
}
