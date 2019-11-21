package be.wailsharks.parkshark.api.allocation;

import be.wailsharks.parkshark.api.ControllerIntegrationTest;
import be.wailsharks.parkshark.api.allocation.dto.ParkingAllocationDto;
import be.wailsharks.parkshark.api.allocation.dto.StopParkingAllocationDto;
import be.wailsharks.parkshark.domain.allocation.ParkingAllocation;
import be.wailsharks.parkshark.domain.allocation.Status;
import be.wailsharks.parkshark.domain.common.Address;
import be.wailsharks.parkshark.domain.common.ContactPerson;
import be.wailsharks.parkshark.domain.common.LicensePlate;
import be.wailsharks.parkshark.domain.common.Name;
import be.wailsharks.parkshark.domain.division.Division;
import be.wailsharks.parkshark.domain.members.Member;
import be.wailsharks.parkshark.domain.members.MembershipLevel;
import be.wailsharks.parkshark.domain.parkinglot.Category;
import be.wailsharks.parkshark.domain.parkinglot.ParkingLot;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static io.restassured.http.ContentType.JSON;

class ParkingAllocationControllerTest extends ControllerIntegrationTest {


    @Test
    void stopWorks() {
        Address address = new Address("asd", "5", 1);
        Division testDivision1 = new Division("testDivision", "oldName", "directorName");
        Member member = new Member(new Name("s", "s"), new LicensePlate("sad", "BE"), "456", "asd", address,
                MembershipLevel.GOLD);
        memberRepository.save(member);

        ContactPerson contactPerson = new ContactPerson(
                new Name("the", "Boss")
                , "mail"
                , address
                , "mobil"
                , "phone");
        contactPersonRepository.save(contactPerson);

        ParkingLot parkingLot = new ParkingLot(10, "asd", 20, contactPerson
                , address, Category.ABOVE_GROUND_BUILDING, testDivision1);
        ParkingAllocation parkingAllocation = new ParkingAllocation(member, "sad", parkingLot);

        StopParkingAllocationDto stopParkingAllocationDto = new StopParkingAllocationDto("1", "1");

        divisionRepository.save(testDivision1);
        parkingLotRepository.save(parkingLot);
        parkingAllocationRepository.save(parkingAllocation);

        ParkingAllocationDto parkingAllocationDto =
                RestAssured
                        .given()
                        .body(stopParkingAllocationDto)
                        .accept(JSON)
                        .contentType(JSON)
                        .when()
                        .port(port)
                        .put("/allocation")
                        .then()
                        .assertThat()
                        .statusCode(HttpStatus.ACCEPTED.value())
                        .extract()
                        .as(ParkingAllocationDto.class);

        Assertions.assertThat(parkingAllocationDto.getStatus()).isEqualTo("STOPPED");
        Assertions.assertThat(parkingAllocationRepository.findById(parkingAllocationDto.getId()).get().getStatus())
                .isEqualByComparingTo(Status.STOPPED);

    }
}