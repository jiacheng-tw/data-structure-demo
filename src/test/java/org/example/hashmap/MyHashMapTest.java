package org.example.hashmap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHashMapTest {

    private final MyHashMap<String, String> testHashMap = new MyHashMap<>();

    @BeforeEach
    void testPut() {
        assertEquals(0, testHashMap.getSize());
        testHashMap.put("hello", "world");
        assertEquals(1, testHashMap.getSize());
        System.out.println(testHashMap.get("hello"));
    }

    @Test
    void testGet() {
        assertEquals("world", testHashMap.get("hello"));
    }

    @AfterEach
    void testRemove() {
        testHashMap.remove("hello");
        assertEquals(0, testHashMap.getSize());
    }
}