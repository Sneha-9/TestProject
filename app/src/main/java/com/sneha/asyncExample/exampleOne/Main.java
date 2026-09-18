package com.sneha.asyncExample.exampleOne;

public class Main {

    public static void main(String[] args) {
        Queue queue = new DataQueue();

        Database database = new LocalDatabase();

        ServiceA serviceA = new ServiceA(database,queue);

        Runnable one = (()->{
           int l=1;
           while(true){
               Data data= new Data("Sneha"+ l++);
               System.out.println(data.getValue());
               String id  =serviceA.write(data);
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




        DBWriter dbWriter = new DBWriter();

        Database db1 = new LocalDBOne();
        Database db2 = new LocalDBTwo();

        dbWriter.add(db1);
        dbWriter.add(db2);

        ServiceB serviceB = new ServiceB(queue, dbWriter);

        serviceB.fetch();
        System.out.println("Process end");

    }
}
