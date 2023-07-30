package com.ajcentaur.concurrent;

import java.text.MessageFormat;

public class Test {

    public static void main(String[] args) {
//        runReentrantLockFunc();
        runSemaphoreFunc();
    }

    private static void runSemaphoreFunc(){
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        Thread threadA = new Thread(() ->{
            int i = 0;
            while (++i <= 500){
                System.out.println(MessageFormat.format("线程：{0}，index：{1}",
                        String.valueOf(Thread.currentThread().getId()),String.valueOf(i)));
                semaphoreTest.addOne();
            }
        });
        Thread threadB = new Thread(() ->{
            int i = 0;
            while (++i <= 500){
                System.out.println(MessageFormat.format("线程：{0}，index：{1}",
                        String.valueOf(Thread.currentThread().getId()),String.valueOf(i)));
                semaphoreTest.addOne();
            }
        });
        threadA.start();
        threadB.start();
        try {
            threadA.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            threadB.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("最终结果：" + semaphoreTest.get());
    }

    private static void runReentrantLockFunc(){
        ReentrantLockTest lockTest = new ReentrantLockTest();

        Thread threadA = new Thread(() ->{
            int i = 0;
            while (++i <= 1000){
                System.out.println(MessageFormat.format("线程：{0}，index：{1}",
                        String.valueOf(Thread.currentThread().getId()),String.valueOf(i)));
                lockTest.add();
            }
        });
        Thread threadB = new Thread(() -> {
            int i = 0;
            while (++i <= 1000){
                System.out.println(MessageFormat.format("线程：{0}，index：{1}",
                        String.valueOf(Thread.currentThread().getId()),String.valueOf(i)));
                lockTest.add();
            }
        });
        threadA.start();
        threadB.start();
        try {
            threadA.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            threadB.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("最终结果：" + lockTest.get());
    }

}
