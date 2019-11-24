package com.ajcentaur.designpattern.create.factory.normalfactory;

import com.ajcentaur.designpattern.create.factory.product.Shape;
import com.ajcentaur.designpattern.create.factory.product.Square;

public class SquareFactory implements Factory {

    @Override
    public Shape getShape() {
        return new Square();
    }

}
