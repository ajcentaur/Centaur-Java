package com.ajcentaur.design.pattern;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/7 16:43
 * @description: 装饰器模式
 */
public class DecoratorPattern {
    public static void main(String[] args) {
        new ExtendSomething(new FirstRobot()).doSomething();

    }
}

interface Robot{
    void doSomething();
}

/**
 * 被装饰的类
 */
class FirstRobot implements Robot{

    @Override
    public void doSomething() {
        System.out.println("唱歌~");
        System.out.println("跳舞~");
    }
}

/**
 * 装饰器
 */
class ExtendSomething implements Robot{
    private Robot robot;

    public ExtendSomething(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void doSomething() {
        robot.doSomething();
        System.out.println("拖地~");
        System.out.println("遛狗~");
    }

//    public void doExtend(){
//        doSomething();
//        System.out.println("拖地~");
//        System.out.println("遛狗~");
//    }
}
