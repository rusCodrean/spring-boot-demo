package com.garmin.springbootdemo.api;

public abstract class Shape {
    public abstract void render();

    public void area() {
        System.out.println("General shape area");
    }
}
