package com.sneha.list.queue;

import com.sneha.list.linkedlist.DoublyLinkedList;

public class Queue<T> {
    private final DoublyLinkedList<T> dl;

    public Queue() {
        dl = new DoublyLinkedList<>();
    }

    public void enqueue(T data) {
        dl.addLast(data);
    }

    public T dequeue() {
        return dl.deleteFirst();
    }

    public int size() {
        return dl.getSize();
    }

    public void print() {
        dl.printList();
    }
}
