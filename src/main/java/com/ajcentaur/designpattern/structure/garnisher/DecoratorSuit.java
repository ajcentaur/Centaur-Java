package com.ajcentaur.designpattern.structure.garnisher;

public class DecoratorSuit extends Decorator {

    public DecoratorSuit(People people) {
        super(people);
    }

    @Override
    public void wear() {
        super.wear();
        System.out.println("穿件西服！");
    }
}
