package com.ajcentaur.designpattern.create.factory.normalfactory;

import com.ajcentaur.designpattern.create.factory.product.Circle;
import com.ajcentaur.designpattern.create.factory.product.Shape;

public class CircleFactory implements Factory {

    @Override
    public Shape getShape() {
        return new Circle();
    }

}
