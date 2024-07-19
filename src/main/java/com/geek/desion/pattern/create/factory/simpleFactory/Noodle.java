package com.geek.desion.pattern.create.factory.simpleFactory;

public abstract class Noodle {
    public String name;
    public Double price;

    public abstract void make();

    public void printReceipt(){
        System.out.println("已制作，名字：" + name + "，价格：" + price);
    }

}
