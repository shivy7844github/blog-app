package com.blogapp1.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(14,45,5,17,65,5,7,13);

        Optional<Integer> max = list.stream()
                .sorted()
                .limit(2)
                .max((a, b) -> (b - a));

        System.out.println(max);
        List<String> stream = list.stream().map(x -> x + "").filter(y -> y.startsWith("1")).collect(Collectors.toList());
        System.out.println(stream);
    }
}
