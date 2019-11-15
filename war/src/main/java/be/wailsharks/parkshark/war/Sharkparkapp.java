package be.wailsharks.parkshark.war;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "be.wailsharks.parkshark")
public class Sharkparkapp {

    public static void main(String[] args) {
        SpringApplication.run(Sharkparkapp.class, args);
    }
}
