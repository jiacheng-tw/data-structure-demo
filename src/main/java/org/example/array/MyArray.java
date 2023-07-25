package org.example.array;

public class MyArray<T> {

    private T[] data;

    private int size;

    public MyArray(int capacity) {
        data = (T[]) new Object[Math.max(capacity, 0)];
        size = 0;
    }

    public boolean add(T element) {
        return add(size, element);
    }

    public boolean add(int index, T element) {
        if (index < 0 || index >= data.length || index > size || size == data.length || element == null) {
            return false;
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = element;
        size++;

        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= data.length || index >= size || size == 0) {
            return false;
        }

        for (int i = index + 1; i < data.length; i++) {
            data[i - 1] = data[i];
        }
        size--;

        return true;
    }

    public boolean set(int index, T element) {
        if (index < 0 || index >= data.length || index >= size || element == null) {
            return false;
        }

        data[index] = element;
        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= data.length || index >= size) {
            return null;
        }
        return data[index];
    }

    public int getSize() {
        return size;
    }
}

