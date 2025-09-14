package com.sneha.toDoList;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDatabase {
    List<Task> tasks;

    private Connection connection;

    public TaskDatabase() {
        String jdbcURL = "jdbc:postgresql://localhost:5432/todolist";
        String username = "sneha";
        String password = "password";

        // Establish the connection
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        tasks = new ArrayList<>();
    }

    void addTask(Task task) {
        try {
            String insertStatement = String.format(
                    "Insert into task (id, title, status, createdat, updatedat,duedate) values ('%s', '%s','%s','%d','%d','%d')",
                    task.getId(),
                    task.getTitle(),
                    task.getStatus(),
                    task.getCreatedAt(),
                    task.getUpdatedAt(),
                    task.getDueDate()
            );

            Statement statement = connection.createStatement();
            statement.execute(insertStatement);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    void remove(Task task) {
        String id = task.getId();
       String deleteStatement = String.format("Delete from task where id = '%s'", id);
        try {
            Statement statement = connection.createStatement();
            statement.execute(deleteStatement);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    Task getTaskById(String id) {


        try {
            String selectStatement = String.format("Select * from task where id = '%s'", id);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectStatement);

            if (resultSet.next()) {
                return new Task(
                        resultSet.getString("id"),
                        resultSet.getLong("duedate"),
                        resultSet.getLong("updatedat"),
                        resultSet.getLong("createdat"),
                        resultSet.getString("status"),
                        resultSet.getString("title")

                );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    Task update(String id, String title, long dueDate, String status){
        StringBuilder updateStatementBuilder = new StringBuilder("Update task set ");

        boolean last = false;

        if (title != null && !title.isEmpty()) {
            updateStatementBuilder.append(String.format(" title = '%s' ", title));
            last = true;
        }

        if (status != null && !status.isEmpty()) {
            if (last) updateStatementBuilder.append(" , ");
            updateStatementBuilder.append(String.format(" status = '%s' ", status));
            last = true;
        }

        if (dueDate != 0L ) {
            if (last) updateStatementBuilder.append(" , ");
            updateStatementBuilder.append(String.format(" duedate = '%d' ", dueDate));
        }

        updateStatementBuilder.append(String.format(" where id = '%s'", id));

        System.out.println(updateStatementBuilder.toString());

        try {
            Statement statement = connection.createStatement();
            statement.execute(updateStatementBuilder.toString());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return getTaskById(id);
    }

    List<Task> getTaskByStatus(String status) {
        List<Task> res = new ArrayList<>();
        try {
            String selectStatement = String.format("Select * from task where status = '%s'", status);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectStatement);

            while (resultSet.next()) {

                res.add(
                        new Task(
                                resultSet.getString("id"),
                                resultSet.getLong("duedate"),
                                resultSet.getLong("updatedat"),
                                resultSet.getLong("createdat"),
                                resultSet.getString("status"),
                                resultSet.getString("title")

                        )
                );

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return res;
    }

    List<Task> getAllTask() {
        return tasks;
    }
}
