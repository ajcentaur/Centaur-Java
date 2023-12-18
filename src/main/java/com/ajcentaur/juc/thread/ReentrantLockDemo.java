package com.ajcentaur.juc.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantLockDemo {
    private static int count = 0;
    private static ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
//        generalFunc();

        readWriteFunc();
    }

    private static void generalFunc(){
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

    private static void readWriteFunc(){
        Lock readLock = rwlock.readLock();
        Lock writeLock = rwlock.writeLock();
        Runnable readRunnable = () ->{
            readLock.lock();
            try {
                System.out.println(rwlock.getReadLockCount());
                System.out.println("读锁调用");
                Thread.sleep(5000);
                System.out.printf("当前操作线程为%s，当前值等于%s%n", Thread.currentThread(), count);
            }catch (Exception e){
                throw new RuntimeException(e);
            }finally {
                readLock.unlock();
            }
        };
        Runnable writeRunnable = () ->{
            writeLock.lock();
            try {
                System.out.println("写锁调用");
                Thread.sleep(5000);
                count += 1;
                System.out.printf("当前操作线程为%s，当前值等于%s%n", Thread.currentThread(), count);
            }catch (Exception e){
                throw new RuntimeException(e);
            }finally {
                writeLock.unlock();
            }
        };

        Thread thread1 = new Thread(writeRunnable);
        Thread thread2 = new Thread(readRunnable);
        Thread thread3 = new Thread(readRunnable);
        thread3.start();
        thread1.start();
        thread2.start();
    }

}
