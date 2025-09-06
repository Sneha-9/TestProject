package list.linkedlist;

public class LinkedList<T>{
    private Node<T> start;

    public void printlist(){
        Node<T> temp =start;
        while(temp != null){
            System.out.println(temp.getData());
            temp=temp.getNext();

        }
    }

    public void addFirst(T data){
        Node<T> n = new Node<>(data);
        if(start == null){
            start = n;
            return;
        }
        n.setNext(start);
        start = n;
    }

    public void addLast(T data){
        Node<T> n =  new Node(data);
        if(start == null){
            start = n;
            return;
        }
        Node<T> temp =start;
        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(n);
    }

    public T deleteLast(){
        if(start == null){
            System.out.println("List is empty");
            return null;
        }
        Node<T> temp =start;
        while(temp.getNext().getNext() != null){
            temp =temp.getNext();
        }
        T data = temp.getData();
        temp.setNext(null);
        return data;

    }

    public T deleteFirst(){
        if(start == null){
            System.out.println("List is empty");
            return null;
        }
        T data = start.getData();
        start = start.getNext();
        return data;
    }
}
