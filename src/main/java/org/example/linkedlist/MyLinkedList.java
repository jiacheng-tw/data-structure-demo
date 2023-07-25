package org.example.linkedlist;

public class MyLinkedList<T> {

    private MyNode<T> head;

    private int size;

    public MyLinkedList() {
        head = new MyNode<T>(null, null);
        size = 0;
    }

    public boolean add(int index, T element) {
        if (index < 0 || index > size) {
            return false;
        }

        MyNode<T> prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new MyNode<T>(element, prev.next);

        size++;
        return true;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        MyNode<T> prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        MyNode<T> retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;

        size--;
        return true;
    }

    public boolean set(int index, T element) {
        if (index < 0 || index >= size) {
            return false;
        }

        MyNode<T> cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = element;

        return true;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        MyNode<T> cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.data;
    }

    public int getSize() {
        return size;
    }
}
