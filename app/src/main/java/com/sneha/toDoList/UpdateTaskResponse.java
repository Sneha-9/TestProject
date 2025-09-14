package com.sneha.toDoList;

public class UpdateTaskResponse {
    private final String title;
    private final String status;
    private final long dueDate;

    UpdateTaskResponse(String title, String status, long dueDate) {
        this.dueDate = dueDate;
        this.status = status;
        this.title = title;
    }

    public long getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
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

