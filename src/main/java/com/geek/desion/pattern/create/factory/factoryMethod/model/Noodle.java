package com.geek.desion.pattern.create.factory.factoryMethod.model;

public class Noodle {
    public String name;
    public Double price;

    public void printReceipt(){
        System.out.println("已制作，名字：" + name + "，价格：" + price);
    }

}
