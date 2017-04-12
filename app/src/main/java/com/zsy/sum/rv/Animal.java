package com.zsy.sum.rv;

/**
 * Created by mzs on 2017/4/11.
 */

public class Animal {

    private String type;
    private String color;

    public Animal() {
    }

    public Animal(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
