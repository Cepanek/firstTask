package com.interview;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";

    private static Stream<Arguments> testParams() {
        return Stream.of(
                        Arguments.arguments(Map.of(101, FIZZ, 200, BUZZ), 100, 0, 0),
                        Arguments.arguments(Map.of(10, FIZZ, 50, BUZZ), 90, 10, 2),
                        Arguments.arguments(Map.of(10, FIZZ, 200, BUZZ), 90, 10, 0),
                        Arguments.arguments(Map.of(200, FIZZ, 10, BUZZ), 90, 0, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("testParams")
    public void testShouldPassWhenGivenValuesAreProper(Map<Integer, String> params, int expectedNumberCount, int expectedFizzCount,
                                                       int expectedBuzzCount) {
        int currentNumberCount = 0;
        int currentFizzCount = 0;
        int currentBuzzCount = 0;
        List<? extends Serializable> result = Main.prepareOutput(params);
        for (Serializable i : result) {
            if (i.toString().contains(FIZZ)) currentFizzCount++;
            if (i.toString().contains(BUZZ)) currentBuzzCount++;
            if (!i.toString().contains(FIZZ) && !i.toString().contains(BUZZ)) currentNumberCount++;
        }
        assertEquals(expectedNumberCount, currentNumberCount);
        assertEquals(expectedFizzCount, currentFizzCount);
        assertEquals(expectedBuzzCount, currentBuzzCount);
    }
}