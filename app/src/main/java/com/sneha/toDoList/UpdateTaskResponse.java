package com.sneha.toDoList;

public class UpdateTaskResponse {
    private String title;
    private String status;
    private long dueDate;
    UpdateTaskResponse(String title,String status,long dueDate){
        this.dueDate=dueDate;
        this.status =status;
        this.title=title;
    }

    @Override
    public String toString() {
        return "UpdateTaskResponse{" +
                "title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}

