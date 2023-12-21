package com.ajcentaur.juc.thread;

public class Test {

    public static void main(String[] args) {
//        int i = 0;
//        int j = 9;
//        int k = i + j;
//        System.out.println(k);
        forDemo();
    }

    private static void forDemo(){
        //自旋
        for (int i = 0; ;i++) {
            System.out.println("自旋" + i);
            if(i > 1000){
                System.out.println("返回");
                // 结束方法
                return;
            }
        }
//        System.out.println("结束自旋");
    }

}
