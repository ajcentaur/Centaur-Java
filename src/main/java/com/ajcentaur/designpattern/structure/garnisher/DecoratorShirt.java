package com.ajcentaur.designpattern.structure.garnisher;

public class DecoratorShirt extends Decorator {

    public DecoratorShirt(People people) {
        super(people);
    }

    @Override
    public void wear(){
        super.wear();
        System.out.println("穿件衬衫！");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("衬衫-去吃大餐");
    }
}
