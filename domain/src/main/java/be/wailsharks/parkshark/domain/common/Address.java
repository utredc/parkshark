package be.wailsharks.parkshark.domain.common;

import javax.persistence.*;

@Embeddable
public class Address {
    public Address(String streetName, String houseNumber,City city) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;

    }

    @Column (name = "STREET_NAME")
    private String streetName;

    @Column (name = "STREET_NUMBER")
    private String houseNumber;

    @ManyToOne
    @JoinColumn(name ="CITY_ID")
    private City city;


}
