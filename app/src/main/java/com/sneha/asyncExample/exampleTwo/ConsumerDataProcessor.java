package com.sneha.asyncExample.exampleTwo;

import lombok.AllArgsConstructor;

import java.util.List;


public class ConsumerDataProcessor {

    private DataProducer dataProducer;
    private ConsumerRunner consumerRunner;

    ConsumerDataProcessor(DataProducer dataProducer,ConsumerRunner consumerRunner){
        this.consumerRunner =consumerRunner;
        this.dataProducer = dataProducer;
    }


    void process(ConsumerQueue consumerQueue, List<Consumer> availableConsumers) throws InterruptedException {
        while(consumerQueue.size() ==0){
            System.out.println("waiting for message ");
            Thread.sleep(1000);
        }
        System.out.println("Available consumer "+availableConsumers.size());

        for(Consumer consumer:availableConsumers ){
            if (consumerQueue.size() == 0) {
                break;
            }
                    consumer.updateState(State.UNAVAILBLE);

                    int dataIdx = consumerQueue.pull();
                    Data data=    dataProducer.getData(dataIdx);
                    System.out.println("Assigned consumer " + consumer.getId());
                    consumerRunner.run(consumer, data);


        }

    }
}
