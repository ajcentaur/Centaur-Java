package com.geek.desion.pattern.create.factory.abstractFactory;

import com.geek.desion.pattern.create.factory.abstractFactory.product.Noodle;
import com.geek.desion.pattern.create.factory.abstractFactory.product.RiceNoodle;

public interface NoodleFactory {

    static NoodleFactory createFactory(String name){
        if(name.equalsIgnoreCase("China")){
            return new ChinaNoodleFactory();
        } else if(name.equalsIgnoreCase("Italy")){
            return new ItalyNoodleFactory();
        } else {
            throw new IllegalArgumentException("Invalid factory name!");
        }
    }

    Noodle makeNoodle();

    RiceNoodle makeRiceNoodle();

}
