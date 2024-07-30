package com.ajcentaur.designpattern.create.factory.abstractfactory.product;

public class AK implements Gun {
    @Override
    public void shooting() {
        System.out.println("获得一把AK步枪");
    }
}
