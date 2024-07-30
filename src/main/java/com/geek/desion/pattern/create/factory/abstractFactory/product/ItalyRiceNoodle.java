package com.geek.desion.pattern.create.factory.abstractFactory.product;

public class ItalyRiceNoodle implements RiceNoodle{
    @Override
    public void makeRice() {
        System.out.println("Successfully made Italy rice noodles, price is 20 RMB");
    }
}
