package com.sneha.asyncExample.exampleOne;


public class ServiceB {
    private  Queue queue;
    private DBWriter dbWriter;

    ServiceB(Queue queue, DBWriter dbWriter){
        this.queue = queue;
        this.dbWriter = dbWriter;

    }

    void fetch() {
        try {
            while(true) {
                System.out.println("fetch data from queue");
                Data data = queue.pull();

                dbWriter.process(data);
                System.out.println("Message Processing completed");
                Thread.sleep(2000);
            }
        } catch (Exception e) {
            System.out.println("Error while pulling data from queue");
            throw new RuntimeException(e);
        }


    }



}
