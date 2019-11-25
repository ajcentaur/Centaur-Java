package com.ajcentaur.designpattern.structure.garnisher;

public class Decorator implements People {
    private People people;

    public Decorator(People people) {
        this.people = people;
    }

    @Override
    public void wear() {
        people.wear();
    }

    public void eat(){ }
}
