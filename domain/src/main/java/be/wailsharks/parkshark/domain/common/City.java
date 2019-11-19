package be.wailsharks.parkshark.domain.common;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class City {
    public City(String postalCode, String city) {
        this.postalCode = postalCode;
        this.cityName = city;
    }

    @Id
    @Column (name ="CITY_ID")
    @SequenceGenerator(name = "citySeqGen", sequenceName = "CITY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "citySeqGen")
    private long id;

    @Column (name= "POSTAL_CODE")
    private String postalCode;

    @Column (name= "NAME")
    private String cityName;

    public City(){

    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCityName() {
        return cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return id == city.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public long getId() {
        return id;
    }
}
