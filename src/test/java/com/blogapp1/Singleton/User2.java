package com.blogapp1.Singleton;

public class User2 {

    private static User2 instance = new User2();


    public static User2 getInstance(){
        return instance;
    }
}
