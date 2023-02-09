package com.ajcentaur.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaTest {

    public static void main(String[] args){
//        ArrayList<Integer> a = new ArrayList<>(15);
//        System.out.println(a.size());
//        a.add(1);
//        System.out.println(a.size());
//        Collections.synchronizedList(a);
//        a.add(2);
//        System.out.println(a.size());
//        a.add(5,1);
//        a.set(5,1);
        double lon = 120.254046;
        double lat = 30.237788;
        Double[] a = new Double[]{120.251422,30.238501};
        Double[] a1 = new Double[]{120.253217,30.234206};
        Double[] a2 = new Double[]{120.250348,30.225197};
        Double[] a3 = new Double[]{120.193022,30.256562};
        List<Double[]> list = new ArrayList<>();
        list.add(a3);
        list.add(a);
        list.add(a1);
        list.add(a2);
        sortByDistance(lon,lat,list);
        for (Double[] doub : list) {
            System.out.println("经度：" + doub[0] + "，纬度：" + doub[1]);
        }
    }

    public static void sortByDistance(double lon1, double lat1, List<Double[]> list){
        list.sort((o1, o2) -> {
            double lon2 = o1[0];
            double lat2 = o1[1];
            double lon3 = o2[0];
            double lat3 = o2[1];
            double dis1 = getDistance(lon1, lat1, lon2, lat2);
            double dis2 = getDistance(lon1, lat1, lon3, lat3);
            return Double.compare(dis1,dis2);
        });
    }

    public static double getDistance(double lon1,double lat1,double lon2,double lat2){
        double x1 = lon1 * Math.PI/180;
        double x2 = lon2 * Math.PI/180;
        double y1 = lat1 * Math.PI/180;
        double y2 = lat2 * Math.PI/180;
        double R = 6371;
        double d = Math.acos(Math.sin(y1) * Math.sin(y2) + Math.cos(y1) * Math.cos(y2) * Math.cos(x2 - x1)) * R;
        return d;
    }

}
