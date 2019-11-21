package be.wailsharks.parkshark.api;


import be.wailsharks.parkshark.api.parkinglot.ParkingLotMapper;
import be.wailsharks.parkshark.domain.allocation.ParkingAllocationRepository;
import be.wailsharks.parkshark.domain.common.CityRepository;
import be.wailsharks.parkshark.domain.common.ContactPersonRepository;
import be.wailsharks.parkshark.domain.division.DivisionRepository;
import be.wailsharks.parkshark.domain.members.MemberRepository;
import be.wailsharks.parkshark.domain.parkinglot.ParkingLotRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestRunApplication.class)
public abstract class ControllerIntegrationTest {

    @LocalServerPort
    public int port;

    @Autowired
    public DivisionRepository divisionRepository;

    @Autowired
    public ContactPersonRepository contactPersonRepository;

    @Autowired
    public CityRepository cityRepository;

    @Autowired
    public ParkingLotRepository parkingLotRepository;

    @Autowired
    public ParkingLotMapper parkingLotMapper;

    @Autowired
    public ParkingAllocationRepository parkingAllocationRepository;

    @Autowired
    public MemberRepository memberRepository;

    @BeforeEach
    void setUp() {

        parkingLotRepository.deleteAll();
        divisionRepository.deleteAll();
        contactPersonRepository.deleteAll();
        cityRepository.deleteAll();
    }
}
