package com.ajcentaur.juc.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Simple AQS demo
 */
public class CentaurAQS extends AbstractQueuedSynchronizer {

    public boolean tryAcquire(int arg){
        return compareAndSetState(0, 1);
    }

    public boolean tryRelease(int arg){
        return compareAndSetState(1, 0);
    }

    public static void main(String[] args) {
        final CentaurAQS aqs = new CentaurAQS();
        aqs.acquireShared(1);
        new Thread(()->{
            System.out.println("thread1 acquire centaurAQS");
            aqs.acquire(1);
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            aqs.release(1);
            System.out.println("thread1 release centaurAQS");
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("thread2 acquire centaurAQS");
            aqs.acquire(1);

            aqs.release(1);
            System.out.println("thread2 release centaurAQS");
        }).start();
    }

}
