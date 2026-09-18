package com.sneha.asyncExample.exampleOne;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@AllArgsConstructor
public class ServiceA {
    private Database database;
    private Queue queue;
 //   private final ExecutorService virtualExecutor = Executors.newVirtualThreadPerTaskExecutor();

    String write(Data data){

        try{
            database.add(data);

            System.out.println("Starting async call to push to queue");

            CompletableFuture.runAsync(()-> queue.push(data));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return data.getId();
    }
}
