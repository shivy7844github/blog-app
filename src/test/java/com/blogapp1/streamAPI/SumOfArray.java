package com.blogapp1.streamAPI;

import java.util.Arrays;
import java.util.List;

public class SumOfArray {
    public static void main(String[] args) {

        int[] arr = {  2 ,5,4,3,7};

        int sum = Arrays.stream(arr).sum();
        int[] array = Arrays.stream(arr).toArray();
        long count = Arrays.stream(arr).count();
        System.out.println(count);
        System.out.println(array);
        System.out.println(sum);
    }
}
