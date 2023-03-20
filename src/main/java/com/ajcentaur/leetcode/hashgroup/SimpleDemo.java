package com.ajcentaur.leetcode.hashgroup;

import java.util.HashSet;
import java.util.Set;

/**
 * @author luocb
 * @version 1.0
 * @description: TODO
 * @date 2023/3/20 18:07
 */
public class SimpleDemo {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    /**
     * leetcode:202
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    private static int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
}
