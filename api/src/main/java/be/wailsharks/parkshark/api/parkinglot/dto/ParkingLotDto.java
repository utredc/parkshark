package be.wailsharks.parkshark.api.parkinglot.dto;

import be.wailsharks.parkshark.api.common.dto.ContactPersonDto;
import be.wailsharks.parkshark.api.division.dto.DivisionDto;


public class ParkingLotDto {
    public long id;
    public double pricePerHour;
    public String name;
    public int maxCapacity;
    public ContactPersonDto contactPersonDto;
    public String streetName;
    public String houseNumber;
    public String postalCode;
    public String city;
    public String category;
    public DivisionDto divisionDto;

    public String getPostalCode() {
        return postalCode;
    }

    public ParkingLotDto setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ParkingLotDto setCityName(String city) {
        this.city = city;
        return this;
    }

    public long getId() {
        return id;
    }

    public ParkingLotDto setId(long id) {
        this.id = id;
        return this;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public ParkingLotDto setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
        return this;
    }

    public String getName() {
        return name;
    }

    public ParkingLotDto setName(String name) {
        this.name = name;
        return this;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public ParkingLotDto setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        return this;
    }

    public ContactPersonDto getContactPersonDto() {
        return contactPersonDto;
    }

    public ParkingLotDto setContactPersonDto(ContactPersonDto contactPersonDto) {
        this.contactPersonDto = contactPersonDto;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public ParkingLotDto setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public ParkingLotDto setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ParkingLotDto setCategory(String category) {
        this.category = category;
        return this;
    }

    public DivisionDto getDivisionDto() {
        return divisionDto;
    }

    public ParkingLotDto setDivisionDto(DivisionDto divisionDto) {
        this.divisionDto = divisionDto;
        return this;
    }
}
