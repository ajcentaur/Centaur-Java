package com.geek.desion.pattern.create.factory.abstractFactory.product;

public class ItalyNoodle implements Noodle{
    @Override
    public void make() {
        System.out.println("Successfully made Italy noodles, price is 23 RMB");
    }
}
