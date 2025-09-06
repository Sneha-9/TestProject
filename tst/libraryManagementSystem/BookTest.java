package libraryManagementSystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookTest {
    IdGenerator idGenerator=mock(IdGenerator.class);

    @AfterEach
    void resetMocks(){
        reset(idGenerator);
    }

    @Test
    void shouldCreateBook(){
        when(idGenerator.generateId()).thenReturn("random");

        Assertions.assertDoesNotThrow(()->new Book(idGenerator,"ABC"));
    }

    @Test
    void throwsExceptionWhenBookNameIsNull(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Book(idGenerator,null));
    }

    @Test
    void throwsExceptionWhenBookNameIsEmpty(){
        Assertions.assertThrows(IllegalArgumentException.class,()->new Book(idGenerator,""));
    }
}