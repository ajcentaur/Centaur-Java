package com.ajcentaur.basics.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDemo {

    public static void main(String[] args) throws Exception {
        serializeObject();

        deserializeObject();
    }

    private static void serializeObject() throws Exception {
        User user = new User();
        user.setName("小明");
        System.out.println(user);
        System.out.println("=================开始序列化================");
        FileOutputStream fileOutputStream = new FileOutputStream("object.log");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
        outputStream.writeObject(user);
        outputStream.flush();
        outputStream.close();
    }

    public static void deserializeObject() throws Exception{
        System.out.println("=================开始反序列化================");
        FileInputStream fileInputStream = new FileInputStream("object.log");
        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        User user = (User) inputStream.readObject();
        inputStream.close();
        System.out.println(user);
    }

}
