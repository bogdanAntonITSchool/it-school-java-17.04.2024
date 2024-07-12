package com.example.demo.beans;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("lastBean")
public class FirstBean {

    private String name;
    private int age;
}
