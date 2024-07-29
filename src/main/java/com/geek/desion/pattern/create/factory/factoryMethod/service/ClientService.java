package com.geek.desion.pattern.create.factory.factoryMethod.service;

import com.geek.desion.pattern.create.factory.factoryMethod.NoodleFactory;

public class ClientService {

    public static void main(String[] args) {
        NoodleFactory factory = NoodleFactoryService.createFactory(1);
        factory.createNoodle().printReceipt();

        NoodleFactory factory2 = NoodleFactoryService.createFactory(2);
        factory2.createNoodle().printReceipt();
    }

}
