package com.geek.desion.pattern.create.factory.simpleFactory;

import java.util.Objects;

public class MakeNoodleFactory {

    public void make(Integer number){
        if(Objects.isNull(number)){
            throw new IllegalArgumentException("缺失编号参数");
        }
        Noodle noodle = null;
        switch (number){
            case 1:
                noodle = new ChinaNoodle();
                break;
            case 2:
                noodle = new ItalyNoodle();
                break;
            default:
                throw new RuntimeException("无对应餐品");
        }
        noodle.make();
        noodle.printReceipt();
    }

}
