package com.ajcentaur.designpattern.create.singleton;

/**
 * 懒汉模式（只有需要的时候才去实例化对象）
 */
public class Singleton2 {

    //volatile保证，当uniqueInstance变量被初始化成Singleton实例时，多个线程可以正确处理uniqueInstance变量
    //若一开始就对方法进行加锁，则变量无需加volatile
    private static volatile Singleton2 uniqueInstance;

    private Singleton2(){}

    /**
     * 加锁保证线程安全，但是每次访问该方法都会加锁，但是synchronized是重量级锁，会对性能有影响
     * @return
     */
    private static synchronized Singleton2 getInstance1(){
        if(uniqueInstance == null){
            uniqueInstance = new Singleton2();
        }
        return uniqueInstance;
    }

    /**
     * 双重检查加锁
     * @return
     */
    private static Singleton2 getInstance2(){
        //若为空则执行代码块
        if(uniqueInstance == null){
            //只有第一次对象为空时才进行加锁
            synchronized (Singleton2.class){
                //再次确保对象为空
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton2();
                }
            }
        }
        return uniqueInstance;
    }
}
