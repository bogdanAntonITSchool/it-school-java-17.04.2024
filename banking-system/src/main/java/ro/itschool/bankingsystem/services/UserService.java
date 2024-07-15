package ro.itschool.bankingsystem.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
// @RequiredArgsConstructor
public class UserService {

    // @Qualifier("firstBankingService")
    private final BankingService bankingService;

    public UserService(@Qualifier("firstBankingService") BankingService bankingService) {
        this.bankingService = bankingService;
    }

    public void createUserAccount() {
        System.out.println("User account created");

        bankingService.createAccountForUser("user");
    }
}
