package com.interview;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        prepareOutput(Map.of(3, "Fizz", 5, "Buzz"));
    }

    public static List<? extends Serializable> prepareOutput(Map<Integer, String> params) {

        List<? extends Serializable> result = IntStream.rangeClosed(1, 100)
                        .mapToObj(number -> {
                            StringBuilder output = checkCondition(number, params);
                            return output.isEmpty() ? String.valueOf(number) : output;
                        })
                        .collect(Collectors.toList());

        return result;
    }

    private static StringBuilder checkCondition(int i, Map<Integer, String> params) {
        StringBuilder output = new StringBuilder("");
        params.forEach((key, value) -> {
            if(key != 0 && i % key == 0) output.append(value);
        });

        return output;
    }
}
