package com.sneha.asyncExample.exampleTwo;

import java.util.concurrent.CompletableFuture;

public class ConsumerRunner implements Runner{


    @Override
    public void run(Consumer consumer, Data data) {
        CompletableFuture.runAsync(()-> {
            try {
                consumer.readData(data);

                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("exception while reading");
            }
        }).whenComplete((result, exception)-> {
            consumer.updateState(State.AVAILABLE);
            System.out.println("consumer finished");
        });
    }
}
