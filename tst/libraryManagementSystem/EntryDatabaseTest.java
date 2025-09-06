package libraryManagementSystem;

import libraryManagementSystem.database.EntryDatabase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.*;

class EntryDatabaseTest {
    IdGenerator idGenerator = mock(IdGenerator.class);
    TimeUtil timeUtil = mock(TimeUtil.class);

@AfterEach
void mockReset(){
    reset(timeUtil);
    reset(idGenerator);
}
    @Test
    void entryIsCreatedInEntryDB(){
        Book book= mock(Book.class);
        Card card = mock(Card.class);
        when(book.getId()).thenReturn("123");
        when(card.getId()).thenReturn("12");

        Assertions.assertDoesNotThrow(()->new EntryDatabase().addEntry(card.getId(),timeUtil,book.getId()));
    }

    @Test
    void getEntryFromEntryDB(){

        Book book= mock(Book.class);

        when(book.getId()).thenReturn("123");
        when(book.getName()).thenReturn("ABC");
        when(timeUtil.getCurrentTime()).thenReturn(20L);
        Entry entry = new Entry(timeUtil,"12");

        EntryDatabase entryDatabase = new EntryDatabase();
        entryDatabase.addEntry("12", timeUtil,book.getId());

        Entry actualEntry = entryDatabase.getEntry(book);

        Assertions.assertEquals(entry,actualEntry);
    }


    @Test
    void removeEntryTest(){
        Book book= mock(Book.class);

        when(book.getId()).thenReturn("123");
        when(book.getName()).thenReturn("ABC");

        when(timeUtil.getCurrentTime()).thenReturn(20L);

        EntryDatabase entryDatabase = new EntryDatabase();
        entryDatabase.addEntry("12", timeUtil,book.getId());

        Assertions.assertNotNull(entryDatabase.getEntry(book));
        entryDatabase.removeEntry(book);
        Assertions.assertNull(entryDatabase.getEntry(book));
    }

    @Test
    void throwsExceptionWhenCardIdIsNull(){
        Book book= mock(Book.class);
        Card card = mock(Card.class);
        when(book.getId()).thenReturn("123");


        Assertions.assertThrows(IllegalArgumentException.class,()->new EntryDatabase().addEntry(card.getId(),timeUtil,book.getId()));
    }
    @Test
    void throwsExceptionWhenBookIdIsNull(){
        Book book= mock(Book.class);
        Card card = mock(Card.class);
        when(card.getId()).thenReturn("12");
        Assertions.assertThrows(IllegalArgumentException.class,()->new EntryDatabase().addEntry(card.getId(),timeUtil,book.getId()));
    }
    @Test
    void throwsExceptionWhenCardIdIsEmpty(){
        Book book= mock(Book.class);
        Card card = mock(Card.class);
        when(book.getId()).thenReturn("123");
        when(card.getId()).thenReturn("");

        Assertions.assertThrows(IllegalArgumentException.class,()->new EntryDatabase().addEntry(card.getId(),timeUtil,book.getId()));
    }
    @Test
    void throwsExceptionWhenBookIdIsEmpty(){
        Book book= mock(Book.class);
        Card card = mock(Card.class);
        when(book.getId()).thenReturn("");
        when(card.getId()).thenReturn("12");

        Assertions.assertThrows(IllegalArgumentException.class,()->new EntryDatabase().addEntry(card.getId(),timeUtil,book.getId()));
    }



}