package libraryManagementSystem.database;

import libraryManagementSystem.Book;
import libraryManagementSystem.Entry;
import libraryManagementSystem.TimeUtil;

import java.util.HashMap;
import java.util.Map;

public class EntryDatabase {

    private Map<String, Entry> enteriesDB = new HashMap<>();


    public void addEntry(String cardId, TimeUtil timeUtil, String bookId) throws IllegalArgumentException {
        if (bookId == null || bookId.isEmpty()) {
            throw new IllegalArgumentException("Book id cannot be empty or null");

        }

        if (cardId == null || cardId.isEmpty()) {
            throw new IllegalArgumentException("Card Id cannot be empty or null");
        }

        enteriesDB.put(bookId, new Entry(timeUtil, cardId));
    }

    public void removeEntry(Book book) {
        enteriesDB.remove(book.getId());
    }

    public Entry getEntry(Book book) {
        return enteriesDB.get(book.getId());
    }

}
