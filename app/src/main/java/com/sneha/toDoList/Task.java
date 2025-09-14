package com.sneha.toDoList;

public class Task {
    private String title;
    private String status;
    private final long createdAt;
    private final long updatedAt;
    private long dueDate;
    private final String id;

    Task(IdGenerator idGenerator, TimeUtil timeUtil, String title, String status, long dueDate) {
        this.id = idGenerator.generate();
        this.createdAt = timeUtil.getCurrentTime();
        this.updatedAt = timeUtil.getCurrentTime();
        this.status = status;
        this.title = title;
        this.dueDate = dueDate;
    }

    public Task(String id, long dueDate, long updatedAt, long createdAt, String status, String title) {
        this.id = id;
        this.dueDate = dueDate;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.status = status;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public long getDueDate() {
        return dueDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDueDate(long dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", dueDate=" + dueDate +
                ", id='" + id + '\'' +
                '}';
    }
}
