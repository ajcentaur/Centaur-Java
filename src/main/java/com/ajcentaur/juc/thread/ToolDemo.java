package com.ajcentaur.juc.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 并发工具类
 */
public class ToolDemo {

    public static void main(String[] args) throws InterruptedException {
//        threadJoinTest();
//        countDownLatchTest();
        cyclicBarrierTest();
//        cyclicBarrierBankTest();
    }

    private static void threadJoinTest() throws InterruptedException {
        Runnable runnable = ()->{
            System.out.printf("任务被调用，当前调用线程为%s%n", Thread.currentThread());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread1.join();
        System.out.println("thread1完成");
        thread2.start();
        thread2.join();
        System.out.println("thread2完成");
        System.out.println("all thread finish");
    }

    private static void countDownLatchTest() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);
        Runnable runnable = ()->{
            System.out.printf("任务被调用，当前调用线程为%s%n", Thread.currentThread());
            try {
                Thread.sleep(5000);
                // 标记已经完成一个任务
                cdl.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        cdl.await();
        System.out.println("all thread finish");
        //CountDownLatch不能重复使用，计数器减完之后再次调用await()不会等待，计数器state不会自动恢复
        Thread thread3 = new Thread(runnable);
        thread3.start();
        cdl.await();
        System.out.println("all2 thread finish");
    }

    private static void cyclicBarrierTest(){
        CyclicBarrier cyc = new CyclicBarrier(2);
        Runnable runnable = ()->{
            System.out.printf("任务被调用，当前调用线程为%s%n", Thread.currentThread());
            try {
                Thread.sleep(5000);
                // 标记一个任务已经到达栅栏
                cyc.await();
                System.out.printf("线程%s调用已经结束%n", Thread.currentThread());
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        //CyclicBarrier的计数器可以循环使用
        Thread thread3 = new Thread(runnable);
        thread3.start();
        //不会阻塞主线程
        System.out.println("all thread finish");
    }

    private static void cyclicBarrierBankTest(){
        Map<String, Integer> bankWaterMap = new HashMap<>();
        Runnable sumRun = ()->{
            Integer result = bankWaterMap.values().stream().mapToInt(Integer::intValue).sum();
            System.out.printf("银行流水总和为%s%n", result);
        };
        CyclicBarrier cyc = new CyclicBarrier(5, sumRun);
        Runnable valueRun = ()->{
            bankWaterMap.put(Thread.currentThread().getName(), 5);
            try {
                System.out.printf("任务被调用，当前调用线程为%s%n", Thread.currentThread());
                Thread.sleep(5000);
                cyc.await();
                System.out.printf("线程%s调用已经结束%n", Thread.currentThread());
            } catch (InterruptedException | BrokenBarrierException e) {
                throw new RuntimeException(e);
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executor.execute(valueRun);
        }
    }

}
