package map;

import list.linkedlist.DoublyLinkedList;
import util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HashMap<K,V> implements Map<K,V>{

    private final int LIMIT = 1000;
    private final List<DoublyLinkedList<Pair<K,V>>> data = Arrays.asList(new DoublyLinkedList[LIMIT]);

    private int count = 0;

    @Override
    public boolean put(K key, V value) {
        Pair<K,V> p =find(key);
        if(p != null){
            p.setSecond(value);
            return true;
        }
        DoublyLinkedList<Pair<K, V>> list = getList(key);

        list.addLast(new Pair<>(key, value));
        count++;

        return true;
    }

    @Override
    public V get(K key) {
        Pair<K, V> p = find(key);
        if (p == null) {
            return null;
        }

        return p.getSecond();
    }

    @Override
    public boolean remove(K key) {
        Pair<K,V> p = find(key);
        if(p != null) {
            DoublyLinkedList<Pair<K, V>> doublyLinkedList = getList(key);
            doublyLinkedList.deleteValue(p);
            count--;
            return true;
        }
        return false;

    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(K key) {
        Pair<K, V> p = find(key);
        return p != null;
    }

    private Pair<K, V> find(K key) {
        DoublyLinkedList<Pair<K, V>> list = getList(key);

        DoublyLinkedList.DoublyLinkedListIterator<Pair<K, V>> iterator = new DoublyLinkedList.DoublyLinkedListIterator<>(list);

        while (iterator.hasNext()) {
            Pair<K, V> pair = iterator.getNext();
            if (pair.getFirst().equals(key)) {
                return pair;
            }
        }

        return null;
    }

    private DoublyLinkedList<Pair<K, V>> getList(K key) {
        int hash = key.hashCode();

        int index = hash % LIMIT;

        DoublyLinkedList<Pair<K, V>> doublyLinkedList =  data.get(index);

        if (doublyLinkedList == null) {
            doublyLinkedList = new DoublyLinkedList<>();
            data.set(index, doublyLinkedList);
        }

        return doublyLinkedList;
    }

}
