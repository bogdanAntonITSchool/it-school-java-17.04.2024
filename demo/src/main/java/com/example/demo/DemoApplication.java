package com.example.demo;

import com.example.demo.beans.FirstBean;
import com.example.demo.beans.SecondBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        // Get beans from context
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        FirstBean firstBean = (FirstBean) context.getBean("lastBean");
        SecondBean secondBean = (SecondBean) context.getBean("secondBean");

        System.out.println(firstBean.getName());
        System.out.println(secondBean);
    }

}
