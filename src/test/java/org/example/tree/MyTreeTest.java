package org.example.tree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyTreeTest {

    private static MyTree<Integer> testTree;

    @BeforeAll
    static void beforeAll() {
        testTree = new MyTree<>();
        Arrays.asList(4, 2, 6, 1, 3, 5, 7)
                .forEach(num -> testTree.add(num));
    }

    @Test
    void minValue() {
        assertEquals(1, testTree.minValue());
    }

    @Test
    void maxValue() {
        assertEquals(7, testTree.maxValue());
    }

    @Test
    void preOrder() {
        testTree.preOrder().forEach(System.out::println);
    }

    @Test
    void inOrder() {
        testTree.inOrder().forEach(System.out::println);
    }

    @Test
    void postOrder() {
        testTree.postOrder().forEach(System.out::println);
    }

    @Test
    void levelOrder() {
        testTree.levelOrder().forEach(System.out::println);
    }
}