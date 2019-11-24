package com.ajcentaur.designpattern.create.factory.simplefactory;

import com.ajcentaur.designpattern.create.factory.product.Circle;
import com.ajcentaur.designpattern.create.factory.product.Rectangle;
import com.ajcentaur.designpattern.create.factory.product.Shape;
import com.ajcentaur.designpattern.create.factory.product.Square;

public class ShapeFactory {

    public static Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        }else if (shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }else if (shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

}
