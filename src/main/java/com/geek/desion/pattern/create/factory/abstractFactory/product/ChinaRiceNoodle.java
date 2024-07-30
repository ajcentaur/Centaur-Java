package com.geek.desion.pattern.create.factory.abstractFactory.product;

public class ChinaRiceNoodle implements RiceNoodle{
    @Override
    public void makeRice() {
        System.out.println("Successfully made Chinese Rice noodles, price is 15 RMB");
    }
}
