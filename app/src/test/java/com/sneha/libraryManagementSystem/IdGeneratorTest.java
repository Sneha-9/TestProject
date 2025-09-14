package com.sneha.libraryManagementSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IdGeneratorTest {

    @Test
    void validIdGenerated() {

        Assertions.assertDoesNotThrow(() -> new IdGenerator().generateId());
    }

}