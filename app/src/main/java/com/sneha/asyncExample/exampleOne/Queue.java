package com.sneha.asyncExample.exampleOne;

public interface Queue {
    boolean push(Data data);

    Data pull() throws InterruptedException;

}
