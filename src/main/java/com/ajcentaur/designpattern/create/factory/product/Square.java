package com.ajcentaur.designpattern.create.factory.product;

public class Square implements Shape {

    public Square() {
        System.out.print("Square");
    }

    @Override
    public void draw() {
        System.out.println("画了一个正方形");
    }
}
