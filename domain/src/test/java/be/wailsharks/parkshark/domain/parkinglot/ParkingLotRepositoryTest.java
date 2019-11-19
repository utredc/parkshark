package be.wailsharks.parkshark.domain.parkinglot;

import be.wailsharks.parkshark.domain.common.Address;
import be.wailsharks.parkshark.domain.common.ContactPerson;
import be.wailsharks.parkshark.domain.common.ContactPersonRepository;
import be.wailsharks.parkshark.domain.common.Name;
import be.wailsharks.parkshark.domain.division.Division;
import be.wailsharks.parkshark.domain.division.DivisionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
class ParkingLotRepositoryTest {
    private ParkingLotRepository parkingLotRepository;
    private ContactPersonRepository contactPersonRepository;
    private DivisionRepository divisionRepository;

    @Autowired
    public ParkingLotRepositoryTest(ParkingLotRepository parkingLotRepository, ContactPersonRepository contactPersonRepository, DivisionRepository divisionRepository) {
        this.parkingLotRepository = parkingLotRepository;
        this.contactPersonRepository = contactPersonRepository;
        this.divisionRepository = divisionRepository;
    }

    @Test
    void whenAddParkingLotTheParkingLotIsInRepo() {
        ContactPerson contact = new ContactPerson(new Name("mr","Boss"),"My@bossy.com",new Address(),"555", null);
        Division division = new Division("The One",null,"The Boss");
        contactPersonRepository.save(contact);
        divisionRepository.save(division);
        ParkingLot parkingLot = new ParkingLot(3.00, "TestPark", 200, contact, new Address(), Category.ABOVE_GROUND_BUILDING, division);
        ParkingLot savedParkingLot = parkingLotRepository.save(parkingLot);

        Assertions.assertThat(savedParkingLot).isEqualTo(parkingLot);
        Assertions.assertThat(parkingLotRepository.findAll()).contains(parkingLot);
    }
}