package com.ajcentaur.designpattern.create.factory.product;

public class Circle implements Shape {

    public Circle() {
        System.out.print("Circle");
    }

    @Override
    public void draw() {
        System.out.println("画了一个圆形");
    }

}
