package be.wailsharks.parkshark.war;


import be.wailsharks.parkshark.api.division.DivisionController;
import be.wailsharks.parkshark.api.division.dto.CreateDivisionDto;
import be.wailsharks.parkshark.api.division.dto.DivisionDto;
import be.wailsharks.parkshark.domain.common.City;
import be.wailsharks.parkshark.domain.common.CityRepository;
import be.wailsharks.parkshark.domain.division.Division;
import be.wailsharks.parkshark.domain.division.DivisionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger log = LoggerFactory.getLogger(Sharkparkapp.class);

    public static void main(String[] args) {
        SpringApplication.run(Sharkparkapp.class, args);
    }

//    @Bean
//    @Profile(value = "dev")
//    public CommandLineRunner loadData(DivisionRepository divisionRepository) {
//        return (args) -> {
//            // save a couple of customers
//            divisionRepository.save(new Division("Bob Industier","","Bob The Builder"));
//            divisionRepository.save(new Division("Andy's Party Poopers","Buff Build Boys","Andy Landlord"));
////
////
////            // fetch all customers
////            log.info("Divisions found with findAll():");
////            log.info("-------------------------------");
////            for (DivisionDto division : divisionController.getAllDivisions()) {
////                log.info(division.toString());
////            }
////            log.info("");
////
//////            // fetch an individual division by ID
////////            DivisionDto division = divisionController.findById(1L).get();
//////            DivisionDto division = divisionController.;
//////            log.info("Division found with findOne(1L):");
//////            log.info("--------------------------------");
//////            log.info(division.toString());
//////            log.info("");
//////
//////            // fetch customers by last name
//////            log.info("Division found with findByLastNameStartsWithIgnoreCase('Bauer'):");
//////            log.info("--------------------------------------------");
//////            for (Division bauer : divisionController
//////                    .findByLastNameStartsWithIgnoreCase("Bauer")) {
//////                log.info(bauer.toString());
//////            }
////            log.info("");
//        };
//    }
}

