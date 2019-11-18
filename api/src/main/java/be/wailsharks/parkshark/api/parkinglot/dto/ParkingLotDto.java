package be.wailsharks.parkshark.api.parkinglot.dto;

import be.wailsharks.parkshark.api.common.dto.ContactPersonDto;
import be.wailsharks.parkshark.api.division.dto.DivisionDto;


public class ParkingLotDto {
    public long id;
    public double pricePerHour;
    public String name;
    public int maxCapacity;
    public ContactPersonDto contactPerson;
    public AddressDto address;
    public String category;
    public DivisionDto divisionDto;
}
