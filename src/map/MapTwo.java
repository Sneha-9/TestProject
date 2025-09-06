package map;

public interface MapTwo<K,V> {
         boolean put(K key,V value);
         boolean remove(K key);
         V get(K key);
         int size();
         boolean contains(K key);
}
