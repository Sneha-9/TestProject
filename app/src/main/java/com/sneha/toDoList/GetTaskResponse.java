package com.sneha.toDoList;

public class GetTaskResponse {
    private final String title;
    private final String status;
    private final long dueDate;
    private final String id;

    GetTaskResponse(String status, String id, long dueDate, String title) {
        this.dueDate = dueDate;
        this.title = title;
        this.status = status;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }

    public long getDueDate() {
        return dueDate;
    }

    public String getId() {
        return id;
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
