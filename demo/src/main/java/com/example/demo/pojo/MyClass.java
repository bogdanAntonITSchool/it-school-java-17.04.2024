package com.example.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class MyClass {

    private String name;
    private int age;

    private void method() {
        MyClass myClass = new MyClass("name", 1);

    }
}
