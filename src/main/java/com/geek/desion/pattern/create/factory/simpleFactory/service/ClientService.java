package com.geek.desion.pattern.create.factory.simpleFactory.service;

public class ClientService {

    public static void main(String[] args) {
        MakeNoodleService makeNoodleService = new MakeNoodleService();
        makeNoodleService.make(1);
        makeNoodleService.make(2);
    }

}
