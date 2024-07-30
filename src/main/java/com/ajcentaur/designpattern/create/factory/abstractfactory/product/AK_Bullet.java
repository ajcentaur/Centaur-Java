package com.ajcentaur.designpattern.create.factory.abstractfactory.product;

public class AK_Bullet implements Bullet {
    @Override
    public void load() {
        System.out.println("AK装弹完毕");
    }
}
