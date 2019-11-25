package com.ajcentaur.designpattern.structure.garnisher;

public class DecoratorTest {

    public static void main(String[] args){
        People p1 = new DecoratorShoes(new DecoratorPants(new DecoratorShirt(new Jane())));
        p1.wear();

        People p2 = new DecoratorShoes(new DecoratorPants(new DecoratorSuit(new Jane())));
        p2.wear();

        //如果在装饰者中定义了新的行为，则为半透明装饰者模式，对应的标准模式称为透明装饰者模式
        People p3 = new DecoratorShirt(new Jane());
        p3.wear();
        //调用超类没有的方法时需要进行向下转型
        ((DecoratorShirt)p3).eat();

    }

}
