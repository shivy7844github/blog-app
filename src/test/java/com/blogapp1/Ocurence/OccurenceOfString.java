package com.blogapp1.Ocurence;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OccurenceOfString {

    public static void main(String[] args) {


        // I have List Of String find out Occurence of String
        List<String> str = Arrays.asList("abc" , "def" , "lop" , "Qrs" , "nop" ,"abc" , "lop" , "nop");
        System.out.println( str.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())));
    }
}
