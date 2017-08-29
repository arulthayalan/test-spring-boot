package com.example.parser;

/**
 * Created by p711679 on 13/10/2015.
 */
public class ParserModel {
    private String name;

    private int age;

    public ParserModel() {
    }

   /* public ParserModel(String name, int age) {
        this.name = name;
        this.age = age;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
