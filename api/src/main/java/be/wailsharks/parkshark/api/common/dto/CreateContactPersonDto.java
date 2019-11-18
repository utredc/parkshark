package be.wailsharks.parkshark.api.common.dto;

public class CreateContactPersonDto {
    public String lastName;
    public String firstName;
    public String Email;
    public String streetName;
    public String streetNumber;
    public String postalCode;
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

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
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
