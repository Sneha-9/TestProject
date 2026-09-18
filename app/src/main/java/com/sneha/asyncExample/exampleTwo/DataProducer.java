package com.sneha.asyncExample.exampleTwo;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class DataProducer {
    List<ConsumerGroup> consumerGroups = new ArrayList<>();
    ProducerStore producerStore ;


    DataProducer(ProducerStore producerStore){
        this.producerStore = producerStore;
    }
    void registerConsumerGroup(ConsumerGroup consumerGroup){
        consumerGroups.add(consumerGroup);
    }

    void addData(Data data) {
        producerStore.add(data);

        //consumerGroups.stream().parallel().
        for (ConsumerGroup consumerGroup : consumerGroups) {
            CompletableFuture.runAsync(() ->
            {
                try {
                    consumerGroup.MessageAvailable();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
            System.out.println("Producer process ended");
        }
    }

    Data getData(int dataIndex){
      return   producerStore.get(dataIndex);
    }

    


}
