package com.sneha.asyncExample.exampleOne;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DBWriter {
    private List<Database> databases = new ArrayList<>();

    void add(Database database) {
        databases.add(database);
    }

    void process(Data data) {

        List<CompletableFuture> futures = new ArrayList<>();

//        databases.stream()
//                .parallel()
//                .forEach(e -> e.add(data));

        for (Database database : databases) {

            //is this io thread or cpu bound, cpu bound means the number of thread will be equal to no of cpu
            CompletableFuture task = CompletableFuture.runAsync(() -> {
                try {
                    database.add(data);
                    System.out.println("DB updated with: " + data);
                } catch (Exception e) {
                    System.out.println("Error in db");
                }
            });

            futures.add(task);
        }

        CompletableFuture.allOf(futures.toArray(futures.toArray(new CompletableFuture[0]))).join();

        System.out.println("DB Write completed");
    }
}
