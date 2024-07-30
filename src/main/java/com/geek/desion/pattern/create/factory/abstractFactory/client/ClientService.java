package com.geek.desion.pattern.create.factory.abstractFactory.client;

import com.geek.desion.pattern.create.factory.abstractFactory.ChinaNoodleFactory;
import com.geek.desion.pattern.create.factory.abstractFactory.NoodleFactory;
import com.geek.desion.pattern.create.factory.abstractFactory.product.Noodle;
import com.geek.desion.pattern.create.factory.abstractFactory.product.RiceNoodle;

public class ClientService {

    public static void main(String[] args) {
//        NoodleFactory factory = NoodleFactory.createFactory("China");
//        Noodle noodle = factory.makeNoodle();
//        noodle.make();
//
//        RiceNoodle riceNoodle = factory.makeRiceNoodle();
//        riceNoodle.makeRice();

        NoodleFactory factory = NoodleFactory.createFactory("Italy");
        Noodle noodle = factory.makeNoodle();
        noodle.make();

        RiceNoodle riceNoodle = factory.makeRiceNoodle();
        riceNoodle.makeRice();
    }

}
