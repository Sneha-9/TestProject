package com.sneha.toDoList;

public class UpdateTaskRequest {
    private final String title;
    private final String status;
    private final long dueDate;
    private final String id;

    private UpdateTaskRequest(String id, String title, String status, long dueDate) {
        this.dueDate = dueDate;
        this.status = status;
        this.title = title;
        this.id = id;
    }

    public String getId() {
        return id;
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

    public static class Builder {
        private final String id;
        private String title;
        private String status;
        private long dueDate;

        Builder(String id) {
            this.id = id;
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder withDueDate(long dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public UpdateTaskRequest build() {
            return new UpdateTaskRequest(this.id, this.title, this.status, this.dueDate);
        }
    }
}
