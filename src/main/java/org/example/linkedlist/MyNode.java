package org.example.linkedlist;

public class MyNode<T> {
    T data;
    MyNode<T> next;

    public MyNode() {
        this(null, null);
    }

    public MyNode(T data) {
        this(data, null);
    }

    public MyNode(T data, MyNode<T> next) {
        this.data = data;
        this.next = next;
    }
}
