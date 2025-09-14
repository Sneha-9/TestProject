package com.sneha.toDoList;

public class GetTasksRequest {
    private final String status;

    public GetTasksRequest(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
