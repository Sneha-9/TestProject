package libraryManagementSystem;


public class Book {
    private String name;
    private String id;

    Book(IdGenerator idGenerator, String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        this.id = idGenerator.generateId();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
