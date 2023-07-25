package org.example.queue;

import org.example.linkedlist.MyLinkedList;

public class MyQueue<T> {

    private final MyLinkedList<T> list;

    private int size;

    public MyQueue() {
        list = new MyLinkedList<>();
        size = 0;
    }

    public boolean offer(T element) {
        return list.add(size++, element);
    }

    public T poll() {
        if (size == 0) {
            return null;
        }

        T element = list.get(size - 1);
        list.remove(--size);
        return element;
    }

    public T peek() {
        if (size == 0) {
            return null;
        }

        return list.get(size - 1);
    }

    public int getSize() {
        return size;
    }
}
