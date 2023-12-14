package com.ajcentaur.juc.pool;

import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
//        Executors.newScheduledThreadPool(5);
//        Thread.currentThread().interrupt();
//        Runnable runnable = () -> System.out.println("执行成功");
//        new Thread(runnable).start();
        System.out.println("JVM虚拟机可用的处理器数量：" + Runtime.getRuntime().availableProcessors());
    }
}
