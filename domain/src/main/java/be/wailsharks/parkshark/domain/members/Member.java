package be.wailsharks.parkshark.domain.members;

import be.wailsharks.parkshark.domain.common.LicensePlate;
import be.wailsharks.parkshark.domain.common.Name;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MEMBER")
public class Member {

    @Id
    @SequenceGenerator(name = "member_seq_gen", sequenceName = "MEMBER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
    @Column(name = "ID")
    private long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "FIRST_NAME")),
            @AttributeOverride(name = "lastName", column = @Column(name = "LAST_NAME"))
    })
    private Name name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "plateNumber", column = @Column(name = "LICENSE_PLATE_NR")),
            @AttributeOverride(name = "plateCountry", column = @Column(name = "LICENSE_ISSUING_COUNTRY"))
    })
    private LicensePlate licensePlate;

    @Column(name = "PHONE_NR")
    private String telephoneNr;

    @Column(name = "EMAIL")
    private String emailAddress;

    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    public Name getName() {
        return name;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public String getTelephoneNr() {
        return telephoneNr;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public Member(Name name, LicensePlate licensePlate, String telephoneNr, String emailAddress) {
        this.name = name;
        this.licensePlate = licensePlate;
        this.telephoneNr = telephoneNr;
        this.emailAddress = emailAddress;
        registrationDate = LocalDate.now();
    }
}
