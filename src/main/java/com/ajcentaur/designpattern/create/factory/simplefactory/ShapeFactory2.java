package com.ajcentaur.designpattern.create.factory.simplefactory;

import com.ajcentaur.designpattern.create.factory.product.Shape;

/**
 * 使用反射机制改良版,新增产品不需要修改工厂类
 */
public class ShapeFactory2 {

    public static Object getShape(Class<? extends Shape> clazz){
        Object obj = null;

        try {
            obj = Class.forName(clazz.getName()).newInstance();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        return obj;
    }

}
