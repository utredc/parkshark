package be.wailsharks.parkshark.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "be.wailsharks.parkshark")
//@EnableJpaRepositories(basePackages = "be.wailsharks.parkshark.domain")
//@EntityScan(basePackages = "be.wailsharks.parkshark.domain")
public class TestRunApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestRunApplication.class, args);
    }
}
