package com.example.kafkademo.listener;

import lombok.Getter;

@Getter
public class Person {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }
}
