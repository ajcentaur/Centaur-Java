package com.ajcentaur.design.pattern.create.singleton;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/7 12:36
 * @description: 饿汉式单例
 */
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();

    private Singleton1() {}

    public static Singleton1 getInstance() {
        return instance;
    }
}
