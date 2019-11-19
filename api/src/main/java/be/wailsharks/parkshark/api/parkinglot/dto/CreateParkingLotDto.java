package be.wailsharks.parkshark.api.parkinglot.dto;


public class CreateParkingLotDto {
    public double pricePerHour;
    public String name;
    public int maxCapacity;
    public long contactPersonId;
    public String streetName;
    public String houseNumber;
    public long cityID;
    public String category;
    public long divisionId;

    public double getPricePerHour() {
        return pricePerHour;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public long getContactPersonId() {
        return contactPersonId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }{}

    public long getCityID() {
        return cityID;
    }

    public String getCategory() {
        return category;
    }

    public long getDivisionId() {
        return divisionId;
    }

    public CreateParkingLotDto(double pricePerHour, String name, int maxCapacity, long contactPersonId, String streetName, String houseNumber, long cityID, String category, long divisionId) {
        this.pricePerHour = pricePerHour;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.contactPersonId = contactPersonId;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.cityID = cityID;
        this.category = category;
        this.divisionId = divisionId;
    }

    public CreateParkingLotDto(){}
}
