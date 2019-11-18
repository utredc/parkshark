package be.wailsharks.parkshark.domain.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class City {
    public City(String postalCode, String city) {
        this.postalCode = postalCode;
        this.city = city;
    }

    @Id
    @Column (name ="ID")
    private long id;

    @Column (name= "POSTAL_CODE")
    private String postalCode;

    @Column (name= "CITY")
    private String city;
}
