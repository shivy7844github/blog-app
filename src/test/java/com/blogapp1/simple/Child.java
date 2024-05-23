package com.blogapp1.simple;

  class Child extends Parent{
    int x=10;


    public void test1(){
        System.out.println(5200);
    }

    public static void main(String[] args) {
       Parent p = new Child();
       p.test();
        System.out.println();


    }
}
