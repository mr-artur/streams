package ua.kpi.arturo.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String... args) {
        int[] numbers = {1, 2, 3, 4, 5, -6, 7, 8, 9, 10};

        // 1 //
        System.out.println(IntStream.of(numbers).average().getAsDouble());
        System.out.println((double) IntStream.of(numbers).reduce(Integer::sum).getAsInt() / numbers.length);
        // 2 //
        System.out.println(IntStream.of(IntStream.of(numbers).min().getAsInt(),
                                        IntStream.of(numbers)
                                                .mapToObj(Integer::valueOf)
                                                .collect(Collectors.toList())
                                                .indexOf(IntStream.of(numbers).min().getAsInt()))
                                   .mapToObj(Integer::valueOf)
                                   .collect(Collectors.toList()));
        // 3 //
        System.out.println(IntStream.of(numbers).filter(number -> number == 0).count());
        // 4 //
        System.out.println(IntStream.of(numbers).filter(number -> number > 0).count());
        // 5 //
        int multiplier = 5;
        System.out.println(IntStream.of(numbers).mapToObj(number -> number * multiplier).collect(Collectors.toList()));
    }
}
