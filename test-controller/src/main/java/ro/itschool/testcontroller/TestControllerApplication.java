package ro.itschool.testcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestControllerApplication.class, args);

        String table = "users";
        String column = "name";
        String value = "'x'; DROP TABLE users;";

        String sql = "SELECT FROM " + table + " WHERE " + column + " = " + value;
    }

}
