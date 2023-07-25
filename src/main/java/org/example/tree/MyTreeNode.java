package org.example.tree;

public class MyTreeNode<T> {

    T data;

    MyTreeNode<T> left;

    MyTreeNode<T> right;

    public MyTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public MyTreeNode(T data, MyTreeNode<T> left, MyTreeNode<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
