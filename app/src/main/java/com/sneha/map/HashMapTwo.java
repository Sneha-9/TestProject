package com.sneha.map;

import com.sneha.list.linkedlist.DoublyLinkedList;
import com.sneha.util.Pair;

import java.util.Arrays;
import java.util.List;

public class HashMapTwo<K, V> implements MapTwo<K, V> {
    private final int limit = 1000;
    private final List<DoublyLinkedList<Pair<K, V>>> dl = Arrays.asList(new DoublyLinkedList[limit]);
    private int count = 0;


    @Override
    public boolean put(K key, V value) {
        Pair<K, V> p = findKey(key);
        if (p != null) {
            p.setSecond(value);
            return true;
        }
        DoublyLinkedList<Pair<K, V>> dl = getList(key);
        dl.addLast(new Pair<>(key, value));
        count++;

        return true;
    }

    @Override
    public boolean remove(K key) {
        Pair<K, V> p = findKey(key);
        if (p == null) {
            return false;
        }
        DoublyLinkedList<Pair<K, V>> list = getList(key);
        list.deleteValue(p);
        count--;
        return true;

    }

    @Override
    public V get(K key) {
        Pair<K, V> p = findKey(key);
        if (p != null) {
            return p.getSecond();

        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(K key) {
        Pair<K, V> p = findKey(key);
        return p != null;
    }

    public DoublyLinkedList<Pair<K, V>> getList(K key) {
        int keyHash = key.hashCode();

        int index = keyHash % limit;
        DoublyLinkedList<Pair<K, V>> list = dl.get(index);
        if (list == null) {
            list = new DoublyLinkedList<>();
            dl.set(index, list);

        }
        return list;


    }

    public Pair<K, V> findKey(K key) {
        DoublyLinkedList<Pair<K, V>> list = getList(key);

        DoublyLinkedList.DoublyLinkedListIterator<Pair<K, V>> itr = new DoublyLinkedList.DoublyLinkedListIterator<>(list);

        while (itr.hasNext()) {
            Pair<K, V> p = itr.getNext();
            if (p.getFirst().equals(key)) {
                return p;
            }

        }

        return null;


    }
}
