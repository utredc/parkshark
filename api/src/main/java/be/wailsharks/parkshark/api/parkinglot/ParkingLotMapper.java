package be.wailsharks.parkshark.api.parkinglot;

import be.wailsharks.parkshark.api.common.ContactPersonMapper;
import be.wailsharks.parkshark.api.division.DivisionMapper;
import be.wailsharks.parkshark.api.parkinglot.dto.CreateParkingLotDto;
import be.wailsharks.parkshark.api.parkinglot.dto.ParkingLotDto;
import be.wailsharks.parkshark.domain.common.Address;
import be.wailsharks.parkshark.domain.parkinglot.Category;
import be.wailsharks.parkshark.domain.parkinglot.ParkingLot;
import be.wailsharks.parkshark.service.CityService;
import be.wailsharks.parkshark.service.common.ContactPersonService;
import be.wailsharks.parkshark.service.division.DivisionService;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotMapper {

    private ContactPersonMapper contactPersonMapper;
    private CityService cityService;
    private ContactPersonService contactPersonService;
    private DivisionService divisionService;

    public ParkingLotMapper(ContactPersonMapper contactPersonMapper, CityService cityService, ContactPersonService contactPersonService, DivisionService divisionService) {
        this.contactPersonMapper = contactPersonMapper;
        this.cityService = cityService;
        this.contactPersonService = contactPersonService;
        this.divisionService = divisionService;
    }

    ParkingLot mapToDomain(CreateParkingLotDto createParkingLotDto) {
        return new ParkingLot(createParkingLotDto.getPricePerHour(),
                createParkingLotDto.getName(),
                createParkingLotDto.getMaxCapacity(),
                contactPersonService.getById(createParkingLotDto.getContactPersonId()),
                new Address(createParkingLotDto.getStreetName(),createParkingLotDto.getHouseNumber(), createParkingLotDto.getCityID()),
                Category.valueOf(createParkingLotDto.getCategory().toUpperCase()),
                divisionService.getDivisionById(createParkingLotDto.getDivisionId()));
    }

    ParkingLotDto mapToParkingLotDto(ParkingLot parkinglot) {
        return new ParkingLotDto()
                .setId(parkinglot.getId())
                .setPricePerHour(parkinglot.getPricePerHour())
                .setName(parkinglot.getName())
                .setMaxCapacity(parkinglot.getMaxCapacity())
                .setContactPersonDto(contactPersonMapper
                        .mapToContactPersonDto(parkinglot.getContactPerson()))
                .setStreetName(parkinglot.getAddress().getStreetName())
                .setHouseNumber(parkinglot.getAddress().getHouseNumber())
                .setPostalCode(cityService
                        .getCityByID(parkinglot
                                .getAddress()
                                .getCityId())
                        .getPostalCode())
                .setCityName(cityService
                        .getCityByID(parkinglot
                                .getAddress()
                                .getCityId())
                        .getCityName())
                .setCategory(parkinglot.getCategory().toString())
                .setDivisionDto(DivisionMapper.mapToDivisionDto(parkinglot.getDivision()))
                ;
    }
}
