package org.example.hashmap;

public class MyEntry<K, V> {

    K key;

    V value;

    int hash;

    MyEntry<K, V> next;

    public MyEntry(K key, V value, int hash, MyEntry<K, V> next) {
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = next;
    }
}
