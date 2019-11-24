package com.ajcentaur.designpattern.create.factory.normalfactory;

import com.ajcentaur.designpattern.create.factory.product.Rectangle;
import com.ajcentaur.designpattern.create.factory.product.Shape;

public class RectangleFactory implements Factory {

    @Override
    public Shape getShape() {
        return new Rectangle();
    }

}
