package be.wailsharks.parkshark.api.members.dto;


import java.time.LocalDate;

public class MemberDto {

    private String firstName;
    private String lastName;
    private String licensePlateNr;
    private String licensePlateCountry;
    private String telephoneNr;
    private String emailAddress;
    private String registrationDate;
    private long id;


    public static MemberDto MemberDto() {
        return new MemberDto();
    }

    public MemberDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public MemberDto setId(long id) {
        this.id = id;
        return this;
    }

    public MemberDto setLicensePlateNr(String licensePlateNr) {
        this.licensePlateNr = licensePlateNr;
        return this;
    }

    public MemberDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public MemberDto setLicensePlateCountry(String licensePlateCountry) {
        this.licensePlateCountry = licensePlateCountry;
        return this;
    }

    public MemberDto setTelephoneNr(String telephoneNr) {
        this.telephoneNr = telephoneNr;
        return this;
    }

    public MemberDto setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public MemberDto setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLicensePlateNr() {
        return licensePlateNr;
    }

    public String getLicensePlateCountry() {
        return licensePlateCountry;
    }

    public String getTelephoneNr() {
        return telephoneNr;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public long getId() {
        return id;
    }
}
