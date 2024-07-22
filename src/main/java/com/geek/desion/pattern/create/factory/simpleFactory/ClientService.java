package com.geek.desion.pattern.create.factory.simpleFactory;

public class ClientService {

    public static void main(String[] args) {
        MakeNoodleFactory factory = new MakeNoodleFactory();
        factory.make(1);
        factory.make(2);
    }

}
