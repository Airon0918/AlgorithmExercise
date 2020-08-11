package com.yangshm.designpattern.demo07;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        String[] dict = {"aaa", "bbb"};
        Set dict2 = Stream.of(dict).collect(Collectors.toSet());




    }
}