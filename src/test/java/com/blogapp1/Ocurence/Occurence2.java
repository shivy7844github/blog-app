package com.blogapp1.Ocurence;

import java.util.stream.Collectors;

public class Occurence2 {
    public static void main(String[] args) {

        String str = "Aabhisheka";
        System.out.println( str.chars()
                .mapToObj(y->(char)y)
        .collect(Collectors.groupingBy(x->x,Collectors.counting())));
    }
}
