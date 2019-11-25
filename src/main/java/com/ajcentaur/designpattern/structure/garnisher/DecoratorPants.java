package com.ajcentaur.designpattern.structure.garnisher;

public class DecoratorPants extends Decorator {

    public DecoratorPants(People people) {
        super(people);
    }

    @Override
    public void wear() {
        super.wear();
        System.out.println("穿条裤子！");
    }
}
