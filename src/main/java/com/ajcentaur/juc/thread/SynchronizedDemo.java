package com.ajcentaur.juc.thread;

public class SynchronizedDemo {

    public static void main(String[] args) {
        //修饰静态方法，锁住的是class对象所以thread1和thread2存在竞争锁的关系
        Thread thread1 = new Thread(() -> {
            try {
                LockObj.staticFunc();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                LockObj.staticFunc2();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();

        //修饰实例方法，锁住的是实例对象，所以thread3和thread4不存在竞争锁的关系
        Thread thread3 = new Thread(() -> {
            try {
                LockObj lockObj = new LockObj();
                lockObj.blockFunc();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread4 = new Thread(() -> {
            try {
                LockObj lockObj = new LockObj();
                lockObj.generalFunc();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread3.start();
        thread4.start();
    }

    static class LockObj{

        public synchronized void generalFunc() throws InterruptedException {
            System.out.println("实例方法被调用");
            Thread.sleep(10000);
            System.out.println("实例方法被调用结束");
        }

        public synchronized static void staticFunc() throws InterruptedException {
            System.out.println("静态方法被调用");
            Thread.sleep(10000);
            System.out.println("静态方法被调用结束");
        }

        public synchronized static void staticFunc2() throws InterruptedException {
            System.out.println("静态方法2被调用");
            Thread.sleep(10000);
            System.out.println("静态方法2被调用结束");
        }

        public void blockFunc() throws InterruptedException {
            synchronized (this){
                System.out.println("代码块被调用");
                Thread.sleep(10000);
                System.out.println("代码块被调用结束");
            }
        }

    }

}
