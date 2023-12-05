package com.ajcentaur.basics.generics;

public class GenericsDemo {

    public static void main(String[] args) {
        Example<String,Integer,String> example = new Example<>();
        example.setA("wwww");
        example.setB(555);
        System.out.println(example.getA());
        Example<Integer,Integer,String> example2 = new Example<>();
        example2.setA(5);
        example2.setB(5);
        example2.setC("");
        System.out.println(example2.getA().intValue());
    }

}
