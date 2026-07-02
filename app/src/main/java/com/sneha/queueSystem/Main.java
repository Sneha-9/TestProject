package com.sneha.queueSystem;

import com.sneha.queueSystem.consumer.ConsumerMessageProcessingSystem;
import com.sneha.queueSystem.dataModel.Message;
import com.sneha.queueSystem.producer.ProducerMessageProcessingSystem;
import com.sneha.queueSystem.queueGenerationSystem.MessageQueueGenerationSystem;
import com.sneha.queueSystem.queueSystem.MessageQueueSystem;
import com.sneha.queueSystem.store.MessageQueueStore;

public class Main {
    public static void main(String[] args) {
        MessageQueueGenerationSystem queueGenerationSystem = new MessageQueueGenerationSystem();
        MessageQueueStore messageQueueStore = new MessageQueueStore();

        MessageQueueSystem messageQueueSystem = new MessageQueueSystem(queueGenerationSystem, messageQueueStore);

        String q1 = messageQueueSystem.generate();

        ProducerMessageProcessingSystem producerMessageProcessingSystem = new ProducerMessageProcessingSystem(messageQueueSystem);

        Runnable one = () -> {
            int k = 1;

            while(true) {
                Message message = new Message("Sneha" + k++);
                System.out.println(message.getValue());

                producerMessageProcessingSystem.send(q1, message);

                try {
//                    System.out.println("Producer sleeping ...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };


        ConsumerMessageProcessingSystem consumerMessageProcessingSystem = new ConsumerMessageProcessingSystem(messageQueueSystem);


        Runnable two = () -> {
            while (true) {
                consumerMessageProcessingSystem.receiveMessage(q1);

                try {
//                    System.out.println("Producer sleeping ...");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        };

        Thread threadProducer = new Thread(one);
        threadProducer.start();

        Thread threadConsumer = new Thread(two);
        threadConsumer.start();

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
