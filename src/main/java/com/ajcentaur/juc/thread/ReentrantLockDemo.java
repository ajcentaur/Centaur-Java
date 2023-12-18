package com.ajcentaur.juc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    private static int count = 0;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
//        Lock lock = new ReentrantLock(true);
//        Condition condition = lock.newCondition();
//        condition.await();
        Runnable runnable = () ->{
            lock.lock();
            try {
                count += 1;
                System.out.printf("当前操作线程为%s，当前值等于%s%n", Thread.currentThread(), count);
            }catch (Exception e){
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }

        };
        for (int i = 0; i < 50000; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("最终值为：%s%n", count);
    }

}
