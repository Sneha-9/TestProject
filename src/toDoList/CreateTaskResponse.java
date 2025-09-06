package toDoList;

public class CreateTaskResponse {
    private String id;
    CreateTaskResponse(String id){
        this.id=id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "CreateTaskResponse{" +
                "id='" + id + '\'' +
                '}';
    }
}
