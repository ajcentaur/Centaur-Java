package com.ajcentaur.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

    public static class CallerTask implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("I am a child thread. name:" + Thread.currentThread().getName());
            return "hello" + Thread.currentThread().getName();
        }
    }

    public static void main(String[] args){
        FutureTask<String> task = new FutureTask<>(new CallerTask());
        new Thread(task).start();
        FutureTask<String> task2 = new FutureTask<>(new CallerTask());
        new Thread(task2).start();
        try {
            String result = task.get();
            System.out.println(result);
            String result2 = task2.get();
            System.out.println(result2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}
