package org.example.stack;

import org.example.array.MyArray;

public class MyStack<T> {

    private MyArray<T> data;

    private int size;

    public MyStack(int capacity) {
        data = new MyArray<>(capacity);
        size = 0;
    }

    public boolean push(T element) {
        if (size >= data.getSize()) {
            return false;
        }

        data.add(element);
        size++;
        return true;
    }

    public T pop() {
        if (size == 0) {
            return null;
        }

        T popElement = data.get(size - 1);
        data.remove(--size);
        return popElement;
    }

    public T peek() {
        if (size==0) {
            return null;
        }

        return data.get(size - 1);
    }

    public int getSize() {
        return size;
    }
}
