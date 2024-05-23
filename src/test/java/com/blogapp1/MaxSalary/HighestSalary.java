package com.blogapp1.MaxSalary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HighestSalary {
    public static void main(String[] args) {
        List<Employee> emps =new ArrayList<>();
                emps.add( new Employee("Abhishek" ,  63000.63));
                emps.add( new Employee("karan" ,  66000.43));
                emps.add( new Employee("Abhishek" ,  77000.63));
                emps.add( new Employee("Abhishek" ,  99000.63));
                emps.add( new Employee("Abhishek" ,  1000000.63));

        Double Highest = emps.stream()
                .map(x -> x.getSalary())
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();
        System.out.println(Highest);


    }
    }

