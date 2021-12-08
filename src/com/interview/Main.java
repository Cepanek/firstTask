package com.interview;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        prepareOutput(Map.of(3, "Fizz", 5, "Buzz"));
    }

    private static void prepareOutput(Map<Integer, String> params) {

        for (int i = 1; i<= 100; i++) {
            int tempI = i;
            params.forEach((key, value) -> {
                if (tempI % key == 0) {
                    System.out.println(value);
                } else {
                    System.out.println(tempI);
                }
            });
        }
    }
}
