package com.muzi.cola;

public class Fact<T>{

    String name;
    T value;


    public Fact(String name, T value) {
        this.name = name;
        this.value = value;
    }

    public Fact(T value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
