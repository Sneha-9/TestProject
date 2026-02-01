package com.sneha.jobScheduler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MachineDatabase {
    // List<Machine> machines;
    private final Connection connection;

    MachineDatabase() {
        String jdbcURL = "jdbc:postgresql://localhost:5432/machinedatabse";
        String username = "sneha";
        String password = "password";

        // Establish the connection
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    List<MachineRegistry> getData(int memory) {

        //gives back list of machines based on memory
        List<MachineRegistry> result = new ArrayList<>();
        try {
            String selectStatement = String.format("Select * from machinerecord where memory = '%d'", memory);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectStatement);

            while (resultSet.next()) {
                result.add(
                        new MachineRegistry(
                                resultSet.getString("id"),
                                resultSet.getInt("memory"),
                                resultSet.getString("status"),
                                resultSet.getString("url")
                        )
                );
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;

    }

    void updateStatus(String machineId, String status) {
        // update status of machine when it gets booked or unserviceable or available;

        StringBuilder updateStatementBuilder = new StringBuilder("Update machinerecord set ");
        updateStatementBuilder.append(String.format(" status = '%s' ", status));
        updateStatementBuilder.append(String.format(" where id = '%s' ", machineId));

        try {
            Statement statement = connection.createStatement();
            statement.execute(updateStatementBuilder.toString());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
