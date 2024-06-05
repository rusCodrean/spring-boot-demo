package com.garmin.springbootdemo.api;

public class Student {

    private String name;
    private Integer age;
    private Double averageGpa;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getAverageGpa() {
        return averageGpa;
    }

    public void setAverageGpa(Double averageGpa) {
        this.averageGpa = averageGpa;
    }
}
