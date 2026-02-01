package com.sneha.buyingPower.userIdentification;

import java.sql.*;
import java.util.List;
import java.util.UUID;

public class UserIdentificationDatabase {
   // private final List<User> users;
    private final Connection connection;

    UserIdentificationDatabase(){
        String jdbcURL = "jdbc:postgresql://localhost:5432/useridentificationservice";
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
//    UserIdentificationDatabase(List<User> users) {
//        this.users = users;
//    }

    void addUser(User user) {
        try {
            String insertStatement = String.format(
                    "Insert into users (id, name, createdat, updatedat) values ('%s', '%s','%d','%d')",
                    UUID.randomUUID().toString(),
                    user.getName(),
                    System.currentTimeMillis(),
                    System.currentTimeMillis()
            );

            Statement statement = connection.createStatement();
            statement.execute(insertStatement);
        }
     catch (SQLException e) {
        throw new RuntimeException(e);
    }
      //  users.add(user);
    }

    public boolean validateUser(String userId) {
       // System.out.println(userId);
        try{
            String selectStatement = String.format("Select * from users where id = '%s'",userId);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(selectStatement);
             System.out.println(resultSet);
            if(resultSet.next() ){
             String id = resultSet.getString("id");
             if(id != null ){
                 return true;
             }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

//        for (User u : users) {
//            if (u.getId().equals(userId)) {
//                return true;
//            }
//        }
        return false;
    }
}
