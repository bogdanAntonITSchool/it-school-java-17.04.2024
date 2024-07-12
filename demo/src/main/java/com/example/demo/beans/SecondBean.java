package com.example.demo.beans;

import org.springframework.stereotype.Component;

@Component
public class SecondBean {

    private final FirstBean firstBean;

    public SecondBean(FirstBean firstBean) {
        this.firstBean = firstBean;
    }
}
