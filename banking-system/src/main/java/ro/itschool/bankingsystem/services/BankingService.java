package ro.itschool.bankingsystem.services;

import org.springframework.stereotype.Service;
import ro.itschool.bankingsystem.annotations.TestAnnotation;


public class BankingService {

    @TestAnnotation
    private final String name;

    @TestAnnotation
    public BankingService(String name) {
        this.name = name;
    }

    @TestAnnotation
    public void createAccountForUser(String user) {
        System.out.println("Account created using " + name + " for user: " + user );
    }
}
