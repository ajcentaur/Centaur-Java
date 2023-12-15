package com.ajcentaur.juc.thread;

import java.util.Scanner;

public class Thread2Demo {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String inputStr = scanner.nextLine();
            ThreadDemo.singleThread(inputStr);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
