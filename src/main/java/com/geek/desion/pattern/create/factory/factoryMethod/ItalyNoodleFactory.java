package com.geek.desion.pattern.create.factory.factoryMethod;

import com.geek.desion.pattern.create.factory.factoryMethod.model.ItalyNoodle;
import com.geek.desion.pattern.create.factory.factoryMethod.model.Noodle;

public class ItalyNoodleFactory implements NoodleFactory{
    @Override
    public Noodle createNoodle() {
        return new ItalyNoodle();
    }
}
