package com.ajcentaur.design.pattern;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/7 12:38
 * @description: 懒汉式单例
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {}

    /**
     * 非线程安全版本
     * @return
     */
//    public static Singleton1 getInstance() {
//        if(instance == null){
//            instance = new Singleton1();
//        }
//        return instance;
//    }

    /**
     * 加锁版本
     * @return
     */
//    public static synchronized Singleton1 getInstance(){
//        if(instance == null){
//            instance = new Singleton1();
//        }
//        return instance;
//    }

    /**
     * 双重加锁版本
     * @return
     */
    public static synchronized Singleton2 getInstance(){
        if(instance == null){
            //同步代码块
            synchronized (Singleton2.class){
                if(instance == null){
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }

}
