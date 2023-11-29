package com.ajcentaur.basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class FinalDemo {

    static class Value {
        int i;

        final int b = 5;

        int c = 6;

        public Value(int i) {
            this.i = i;
        }
    }

    public static class FinalData {
        private static Random rand = new Random(47);
        private String id;

        public FinalData(String id) {
            this.id = id;
        }
        // 编译时常量
        private final int valueOne = 9;
        private static final int VALUE_TWO = 99;
        // 公共常量
        public static final int VALUE_THREE = 39;
        //非编译时常量
        private final int i4 = rand.nextInt(20);
        static final int INT_5 = rand.nextInt(20);
        private Value v1 = new Value(11);
        private final Value v2 = new Value(22);
        private static final Value VAL_3 = new Value(33);
        // 数组
        private final int[] a = {1, 2, 3, 4, 5, 6};

        @Override
        public String toString() {
            //随机数会在运行时初始化，多个对象的i4值是不同的
            //但是静态的随机数是在编译期就初始化，所以对各对象的INT_5是相同的
            return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
        }
    }

    /**
     * 空白final例子
     */
    static class BlankFinalData{
        private final int i = 0;
        private final int j; //空白final值，初始化不赋值会错误，编译器会确保final值必须初始化
        private final Value value; //空白final引用同理

        public BlankFinalData() {
            this.j = 2;
            this.value = new Value(5);
        }

        public BlankFinalData(int j) {
            this.j = j;
            this.value = new Value(j);
        }

        @Override
        public String toString() {
            return "BlankFinalData{" +
                    "i=" + i +
                    ", j=" + j +
                    ", value=" + value.i +
                    '}';
        }
    }

    public static void blankTest() {
        BlankFinalData bfd1 = new BlankFinalData();
        BlankFinalData bfd2 = new BlankFinalData(16);
        System.out.println(bfd1);
        System.out.println(bfd2);
    }

    public static void main(String[] args) {
        blankTest();
        Map<String,Object> map = new HashMap<>();
        FinalData fd1 = new FinalData("fd1");
//         fd1.valueOne++;  错误：值无法修改
//         fd1.VALUE_TWO++;  错误：值无法修改
//         fd1.VALUE_THREE++;  错误：值无法修改

        //final修饰的对象
        fd1.v2.i++; //对象的非final值可以修改
//        fd1.v2.b++; // 错误：对象的final值无法修改
        fd1.v2.c++; //对象的非final值可以修改
//        fd1.v2 = new Value(3); //错误：引用无法修改

        //static和final修饰的对象
//        fd1.VAL_3 = new Value(1); //错误：引用无法修改
        System.out.println(fd1.VAL_3); //这里只是测试需要，最好通过类名.属性来访问静态属性/方法，避免编译器再次优化该语句，真相在字节码文件中

        //非final修饰的对象
        fd1.v1 = new Value(9); //引用可以修改

        //数组
        for(int i = 0; i < fd1.a.length; i++){
            fd1.a[i]++; //数组的值可变
        }
//        fd1.a = new int[]{5, 6, 7}; //错误：数组对象引用不可变

        //输出
        System.out.println(fd1);
        System.out.println("Creating new FinalData");
        FinalData fd2 = new FinalData("fd2");
        System.out.println(fd1);
        System.out.println(fd2);
    }
}
