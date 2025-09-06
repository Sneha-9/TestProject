package com.sneha.list.stack;

import list.queue.Queue;

public class StackTwo<T> {
    private Queue<T> q1;
    private Queue<T> q2;

    public StackTwo(){
        q1 = new Queue<>();
        q2 = new Queue<>();
    }

    public void push(T data){
        q1.enqueue(data);
    }

    public T pop(){
        while(q1.size() > 1){
            q2.enqueue(q1.dequeue());
        }
        T val = q1.dequeue();

       q1=q2;
       q2 = new Queue<>();
       return val;

    }
    public void print(){
        q1.print();
    }
}
