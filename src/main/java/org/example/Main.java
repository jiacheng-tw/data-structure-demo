package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    int[] findByFor() {
        int[] numbers = {1, 3, 2, 4};
        int target = 6;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }

    int[] findByHashMap() {
        int[] numbers = {1, 3, 2, 4};
        int target = 6;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                return new int[] {map.get(target - numbers[i]), i};
            }
            map.put(numbers[i], i);
        }
        return new int[0];
    }
}