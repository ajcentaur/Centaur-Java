package com.ajcentaur.design.pattern.create.singleton;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/7 12:57
 * @description: 静态内部类懒汉式单例
 */
public class Singleton3 {
    private Singleton3() {}

    private static class StaticSingleton3{
        private static Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance(){
        return StaticSingleton3.instance;
    }
}
