package com.ajcentaur.juc.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class ThreadDemo {

    public static void main(String[] args) {
        canStopLogic();

//        notStopFuncLogic();

//        notStopFuncLogic2();
    }

    private static void canStopLogic(){
        Runnable runnable = new BasicRunnable();
        System.out.println("启动第一个线程");
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("启动第二个线程");
        Thread thread2 = new Thread(runnable);
        thread2.start();
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(String.format("中止线程：%s", thread.getName()));
//        thread.interrupt();
    }

    static class BasicRunnable implements Runnable{
        @Override
        public void run() {
            try {
                singleThread();
            } catch (InterruptedException e) {
                System.out.println(String.format("线程%s已经被中止", Thread.currentThread().getName()));
                throw new RuntimeException(e);
            }
        }
    }

    public static void singleThread() throws InterruptedException {
        System.out.println(String.format("当前调用线程为%s，所属线程组为%s", Thread.currentThread().getName(), Thread.currentThread().getThreadGroup().getName()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        int count = 20;
        for (int i = 0; i < count; i++) {
            System.out.println(String.format("当前时间为：%s，当前遍历索引为：%s，当前线程id为：%s，name为：%s"
                    ,sdf.format(new Date()) , i, Thread.currentThread().getId(), Thread.currentThread().getName()));
            Random random = new Random();
            int randomVal = random.nextInt(1000) + 1000;
            Thread.sleep(randomVal);
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void singleThread(String callName) throws InterruptedException {
        System.out.println(String.format("调用人：%s", callName));
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        int count = 20;
        for (int i = 0; i < count; i++) {
            System.out.println(String.format("当前时间为：%s，当前遍历索引为：%s，当前线程id为：%s，name为：%s"
                    ,sdf.format(new Date()) , i, Thread.currentThread().getId(), Thread.currentThread().getName()));
            Random random = new Random();
            int randomVal = random.nextInt(1000) + 1000;
            Thread.sleep(randomVal);
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    /**
     * 不被中止的线程逻辑demo
     */
    private static void notStopFuncLogic(){
        Thread thread1 = new Thread(ThreadDemo::catchStopExceptionThread);
        thread1.start();
        System.out.println(String.format("线程%s开始运行", thread1.getName()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread1.interrupt();
        System.out.println(String.format("中止线程：%s", thread1.getName()));
    }

    private static void notStopFuncLogic2(){
        Thread thread1 = new Thread(ThreadDemo::catchStopExceptionNotSleepThread);
        thread1.start();
        System.out.println(String.format("线程%s开始运行", thread1.getName()));
        thread1.interrupt();
        System.out.println(String.format("中止线程：%s", thread1.getName()));
    }

    public static void catchStopExceptionThread() {
        System.out.println(String.format("当前调用线程为%s，所属线程组为%s", Thread.currentThread().getName(), Thread.currentThread().getThreadGroup().getName()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        int count = 20;
        for (int i = 0; i < count; i++) {
            System.out.println(String.format("当前时间为：%s，当前遍历索引为：%s，当前线程id为：%s，name为：%s"
                    ,sdf.format(new Date()) , i, Thread.currentThread().getId(), Thread.currentThread().getName()));
            System.out.println(String.format("线程%s中断标志位为%s", Thread.currentThread().getName(), Thread.currentThread().isInterrupted()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(String.format("检测到线程被请求终止，忽略，线程为%s", Thread.currentThread().getName()));
            }
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void catchStopExceptionNotSleepThread() {
        System.out.println(String.format("当前调用线程为%s，所属线程组为%s", Thread.currentThread().getName(), Thread.currentThread().getThreadGroup().getName()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        int count = 20;
        for (int i = 0; i < count; i++) {
            System.out.println(String.format("当前时间为：%s，当前遍历索引为：%s，当前线程id为：%s，name为：%s"
                    ,sdf.format(new Date()) , i, Thread.currentThread().getId(), Thread.currentThread().getName()));
            System.out.println(String.format("线程%s中断标志位为%s", Thread.currentThread().getName(), Thread.currentThread().isInterrupted()));
            if (Thread.currentThread().isInterrupted()){
                System.out.println(String.format("线程%s中断标志位已重置, 重置前中断标志位为%s", Thread.currentThread().getName(), Thread.interrupted()));
            }
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

}
