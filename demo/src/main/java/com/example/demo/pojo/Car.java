package com.example.demo.pojo;

import java.io.Serializable;

// POJO class
public class Car {

    private String brand;
    private String model;

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
}

// Java Bean
class CarBean implements Serializable {

    private String brand;
    private String model;

    public CarBean() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
