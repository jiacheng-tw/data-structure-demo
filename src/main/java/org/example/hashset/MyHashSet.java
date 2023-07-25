package org.example.hashset;

import org.example.hashmap.MyHashMap;

public class MyHashSet<T> {

    private MyHashMap<T, Object> map;

    public MyHashSet() {
        map = new MyHashMap<>();
    }

    public boolean add(T element) {
        return map.put(element, new Object());
    }

    public boolean remove(T element) {
        return map.remove(element);
    }
}
