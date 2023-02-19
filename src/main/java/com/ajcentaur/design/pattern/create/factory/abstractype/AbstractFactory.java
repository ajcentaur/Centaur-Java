package com.ajcentaur.design.pattern.create.factory.abstractype;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/7 16:13
 * @description: 抽象工厂模式
 */
public class AbstractFactory {
    public static void main(String[] args) {
        Factory factory = new SuperFactory();
        Mask mask = factory.createMask();
        mask.print();
    }
}

/**
 * 抽象产品
 */
interface Phone{
    void print();
}

/**
 * 实际产品
 */
class ApplePhone implements Phone {

    @Override
    public void print() {
        System.out.println("生产了苹果手机");
    }
}

class HuaWeiPhone implements Phone {

    @Override
    public void print() {
        System.out.println("生产了华为手机");
    }
}

/**
 * 抽象产品
 */
interface Mask{
    void print();
}

class N95Mask implements Mask {

    @Override
    public void print() {
        System.out.println("生产了N95口罩");
    }
}

class SampleMask implements Mask {

    @Override
    public void print() {
        System.out.println("生产了普通口罩");
    }
}

/**
 * 抽象工厂
 */
interface Factory{
    Phone createPhone();
    Mask createMask();
}

/**
 * 实际工厂
 */
class SuperFactory implements Factory {

    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }

    @Override
    public Mask createMask() {
        return new N95Mask();
    }
}




