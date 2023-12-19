package com.ajcentaur.juc.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.atomic.AtomicReference;

public class ExecutorDemo {
    public static void main(String[] args) {
        Executors.newScheduledThreadPool(5);
        Executors.newCachedThreadPool();
//        Thread.currentThread().interrupt();
//        Runnable runnable = () -> System.out.println("执行成功");
//        new Thread(runnable).start();
        LinkedTransferQueue linkedTransferQueue = new LinkedTransferQueue();
        AtomicReference atomicReference = new AtomicReference();
        System.out.println("JVM虚拟机可用的处理器数量：" + Runtime.getRuntime().availableProcessors());
    }
}
