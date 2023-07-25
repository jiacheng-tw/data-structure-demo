package org.example.array;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyArrayTest {

    private MyArray<Integer> testArray;

    @BeforeEach
    void setUp() {
        testArray = new MyArray<>(2);
    }

    @Test
    void testAdd() {
        assertNull(testArray.get(0));

        assertTrue(testArray.add(1));
        assertTrue(testArray.add(2));
        assertFalse(testArray.add(3));

        assertEquals(1, testArray.get(0));
        assertEquals(2, testArray.get(1));
        assertNull(testArray.get(2));
    }

    @Test
    void testAddWithIndex() {
        assertTrue(testArray.add(1));
        assertEquals(1, testArray.get(0));

        assertTrue(testArray.add(0, -1));
        assertFalse(testArray.add(1, 0));

        assertEquals(-1, testArray.get(0));
        assertEquals(1, testArray.get(1));
        assertNull(testArray.get(2));
    }

    @Test
    void testRemove() {
        assertFalse(testArray.remove(0));
        assertTrue(testArray.add(1));
        assertTrue(testArray.add(2));

        assertFalse(testArray.remove(2));
        assertTrue(testArray.remove(0));
        assertEquals(2, testArray.get(0));
    }

    @Test
    void testSet() {
        assertFalse(testArray.set(0, 1));
        assertTrue(testArray.add(1));
        assertEquals(1, testArray.get(0));

        assertTrue(testArray.set(0, 2));
        assertEquals(2, testArray.get(0));
        assertFalse(testArray.set(1, 3));
    }

    @Test
    void testGet() {
        assertNull(testArray.get(0));
        assertTrue(testArray.add(1));
        assertEquals(1, testArray.get(0));
        assertNull(testArray.get(1));
    }
}
