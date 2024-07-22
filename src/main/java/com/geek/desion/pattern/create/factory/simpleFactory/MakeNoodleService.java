package com.geek.desion.pattern.create.factory.simpleFactory;

import java.util.Objects;

public class MakeNoodleService {

    public void make(Integer number){
        if(Objects.isNull(number)){
            throw new IllegalArgumentException("缺失编号参数");
        }
        Noodle noodle = NoodleFactory.createNoodle(number);
        noodle.make();
        noodle.printReceipt();
    }

}
