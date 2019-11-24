package com.ajcentaur.designpattern.create.factory.abstractfactory;

public class M4A1_Bullet implements Bullet {
    @Override
    public void load() {
        System.out.println("M4A1装弹完毕");
    }
}
