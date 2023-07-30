package com.ajcentaur.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private final Semaphore semaphore = new Semaphore(1);
    private int count;

    public int get(){
        return count;
    }

    public void addOne(){
        try {
            semaphore.acquire();
            count += 1;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

}
