package com.geek.desion.pattern.create.factory.factoryMethod.service;

import com.geek.desion.pattern.create.factory.factoryMethod.ChinaNoodleFactory;
import com.geek.desion.pattern.create.factory.factoryMethod.ItalyNoodleFactory;
import com.geek.desion.pattern.create.factory.factoryMethod.NoodleFactory;

import java.util.Objects;

/**
 * 工厂中的工厂
 */
public class NoodleFactoryService {

    public static NoodleFactory createFactory(Integer number){
        if(Objects.isNull(number)){
            throw new IllegalArgumentException("缺失编号参数");
        }
        NoodleFactory factory = null;
        switch (number){
            case 1:
                factory = new ChinaNoodleFactory();
                break;
            case 2:
                factory = new ItalyNoodleFactory();
                break;
            default:
                throw new RuntimeException("无对应餐品");
        }
        return factory;
    }

}
