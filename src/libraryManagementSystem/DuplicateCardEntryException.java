package libraryManagementSystem;

public class DuplicateCardEntryException extends Exception{
    DuplicateCardEntryException(){
        super("Card already exists in database");
    }
}
