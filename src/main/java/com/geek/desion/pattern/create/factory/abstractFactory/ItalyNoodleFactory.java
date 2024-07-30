package com.geek.desion.pattern.create.factory.abstractFactory;

import com.geek.desion.pattern.create.factory.abstractFactory.product.ItalyNoodle;
import com.geek.desion.pattern.create.factory.abstractFactory.product.ItalyRiceNoodle;
import com.geek.desion.pattern.create.factory.abstractFactory.product.Noodle;
import com.geek.desion.pattern.create.factory.abstractFactory.product.RiceNoodle;

public class ItalyNoodleFactory implements NoodleFactory{

    @Override
    public Noodle makeNoodle() {
        return new ItalyNoodle();
    }

    @Override
    public RiceNoodle makeRiceNoodle() {
        return new ItalyRiceNoodle();
    }
}
