package vn.test.accountmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountManagerApplication.class, args);
        System.out.println("==================================================");
        System.out.println("Server running on port 8081");
        System.out.println("Swagger UI: /swagger-ui.html");
        System.out.println("==================================================");
    }
}