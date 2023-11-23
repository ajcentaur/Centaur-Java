package com.ajcentaur.design.pattern.create.factory;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/7 16:01
 * @description: 一般工厂模式
 */
public class FactorySample {
    public static void main(String[] args) {
        Factory factory = new AppleFactory();
        factory.createPhone().print();

        Factory factory1 = new HuaWeiFactory();
        factory1.createPhone().print();
    }
}

interface Phone{
    void print();
}

class ApplePhone implements Phone{

    @Override
    public void print() {
        System.out.println("生产了苹果手机");
    }
}

class HuaWeiPhone implements Phone{

    @Override
    public void print() {
        System.out.println("生产了华为手机");
    }
}

interface Factory{
    Phone createPhone();
}

class AppleFactory implements Factory{

    @Override
    public Phone createPhone() {
        return new ApplePhone();
    }
}

class HuaWeiFactory implements Factory{

    @Override
    public Phone createPhone() {
        return new HuaWeiPhone();
    }
}




