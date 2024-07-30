package com.geek.desion.pattern.create.factory.abstractFactory.product;

public class ChinaNoodle implements Noodle{
    @Override
    public void make() {
        System.out.println("Successfully made Chinese noodles, price is 18 RMB");
    }
}
