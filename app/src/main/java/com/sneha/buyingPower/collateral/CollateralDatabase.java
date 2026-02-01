package com.sneha.buyingPower.collateral;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CollateralDatabase {
 //   private final List<CollateralEntry> enteries;

//    CollateralDatabase(List<CollateralEntry> enteries) {
//        this.enteries = enteries;
//    }
    private final Connection connection;
    CollateralDatabase(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/collateralservice";
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

//    void add(CollateralEntry collateralEntry) {
//        enteries.add(collateralEntry);
//    }

    List<CollateralEntry> getEnteries(String userId) {
        List<CollateralEntry> result = new ArrayList<>();
        try{
            String selectStatement = String.format("Select * from collateralentry where userid = '%s'",userId);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectStatement);

            while(resultSet.next()){
                result.add(
                        new CollateralEntry(
                                resultSet.getString("id"),
                                resultSet.getString("userid"),
                                resultSet.getString("type"),
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
