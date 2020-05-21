package com.kodilla.stream.array;

import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.List;

public interface ArrayOperations {

    int[] numbers = new int[9];

    static OptionalDouble getAverage(int[] numbers) {
        IntStream.range(0, 10)
                .map(n -> numbers[n])
                .forEach(System.out::println);
        OptionalDouble average = IntStream.range(0, 10)
                .map(n -> numbers[n])
                .average();
        return average;
    }
}