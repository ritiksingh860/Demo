package com.example.wrapper.dataset;

public class NewColName{
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NewColName{" +
                "name='" + name + '\'' +
                '}';
    }
}
