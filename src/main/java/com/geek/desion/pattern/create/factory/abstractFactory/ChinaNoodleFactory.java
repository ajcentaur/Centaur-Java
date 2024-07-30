package com.geek.desion.pattern.create.factory.abstractFactory;

import com.geek.desion.pattern.create.factory.abstractFactory.product.ChinaNoodle;
import com.geek.desion.pattern.create.factory.abstractFactory.product.ChinaRiceNoodle;
import com.geek.desion.pattern.create.factory.abstractFactory.product.Noodle;
import com.geek.desion.pattern.create.factory.abstractFactory.product.RiceNoodle;

public class ChinaNoodleFactory implements NoodleFactory{

    @Override
    public Noodle makeNoodle() {
        return new ChinaNoodle();
    }

    @Override
    public RiceNoodle makeRiceNoodle() {
        return new ChinaRiceNoodle();
    }
}
