package com.geek.desion.pattern.create.factory.simpleFactory;

public class ItalyNoodle extends Noodle{
    @Override
    public void make() {
        this.name = "意大利面条";
        this.price = 25D;
    }
}
