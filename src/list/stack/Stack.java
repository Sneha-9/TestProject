package list.stack;

import list.linkedlist.DoublyLinkedList;
import list.linkedlist.LinkedList;

public class Stack<T> {
    private DoublyLinkedList<T> ll ;

   public Stack(){
        ll = new DoublyLinkedList<>();
    }

   public void push(T data){

        ll.addLast(data);
    }

   public T pop(){
        return ll.deleteLast();
   }

    public void print(){
       ll.printList();
    }

    public int size(){
       return ll.getSize();
    }

    public T peek(){
       return ll.getLast();
    }
}
