package com.ajcentaur.basics.serialization;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 233L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
