package ro.itschool.bankingsystem.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.itschool.bankingsystem.services.BankingService;

@Configuration
public class AppConfig {

    @Bean
    public String firstConfigString() {
        return "firstConfigString";
    }

    @Bean
    public String secondConfigString() {
        return "secondConfigString";
    }

    @Bean
    public BankingService firstBankingService() {
        return new BankingService("firstBankingService");
    }

    @Bean
    public BankingService secondBankingService() {
        return new BankingService("secondBankingService");
    }
}
