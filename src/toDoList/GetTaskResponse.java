package toDoList;

public class GetTaskResponse {
    private String title;
    private String status;
    private long dueDate;
    private String id;

    GetTaskResponse(String status,String id,long dueDate,String title){
        this.dueDate=dueDate;
        this.title=title;
        this.status=status;
        this.id=id;
    }

    @Override
    public String toString() {
        return "GetTaskResponse{" +
                "title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", dueDate=" + dueDate +
                ", id='" + id + '\'' +
                '}';
    }


}
