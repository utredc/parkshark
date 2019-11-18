package be.wailsharks.parkshark.api.parkinglot.dto;


public class CreateParkingLotDto {
    public double pricePerHour;
    public String name;
    public int maxCapacity;
    public int contactPersonId;
    public String streetName;
    public String houseNumber;
    public int cityID;
    public String category;
    public int divisionId;

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

    public int getContactPersonId() {
        return contactPersonId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }{}

    public int getCityID() {
        return cityID;
    }

    public String getCategory() {
        return category;
    }

    public int getDivisionId() {
        return divisionId;
    }
}
