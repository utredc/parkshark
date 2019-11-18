package be.wailsharks.parkshark.domain.common;

import javax.persistence.*;

@Entity
@Table(name="CONTACT_PERSON")
public class ContactPerson {

    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "contactPersonSeqGen", sequenceName = "CONTACT_PERSON_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contactPersonSeqGen")
    private long id;

    @Embedded
    private Name name;

    @Column(name ="EMAIL")
    private String Email;

    @Embedded
    private Address address;

    @Column(name ="MOBILE_NR")
    private String mobileNr;

    @Column(name ="PHONE_NR")
    private String phoneNr;

    public long getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public String getEmail() {
        return Email;
    }

    public Address getAddress() {
        return address;
    }

    public String getMobileNr() {
        return mobileNr;
    }

    public String getPhoneNr() {
        return phoneNr;
    }
}
