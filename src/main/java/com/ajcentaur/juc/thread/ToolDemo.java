package com.ajcentaur.juc.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 并发工具类
 */
public class ToolDemo {

    public static void main(String[] args) throws InterruptedException {
//        threadJoinTest();
        countDownLatchTest();
    }

    private static void threadJoinTest() throws InterruptedException {
        Runnable runnable = ()->{
            System.out.printf("任务被调用，当前调用线程为%s%n", Thread.currentThread());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread1.join();
        System.out.println("thread1完成");
        thread2.start();
        thread2.join();
        System.out.println("thread2完成");
        System.out.println("all thread finish");
    }

    private static void countDownLatchTest() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);
        Runnable runnable = ()->{
            System.out.printf("任务被调用，当前调用线程为%s%n", Thread.currentThread());
            try {
                Thread.sleep(5000);
                // 标记已经完成一个任务
                cdl.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        cdl.await();
        System.out.println("all thread finish");
    }

}
