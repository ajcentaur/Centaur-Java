package com.geek.desion.pattern.create.factory.factoryMethod;

import com.geek.desion.pattern.create.factory.factoryMethod.model.ChinaNoodle;
import com.geek.desion.pattern.create.factory.factoryMethod.model.Noodle;

public class ChinaNoodleFactory implements NoodleFactory{
    @Override
    public Noodle createNoodle() {
        return new ChinaNoodle();
    }
}
