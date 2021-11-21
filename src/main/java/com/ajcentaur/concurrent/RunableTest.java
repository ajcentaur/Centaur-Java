package com.ajcentaur.concurrent;

public class RunableTest {

    public static class RunableTask implements Runnable{

        @Override
        public void run() {
            System.out.println("I am a Child thread. name:" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException{
        RunableTask task = new RunableTask();
        new Thread(task).start();
        new Thread(task).start();
    }

}
