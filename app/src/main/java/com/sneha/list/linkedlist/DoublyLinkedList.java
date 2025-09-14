package com.sneha.list.linkedlist;

import com.sneha.list.List;
import com.sneha.util.Iterator;

public class DoublyLinkedList<T> implements List<T> {
    private Node<T> start;
    private Node<T> last;
    private int count;

    public void addFirst(T data) {
        Node<T> n = new Node<>(data);
        count += 1;

        if (start == null) {
            start = n;
            last = n;
            return;
        }

        n.setNext(start);
        start.setPrev(n);
        start = n;
    }

    public void addLast(T data) {
        Node<T> n = new Node<>(data);
        count += 1;

        if (start == null) {
            start = n;
            last = n;
            return;
        }

        // Node temp =start;
        last.setNext(n);
        n.setPrev(last);
        last = n;

//
//        while(temp.getNext() != null){
//            temp = temp.getNext();
//        }
//
//        temp.setNext(n);
//        n.setPrev(temp);
    }

    public T deleteValue(T data) {
        if (start == null || last == null) {
            throw new RuntimeException("List is empty");
        }

        if (start.getData().equals(data)) {
            return deleteFirst();
        } else if (last.getData().equals(data)) {
            return deleteLast();
        } else {
            Node<T> prev = null;
            Node<T> curr = start;
            Node<T> temp = curr;
            while (curr != null) {
                if (curr.getData().equals(data)) {
                    temp = curr.getNext();
                    prev.setNext(curr.getNext());
                    curr.setNext(null);
                    temp.setPrev(prev);
                    curr.setPrev(null);
                    count -= 1;
                }
                prev = curr;
                curr = curr.getNext();

            }
            return temp.getData();
        }
    }

    public T deleteFirst() {
        if (start == null) {
            throw new RuntimeException("List is empty");
        }

        count -= 1;

        Node<T> temp = start;

        if (start == last) {
            start = null;
            last = null;
            return temp.getData();
        }


        start = start.getNext();
        start.setPrev(null);
        temp.setNext(null);

        return temp.getData();
    }

    @Override
    public int getSize() {
        return count;
    }

    public T deleteLast() {
        if (last == null) {
            throw new RuntimeException("List is empty");
        }

        count -= 1;

//        Node temp = start;
//
//        while(temp.getNext() != null && temp.getNext().getNext() != null){
//            temp = temp.getNext();
//        }

        Node<T> temp = last;

        if (last == start) {
            start = null;
            last = null;
            return temp.getData();
        }

//        temp.getNext().setPrev(null);
//        temp.setNext(null);


        last = temp.getPrev();
        last.setNext(null);
        temp.setPrev(null);

        return temp.getData();
    }

    private void printListUtil(Node<T> n) {
        if (n == null) {
            return;
        }
        System.out.printf("%d, ", n.getData());
        printListUtil(n.getNext());
    }

    public void printList() {
        printListUtil(start);
        System.out.println();
    }

    public T getFirst() {
        if (start == null) {
            return null;
        } else return start.getData();
    }

    public T getLast() {
        if (last == null) {
            return null;
        }

        return last.getData();
    }


    public static class DoublyLinkedListIterator<T> implements Iterator<T> {

        private Node<T> curr;

        public DoublyLinkedListIterator(DoublyLinkedList<T> linkedList) {
            this.curr = linkedList.start;
        }

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public T getNext() {
            T data = curr.getData();
            curr = curr.getNext();
            return data;
        }
    }


}
