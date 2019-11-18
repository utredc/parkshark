package be.wailsharks.parkshark.api.common.dto;

public class CreateContactPersonDto {
    public String lastName;
    public String firstName;
    public String Email;
    public String streetName;
    public String houseNumber;
    public int cityID;
    public String mobileNr;
    public String phoneNr;

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return Email;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public int getCityID() {
        return cityID;
    }

    public String getMobileNr() {
        return mobileNr;
    }

    public String getPhoneNr() {
        return phoneNr;
    }
}
