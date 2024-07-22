package com.geek.desion.pattern.create.factory.simpleFactory;

public class NoodleFactory {

    public static Noodle createNoodle(Integer number){
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
        return noodle;
    }

}
