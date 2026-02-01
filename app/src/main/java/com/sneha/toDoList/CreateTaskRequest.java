package com.sneha.toDoList;

import org.springframework.lang.Nullable;

public class CreateTaskRequest {
    private String title;
    @Nullable
    private long dueDate;

    public CreateTaskRequest() {
    }

    private CreateTaskRequest(String title, long dueDate) {
        this.title = title;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public long getDueDate() {
        return dueDate;
    }

    public static class Builder {
        private String title;
        private long dueDate;

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDueDate(long dueDate) {
            this.dueDate = dueDate;
            return this;
        }

        public CreateTaskRequest build() {
            return new CreateTaskRequest(this.title, this.dueDate);
        }
    }


}
