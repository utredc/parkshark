package be.wailsharks.parkshark.api.division;

import be.wailsharks.parkshark.api.TestRunApplication;
import be.wailsharks.parkshark.api.division.dto.CreateDivisionDto;
import be.wailsharks.parkshark.api.division.dto.DivisionDto;
import be.wailsharks.parkshark.domain.division.Division;
import be.wailsharks.parkshark.domain.division.DivisionRepository;
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

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestRunApplication.class)
class DivisionControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    DivisionRepository divisionRepository;

    private Division testDivision1, testDivision2;

    @BeforeEach
    void setUp() {
        divisionRepository.deleteAll();
    }

    @Test
    void getAllDivisions() {
        List<Division> divisionList = new ArrayList<>();
        testDivision1 = new Division("testDivision", "oldName", "directorName");
        testDivision2 = new Division("secondDivision", "olderName", "bossManName");
        divisionRepository.save(testDivision1);
        divisionRepository.save(testDivision2);
        divisionList =
                RestAssured
                        .given()
                        .accept(JSON)
                        .contentType(JSON)
                        .when()
                        .port(port)
                        .get("/divisions")
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.OK.value())
                        .extract()
                        .body()
                        .jsonPath()
                        .getList(".", Division.class);

        assertThat(divisionList.size()).isEqualTo(2);
        assertThat(divisionList).contains(testDivision1);
    }

    @Test
    void createBook_givenBookToCreate_thenTheNewlyCreatedBookIsSavedAndReturned() {
        CreateDivisionDto createDivisionDto = new CreateDivisionDto("createdDivision", "createdOriginalName",
                "createdTestDirector");

        DivisionDto divisionDto =
                RestAssured
                        .given()
//                        .auth().preemptive().basic("lib@digibooky.com", "iLoveLibraries")
                        .body(createDivisionDto)
                        .accept(JSON)
                        .contentType(JSON)
                        .when()
                        .port(port)
                        .post("/divisions")
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.CREATED.value())
                        .extract()
                        .as(DivisionDto.class);

        assertThat(divisionDto.id).isNotNull();
        assertThat(divisionDto.name).isEqualTo(createDivisionDto.name);
        assertThat(divisionDto.originalName).isEqualTo(createDivisionDto.originalName);
        assertThat(divisionDto.director).isEqualTo(createDivisionDto.director);
    }

}