package com.blogapp1.streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test extends Employee{


    public Test(int id, String name, int age, long salary) {
        super(id, name, age, salary);
    }

    public static void main(String[] args) {

        List<Employee> emps =  new ArrayList<>();
        emps.add( new  Employee (1,"Abhishek" , 23 , 63000));
        emps.add( new  Employee (1,"Aakash" , 29 , 75000));
        emps.add( new  Employee (1,"Riya" , 22 , 96000));
        emps.add( new  Employee (1,"Priya" , 19 , 100000));



        List<Employee> employeeList = emps.stream()
                .sorted((a, b) -> (int) (b.getSalary() - a.getSalary()))
           //     .limit(3)
                .skip(3)
                .collect(Collectors.toList());
        System.out.println(employeeList);

        Map<String, Long> collect = emps.stream().collect(Collectors.groupingBy(Employee::getName, Collectors.counting()));
        System.out.println(collect);

        Map<Integer, Double> collect1 = emps.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(collect1);
    }
}
