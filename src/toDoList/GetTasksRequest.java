package toDoList;

public class GetTasksRequest {
    private String status;

    GetTasksRequest(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
