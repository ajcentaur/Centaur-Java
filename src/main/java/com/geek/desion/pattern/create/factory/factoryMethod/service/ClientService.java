package com.geek.desion.pattern.create.factory.factoryMethod.service;

import com.geek.desion.pattern.create.factory.factoryMethod.ChinaNoodleFactory;
import com.geek.desion.pattern.create.factory.factoryMethod.NoodleFactory;
import com.geek.desion.pattern.create.factory.factoryMethod.model.Noodle;

public class ClientService {

    public static void main(String[] args) {
        NoodleFactory factory = new ChinaNoodleFactory();
        Noodle noodle = factory.createNoodle();
        noodle.printReceipt();
    }

}
