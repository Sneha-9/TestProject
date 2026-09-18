package com.sneha.asyncExample.exampleOne;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class DataQueue implements com.sneha.asyncExample.exampleOne.Queue {

    private Queue<Data> queue = new ArrayDeque<>();

    @Override
    public boolean push(Data data) {
        return queue.add(data);
    }

    @Override
    public Data pull() {
      return queue.poll();
    }

}
