package com.sneha.buyingPower.income;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncomeDatabase {
    //private final List<IncomeEntry> enteries;
    private final Connection connection;
    IncomeDatabase(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/incomeservice";
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
//    IncomeDatabase(List<IncomeEntry> enteries) {
//        this.enteries = enteries;
//    }

//    void add(IncomeEntry incomeEntry) {
//        enteries.add(incomeEntry);
//    }

    List<IncomeEntry> getEnteries(String userId) {
        List<IncomeEntry> result = new ArrayList<>();
        try{
            String selectStatement = String.format("Select * from incomeentry where userid = '%s'",userId);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectStatement);

            while(resultSet.next()){
                result.add(
                        new IncomeEntry(
                                resultSet.getString("id"),
                                resultSet.getString("userid"),
                                resultSet.getInt("amount")
                        )
                );


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
