package com.Interface;

public interface MyInterface {

    default String getName(){
        return "诺导";
    }

    public static void show(){
        System.out.println("接口中的静态方法");
    }
}
