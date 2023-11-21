package com.ajcentaur.concurrent.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();
    private int count = 0;

    public int get(){
        lock.lock();
        try {
            return count;
        } finally {
            lock.unlock();
        }
    }
    public void add(){
        lock.lock();
        try {
            count = 1 + get();
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

}
