package com.sneha.asyncExample.exampleTwo;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        ProducerStore producerStore = new ProducerStore();
        ConsumerQueue consumerQueue = new ConsumerQueue();

        DataProducer dataProducer = new DataProducer(producerStore);

        ConsumerRunner consumerRunner = new ConsumerRunner();
        ConsumerDataProcessor consumerDataProcessor = new ConsumerDataProcessor(dataProducer, consumerRunner);
        ConsumerGroup consumerGroup = new ConsumerGroup(consumerQueue ,consumerDataProcessor);

        dataProducer.registerConsumerGroup(consumerGroup);

        Consumer consumerOne = new Consumer();
        Consumer consumerTwo = new Consumer();
        Consumer consumerThree = new Consumer();

        consumerGroup.add(consumerOne);
        consumerGroup.add(consumerTwo);
        consumerGroup.add(consumerThree);

        Runnable one = (()->{
            int l=1;
            while(true){

            Data data = new Data("Sneha"+ l++);
                System.out.println(data.getValue());
                dataProducer.addData(data);
                //  System.out.println("Response received from serviceA"+ id);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread threadProducer = new Thread(one);
        threadProducer.start();

        //consumerGroup.MessageAvailable();


    }
}
