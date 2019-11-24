package com.ajcentaur.designpattern.create.factory.simplefactory;

import com.ajcentaur.designpattern.create.factory.product.Circle;
import com.ajcentaur.designpattern.create.factory.product.Rectangle;
import com.ajcentaur.designpattern.create.factory.product.Square;

public class Test2 {

    public static void main(String[] args){
        Circle circle = (Circle) ShapeFactory2.getShape(Circle.class);
        circle.draw();

        Rectangle rectangle = (Rectangle) ShapeFactory2.getShape(Rectangle.class);
        rectangle.draw();

        Square square = (Square) ShapeFactory2.getShape(Square.class);
        square.draw();
    }

}
