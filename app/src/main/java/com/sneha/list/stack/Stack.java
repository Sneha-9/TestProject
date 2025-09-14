package com.sneha.list.stack;

import com.sneha.list.linkedlist.DoublyLinkedList;

public class Stack<T> {
    private final DoublyLinkedList<T> ll;

    public Stack() {
        ll = new DoublyLinkedList<>();
    }

    public void push(T data) {

        ll.addLast(data);
    }

    public T pop() {
        return ll.deleteLast();
    }

    public void print() {
        ll.printList();
    }

    public int size() {
        return ll.getSize();
    }

    public T peek() {
        return ll.getLast();
    }
}
