package com.ajcentaur.test;

import java.util.ArrayList;
import java.util.Collections;

public class JavaTest {

    public static void main(String[] args){
        ArrayList<Integer> a = new ArrayList<>(15);
        System.out.println(a.size());
        a.add(1);
        System.out.println(a.size());
        Collections.synchronizedList(a);
        a.add(2);
        System.out.println(a.size());

//        a.add(5,1);
//        a.set(5,1);
    }

}
