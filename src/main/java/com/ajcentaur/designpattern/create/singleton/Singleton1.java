package com.ajcentaur.designpattern.create.singleton;

/**
 * 饿汉模式（类被加载时先实例化对象,如果用不到该对象，会造成资源浪费）
 */
public class Singleton1 {
    private static  Singleton1 uniqueInstance = new Singleton1();

    private Singleton1(){}

    private static Singleton1 getInstance(){
        //每次都返回已经实例化的对象
        return uniqueInstance;
    }
}
