package libraryManagementSystem;

public class EntryNotFoundException extends Exception {
    public EntryNotFoundException() {
        super("Entry not found");
    }
}
