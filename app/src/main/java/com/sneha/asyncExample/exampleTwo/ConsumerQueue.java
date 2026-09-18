package com.sneha.asyncExample.exampleTwo;


import java.util.LinkedList;
import java.util.Queue;

public class ConsumerQueue {

    Queue<Integer> queue = new LinkedList();

    void push(int index){
        queue.add(index);
    }

    Integer pull(){
        if(queue.isEmpty()){
            return null;
        }
       return queue.poll();
    }

    int size(){
        return queue.size();
    }
}
