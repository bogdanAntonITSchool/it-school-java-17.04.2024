package ro.itschool.bankingsystem;

import external.MyBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ro.itschool.bankingsystem.services.BankingService;
import ro.itschool.bankingsystem.services.UserService;

@ComponentScan(basePackages = {"ro.itschool.bankingsystem", "external"})
@SpringBootApplication
public class BankingSystemApplication {

    // Injection using Autowired
    // @Autowired
	// private String firstConfigString;

    private final String firstConfigString;
    private final UserService userService;
    private final MyBean myBean;

    public BankingSystemApplication(String firstConfigString,
                                    UserService userService,
                                    MyBean myBean) {
        this.firstConfigString = firstConfigString;
        this.userService = userService;
        this.myBean = myBean;

        this.userService.createUserAccount();
    }


    public static void main(String[] args) {
		SpringApplication.run(BankingSystemApplication.class, args);
    }

}
