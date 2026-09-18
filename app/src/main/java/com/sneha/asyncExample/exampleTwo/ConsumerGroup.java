package com.sneha.asyncExample.exampleTwo;

import com.sneha.farmingSystem.CostCalculator;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class ConsumerGroup {
    private List<Consumer> consumers = new ArrayList<>();
    private ConsumerQueue consumerQueue;

   private ConsumerDataProcessor consumerDataProcessor;
   int idx;
    ConsumerGroup(ConsumerQueue consumerQueue, ConsumerDataProcessor consumerDataProcessor){
        this.consumerDataProcessor = consumerDataProcessor;
        this.consumerQueue = consumerQueue;
        idx =0;

    }
    void add(Consumer consumer){
        consumers.add(consumer);
    }

    public void MessageAvailable() throws InterruptedException {

        System.out.println("Message arrived at Queue " + idx);
        consumerQueue.push(idx);
        idx++;
        consume();
    }

    private void consume() throws InterruptedException {

        List<Consumer> availableConsumer = getAvailableConsumer();

        consumerDataProcessor.process(consumerQueue,availableConsumer);
    }


    private    List<Consumer> getAvailableConsumer(){
        List<Consumer> availableConsumers =  consumers.stream()
                .filter(consumer -> consumer.getState() == State.AVAILABLE).toList();
        return availableConsumers;
    }


}
