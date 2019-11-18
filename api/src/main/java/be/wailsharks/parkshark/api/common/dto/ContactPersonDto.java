package be.wailsharks.parkshark.api.common.dto;

public class ContactPersonDto {
    public long id;
    public String lastName;
    public String firstName;
    public String email;
    public String streetName;
    public String streetNumber;
    public String postalCode;
    public String city;
    public String mobileNr;
    public String phoneNr;

    public long getId() {
        return id;
    }

    public ContactPersonDto setId(long id) {
        this.id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public ContactPersonDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public ContactPersonDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ContactPersonDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public ContactPersonDto setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public ContactPersonDto setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public ContactPersonDto setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public ContactPersonDto setCity(String city) {
        this.city = city;
        return this;
    }

    public String getMobileNr() {
        return mobileNr;
    }

    public ContactPersonDto setMobileNr(String mobileNr) {
        this.mobileNr = mobileNr;
        return this;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public ContactPersonDto setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
        return this;
    }
}
