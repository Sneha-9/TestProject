package com.sneha.asyncExample.exampleTwo;


import lombok.Getter;

import java.util.UUID;

@Getter
public class Consumer {
    private State state;
    private String id;


    Consumer(){
        this.state = State.AVAILABLE;
        this.id = UUID.randomUUID().toString();
    }

    void updateState(State state){
        this.state= state;
    }

    void readData(Data data) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Data read");
    }

}
