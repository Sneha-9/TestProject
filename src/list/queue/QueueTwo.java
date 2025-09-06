package list.queue;

import list.stack.Stack;

public class QueueTwo<T> {
    private Stack<T> s1;
    private Stack<T> s2;

    public QueueTwo(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void enqueue(T data){
        s1.push(data);
    }
    public void print()
    {
        s1.print();

    }
    public T dequeue(){
        //System.out.println(s1.size());
        if(s2.size() == 0) {
            while (s1.size() != 0) {
                s2.push(s1.pop());
            }
        }
            T val = s2.pop();
        return val;
    }
}
