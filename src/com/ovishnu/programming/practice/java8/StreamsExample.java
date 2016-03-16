package com.ovishnu.programming.practice.java8;

import java.util.Arrays;
import java.util.List;

public class StreamsExample {

    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted()
                .forEach((c) -> System.out.println(c));
    }
}
