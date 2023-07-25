package org.example.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class MyTree<T extends Comparable<T>> {

    private MyTreeNode<T> root;

    private int size;

    public MyTree() {
        root = null;
        size = 0;
    }

    public void add(T element) {
        if (root == null) {
            root = new MyTreeNode<>(element);
            return;
        }

        MyTreeNode<T> current = root;
        while (current != null) {
            if (element.compareTo(current.data) == 0) {
                return;
            } else if (element.compareTo(current.data) < 0) {
                if (current.left == null) {
                    current.left = new MyTreeNode<>(element);
                    size++;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new MyTreeNode<>(element);
                    size++;
                    return;
                }
                current = current.right;
            }
        }
    }

    public T minValue() {
        if (root == null) {
            return null;
        }

        MyTreeNode<T> min = root;
        while(min.left != null)
            min = min.left;

        return min.data;
    }

    public T maxValue() {
        if (root == null) {
            return null;
        }

        MyTreeNode<T> max = root;
        while(max.right != null)
            max = max.right;

        return max.data;
    }

    public List<T> preOrder() {
        if (root == null)
            return Collections.emptyList();

        ArrayList<T> preOrderList = new ArrayList<>();
        Stack<MyTreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            MyTreeNode<T> current = stack.pop();
            preOrderList.add(current.data);

            if (current.right != null)
                stack.push(current.right);
            if (current.left != null)
                stack.push(current.left);
        }
        return preOrderList;
    }

    public List<T> inOrder() {
        if (root == null)
            return Collections.emptyList();

        ArrayList<T> inOrderList = new ArrayList<>();
        Stack<MyTreeNode<T>> stack = new Stack<>();
        MyTreeNode<T> current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            MyTreeNode<T> node = stack.pop();
            inOrderList.add(node.data);
            current = node.right;
        }
        return inOrderList;
    }

    public List<T> postOrder() {
        if (root == null)
            return Collections.emptyList();

        LinkedList<T> preOrderList = new LinkedList<>();
        Stack<MyTreeNode<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            MyTreeNode<T> current = stack.pop();
            preOrderList.addFirst(current.data);

            if (current.left != null)
                stack.push(current.left);
            if (current.right != null)
                stack.push(current.right);
        }
        return preOrderList;
    }

    public List<List<T>> levelOrder() {
        if (root == null)
            return Collections.emptyList();

        List<List<T>> levelOrderList = new ArrayList<>();
        Queue<MyTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
ArrayList
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<T> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                MyTreeNode<T> current = queue.poll();
                levelList.add(current.data);

                if (current.left != null)
                    queue.add(current.left);
                if (current.right != null)
                    queue.add(current.right);
            }
            levelOrderList.add(levelList);
        }
        return levelOrderList;
    }

    public int getSize() {
        return size;
    }
}
