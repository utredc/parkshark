package be.wailsharks.parkshark.domain.members;

import be.wailsharks.parkshark.domain.common.LicensePlate;
import be.wailsharks.parkshark.domain.common.Name;

import java.time.LocalDate;

public class Member {

    private Name name;
    private LicensePlate licensePlate;
    private String telephoneNr;
    private String emailAddress;
    private LocalDate registrationDate;

    public Member(Name name, LicensePlate licensePlate, String telephoneNr, String emailAddress) {
        this.name = name;
        this.licensePlate = licensePlate;
        this.telephoneNr = telephoneNr;
        this.emailAddress = emailAddress;
        registrationDate = LocalDate.now();
    }
}
