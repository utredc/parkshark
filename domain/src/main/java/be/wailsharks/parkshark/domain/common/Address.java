package be.wailsharks.parkshark.domain.common;

import javax.persistence.*;

@Embeddable
public class Address {

    public Address(String streetName, String houseNumber, long cityId) {
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.cityId = cityId;
    }

    public Address() {
    }

    @Column(name = "STREET_NAME")
    private String streetName;

    public String getStreetName() {
        return streetName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public long getCityId() {
        return cityId;
    }

    @Column(name = "STREET_NUMBER")
    private String houseNumber;

//    @ManyToOne
//    @JoinColumn(name = "CITY_ID")
    private long cityId;


}
