package be.wailsharks.parkshark.api.parkinglot;

import be.wailsharks.parkshark.api.TestRunApplication;
import be.wailsharks.parkshark.api.division.dto.DivisionDto;
import be.wailsharks.parkshark.api.parkinglot.dto.CreateParkingLotDto;
import be.wailsharks.parkshark.api.parkinglot.dto.ParkingLotDto;
import be.wailsharks.parkshark.domain.common.*;
import be.wailsharks.parkshark.domain.division.Division;
import be.wailsharks.parkshark.domain.division.DivisionRepository;
import be.wailsharks.parkshark.domain.parkinglot.Category;
import be.wailsharks.parkshark.domain.parkinglot.ParkingLot;
import be.wailsharks.parkshark.domain.parkinglot.ParkingLotRepository;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestRunApplication.class)
class ParkingLotControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    DivisionRepository divisionRepository;

    @Autowired
    ContactPersonRepository contactPersonRepository;

    @Autowired
    CityRepository cityRepository;

    @Autowired
    ParkingLotRepository parkingLotRepository;

    @Autowired
    ParkingLotMapper parkingLotMapper;

    @BeforeEach
    void setUp() {

        divisionRepository.deleteAll();
        contactPersonRepository.deleteAll();
        cityRepository.deleteAll();
        parkingLotRepository.deleteAll();
    }

    @Test
    void getAllParkingLots() {
        List<ParkingLotDto> parkingLotList = new ArrayList<>();
        long cityId = cityRepository.save(new City("1000","Brussel")).getId();

        ContactPerson person2 = contactPersonRepository.save(new ContactPerson(
                new Name("the", "Boss")
                , "mail"
                , new Address("street", "number", cityId)
                , "mobil"
                , "phone"));
        Division division2 = divisionRepository.save(
                new Division("testdivision", null, "director"));


        ParkingLot parking1 = new ParkingLot(3.1,"one",300, person2, new Address("street", "number",cityId), Category.ABOVE_GROUND_BUILDING,division2);
        ParkingLot parking2 = new ParkingLot(6.1,"two",400, person2, new Address("street", "number",cityId), Category.ABOVE_GROUND_BUILDING,division2);

        parkingLotRepository.save(parking1);
        parkingLotRepository.save(parking2);

        parkingLotList =
                RestAssured
                        .given()
                        .accept(JSON)
                        .contentType(JSON)
                        .when()
                        .port(port)
                        .get(ParkingLotController.PARKING_LOT_CONTROLLER_RESOURCE_URL)
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.OK.value())
                        .extract()
                        .body()
                        .jsonPath()
                        .getList(".", ParkingLotDto.class);

        assertThat(parkingLotList.size()).isEqualTo(2);
        assertThat(parkingLotList).contains(parkingLotMapper.mapToParkingLotDto(parking1));
        assertThat(parkingLotList).contains(parkingLotMapper.mapToParkingLotDto(parking2));

    }

    @Test
    void createParkingLot() {
        long cityId = cityRepository.save(new City("1000","Brussel")).getId();

        long contactPersonId = contactPersonRepository.save(new ContactPerson(
                new Name("the", "Boss")
                , "mail"
                , new Address("street", "number", cityId)
                , "mobil"
                , "phone")).getId();
        long divisionId = divisionRepository.save(
                new Division("testdivision", null, "director")).getId();

        CreateParkingLotDto createParkingLotDto = new CreateParkingLotDto(3.5,"Name",300,contactPersonId,"street","number",cityId,Category.ABOVE_GROUND_BUILDING.toString(),divisionId);

        ParkingLotDto parkingLotDto =
                RestAssured
                        .given()
//                        .auth().preemptive().basic("lib@digibooky.com", "iLoveLibraries")
                        .body(createParkingLotDto)
                        .accept(JSON)
                        .contentType(JSON)
                        .when()
                        .port(port)
                        .post(ParkingLotController.PARKING_LOT_CONTROLLER_RESOURCE_URL)
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.CREATED.value())
                        .extract()
                        .as(ParkingLotDto.class);

        assertThat(parkingLotDto.id).isNotNull();
    }
}