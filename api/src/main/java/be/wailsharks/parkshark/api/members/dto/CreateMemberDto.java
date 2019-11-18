package be.wailsharks.parkshark.api.members.dto;

public class CreateMemberDto {

    private String firstName;
    private String lastName;
    private String licensePlateNr;
    private String licensePlateCountry;
    private String telephoneNr;
    private String emailAddress;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLicensePlateCountry() {
        return licensePlateCountry;
    }

    public void setLicensePlateCountry(String licensePlateCountry) {
        this.licensePlateCountry = licensePlateCountry;
    }

    public String getLicensePlateNr() {
        return licensePlateNr;
    }

    public void setLicensePlateNr(String licensePlateNr) {
        this.licensePlateNr = licensePlateNr;
    }

    public String getTelephoneNr() {
        return telephoneNr;
    }

    public void setTelephoneNr(String telephoneNr) {
        this.telephoneNr = telephoneNr;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
