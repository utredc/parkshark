package be.wailsharks.parkshark.domain.members;

import be.wailsharks.parkshark.domain.common.Address;
import be.wailsharks.parkshark.domain.common.LicensePlate;
import be.wailsharks.parkshark.domain.common.Name;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MEMBER")
public class Member {
    public static final MembershipLevel DEFAULT_MEMBERSHIP_LEVEL = MembershipLevel.BRONZE;

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

    @Embedded
    private Address address;

    @Column(name = "MEMBER_LEVEL")
    @Enumerated(EnumType.STRING)
    private MembershipLevel membershipLevel;

    public long getId() {
        return id;
    }

    public Member(Name name, LicensePlate licensePlate, String telephoneNr, String emailAddress, Address address, MembershipLevel membershipLevel) {
        this.name = name;
        this.licensePlate = licensePlate;
        this.telephoneNr = telephoneNr;
        this.emailAddress = emailAddress;
        this.address = address;
        this.membershipLevel = membershipLevel;
        registrationDate = LocalDate.now();
    }

    public Member() {
    }

    public Address getAddress() {
        return address;
    }

    public Name getName() {
        return name;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public String getTelephoneNr() {
        return telephoneNr;
    }

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}
