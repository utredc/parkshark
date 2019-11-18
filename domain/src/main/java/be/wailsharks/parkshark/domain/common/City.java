package be.wailsharks.parkshark.domain.common;

import javax.persistence.Column;
import javax.persistence.Id;

public class City {

    @Id
    @Column (name ="ID")
    private long id;

    @Column (name= "POSTAL_CODE")
    private String postalCode;

    @Column (name= "CITY")
    private String city;
}
