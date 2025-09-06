package com.sneha.list.queue;

import com.sneha.list.linkedlist.DoublyLinkedList;

public class Deque<T> {
    private DoublyLinkedList<T> dl ;
    public Deque(){
        dl = new DoublyLinkedList<>();
    }

    public void enqueueFirst(T data){
        dl.addFirst(data);
    }
    public void enqueueLast(T data){
         dl.addLast(data);
    }
    public T dequeueFirst(){
        return dl.deleteFirst();
    }
    public T dequeueLast(){
        return dl.deleteLast();

    }
    public void print(){
        dl.printList();
    }
}
