package be.wailsharks.parkshark.api.members.dto;

public class BasicMemberInfoDto {

    private String firstName;
    private String lastName;
    private String licensePlateNr;
    private String telephoneNr;
    private String emailAddress;
    private String registrationDate;
    private long id;

    public static BasicMemberInfoDto BasicMemberInfoDto() {
        return new BasicMemberInfoDto();
    }

    public BasicMemberInfoDto setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public BasicMemberInfoDto setId(long id) {
        this.id = id;
        return this;
    }

    public BasicMemberInfoDto setLicensePlateNr(String licensePlateNr) {
        this.licensePlateNr = licensePlateNr;
        return this;
    }

    public BasicMemberInfoDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public BasicMemberInfoDto setTelephoneNr(String telephoneNr) {
        this.telephoneNr = telephoneNr;
        return this;
    }

    public BasicMemberInfoDto setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public BasicMemberInfoDto setRegistrationDate(String registrationDate) {
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
