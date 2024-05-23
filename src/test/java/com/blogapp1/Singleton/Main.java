package com.blogapp1.Singleton;

public class Main {
    public static void main(String[] args) {
        User instance1 = User.getInstance();
        System.out.println(instance1.hashCode());
        User instance2 = User.getInstance();
        System.out.println(instance2.hashCode());

        User2 user2 = User2.getInstance();
        System.out.println(user2.hashCode());
        User2 user3 =  User2.getInstance();
        System.out.println(user3.hashCode());
    }
}
