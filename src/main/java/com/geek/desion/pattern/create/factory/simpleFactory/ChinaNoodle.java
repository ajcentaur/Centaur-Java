package com.geek.desion.pattern.create.factory.simpleFactory;

public class ChinaNoodle extends Noodle{
    @Override
    public void make() {
        this.name = "中式面条";
        this.price = 18D;
    }
}
