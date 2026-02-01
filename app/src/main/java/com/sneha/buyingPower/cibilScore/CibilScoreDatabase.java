package com.sneha.buyingPower.cibilScore;

import com.sneha.buyingPower.collateral.CollateralEntry;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CibilScoreDatabase {
    //private final List<CibilScoreEntry> enteries;

//    CibilScoreDatabase(List<CibilScoreEntry> enteries) {
//        this.enteries = enteries;
//    }

//    void addEntry(CibilScoreEntry entry) {
//        enteries.add(entry);
//    }
private final Connection connection;
    CibilScoreDatabase(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/cibilservice";
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


    int getCibilScore(String userId) {
       int result =0;
        try{
            String selectStatement = String.format("Select * from cibilscoreentry where userid = '%s'",userId);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectStatement);

            if(resultSet.next()){
                        result=  resultSet.getInt("score");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
