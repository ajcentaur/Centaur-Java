package com.ajcentaur.design.pattern.create.factory.simple;

/**
 * @version 1.0.0
 * @author: Centaur
 * @date: 2022/9/7 15:35
 * @description: 简单工厂模式
 */
public class SimpleFactory {
    /**
     * 产品类型
     * @param type
     * @return
     */
    public static Product createProduct(String type){
        if("A".equals(type)){
            return new ProductA();
        }else {
            return new ProductB();
        }
    }

    public static void main(String[] args) {
        Product product = createProduct("A");
        product.print();
    }
}

abstract class Product{
    public abstract void print();
}

class ProductA extends Product{

    @Override
    public void print() {
        System.out.println("成产了产品A");
    }
}

class ProductB extends Product{

    @Override
    public void print() {
        System.out.println("生产了产品B");
    }
}
