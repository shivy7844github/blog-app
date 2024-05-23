package com.blogapp1.Singleton;

public class User {

    private static User instance;
    private User(){

    }
    // lazy way to create instance
    public static User getInstance(){
        if (instance==null){
         instance= new User();
        }
  return instance;
    }


}
