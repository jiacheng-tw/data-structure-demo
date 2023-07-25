package org.example.hashmap;

import org.example.array.MyArray;

public class MyHashMap<K, V> {

    private MyArray<MyEntry<K, V>> table;

    private int capacity;

    private int size;

    public MyHashMap() {
        capacity = 256;
        size = 0;
        table = new MyArray<>(capacity);
    }

    public boolean put(K key, V value) {
        if (key == null) {
            return false;
        }

        int hash = key.hashCode();
        int index = hash % capacity;

        MyEntry<K, V> entry = table.get(index);
        while (entry != null) {
            if (entry.hash == hash && (key == entry.key || key.equals(entry.key))) {
                entry.value = value;
                size++;
                return true;
            }
            entry = entry.next;
        }

        MyEntry<K, V> next = table.get(index);
        table.set(index, new MyEntry<>(key, value, hash, next));
        return true;
    }

    public boolean remove(K key) {
        if (key == null) {
            return false;
        }

        int hash = key.hashCode();
        int index = hash % capacity;

        MyEntry<K, V> entry = table.get(index);
        MyEntry<K, V> preEntry = null;
        while (entry != null) {
            if (hash == entry.hash && (key == entry.key || key.equals(entry.key))) {
                if (preEntry == null) {
                    table.set(index, entry.next);
                }else {
                    preEntry.next = entry.next;
                }
                entry.next = null;
                size--;
                return true;
            }
            preEntry = entry;
            entry = entry.next;
        }

        return false;
    }

    public V get(K key) {
        if (key == null) {
            return null;
        }

        int hash = key.hashCode();
        int index = hash % capacity;

        MyEntry<K, V> entry = table.get(index);
        while (entry != null) {
            if (hash == entry.hash && (key == entry.key || key.equals(entry.key))) {
                return entry.value;
            }
            entry = entry.next;
        }

        return null;
    }

    public int getSize() {
        return size;
    }
}
