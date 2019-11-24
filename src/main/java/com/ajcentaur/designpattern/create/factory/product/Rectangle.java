package com.ajcentaur.designpattern.create.factory.product;

public class Rectangle implements Shape {

    public Rectangle() {
        System.out.print("Rectangle");
    }

    @Override
    public void draw() {
        System.out.println("画了一个长方形");
    }
}
