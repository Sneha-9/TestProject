package com.sneha.buyingPower.loan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanDatabase {
   // private final List<LoanEntry> entries;
    private final Connection connection;

    LoanDatabase(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/loanservice";
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
//    LoanDatabase(List<LoanEntry> entries) {
//        this.entries = entries;
//    }

    void add(LoanEntry loanEntry) {
       // entries.add(loanEntry);
    }

    public List<LoanEntry> getEntries(String userId) {
        List<LoanEntry> result = new ArrayList<>();
        try{
            String selectStatement = String.format("Select * from loanentry where userid = '%s'",userId);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectStatement);

           while(resultSet.next()){
                result.add(
                    new LoanEntry(
                            resultSet.getString("id"),
                            resultSet.getString("userid"),
                            resultSet.getInt("amount")
                    )
                );


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
//        List<LoanEntry> result = new ArrayList<>();
//        for (LoanEntry e : entries) {
//            if (e.getUserId().equals(userId)) {
//                result.add(e);
//            }
//        }
        return result;
    }
}
