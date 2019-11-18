package be.wailsharks.parkshark.domain.common;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class LicensePlate {
    private String plateNumber;
    private String plateCountry;


    public LicensePlate() {
    }

    public LicensePlate(String plateNumber, String plateCountry) {
        this.plateNumber = plateNumber;
        this.plateCountry = plateCountry;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getPlateCountry() {
        return plateCountry;
    }
}
