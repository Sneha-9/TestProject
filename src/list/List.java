package list;

public interface List<T> {

    void addLast(T data);

    void addFirst(T data);

    T deleteLast();

    T deleteFirst();

    int getSize();

}
