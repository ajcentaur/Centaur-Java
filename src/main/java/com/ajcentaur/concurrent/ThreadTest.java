package com.ajcentaur.concurrent;

public class ThreadTest {

    public static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("I am a child thread." + "name:" + this.getName());
        }
    }

    public static void main(String[] args){
        new MyThread().start();
        new MyThread().start();
        //上面两行代码效果等同于下面代码效果
        MyThread thread = new MyThread();
        thread.start();
        MyThread thread1 = new MyThread();
        thread1.start();
    }

}
