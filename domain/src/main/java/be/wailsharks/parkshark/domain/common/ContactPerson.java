package be.wailsharks.parkshark.domain.common;

import javax.persistence.*;

@Entity
@Table(name="CONTACT_PERSON")
public class ContactPerson {

    @Id
    @Column(name = "ID")
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

}
