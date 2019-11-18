package be.wailsharks.parkshark.war;


import be.wailsharks.parkshark.domain.common.City;
import be.wailsharks.parkshark.domain.common.CityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "be.wailsharks.parkshark")
@EnableJpaRepositories(basePackages = "be.wailsharks.parkshark.domain")
@EntityScan(basePackages = "be.wailsharks.parkshark.domain")
public class Sharkparkapp {

    public static void main(String[] args) {
        SpringApplication.run(Sharkparkapp.class, args);
    }

}

