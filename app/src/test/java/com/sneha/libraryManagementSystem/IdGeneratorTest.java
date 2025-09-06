package com.sneha.libraryManagementSystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IdGeneratorTest {

    @Test
    void validIdGenerated(){

        Assertions.assertDoesNotThrow(()->new IdGenerator().generateId());
    }

}