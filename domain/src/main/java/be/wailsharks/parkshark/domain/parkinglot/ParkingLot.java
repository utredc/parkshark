package be.wailsharks.parkshark.domain.parkinglot;

import be.wailsharks.parkshark.domain.common.Address;
import be.wailsharks.parkshark.domain.common.ContactPerson;

import javax.persistence.*;

@Entity
@Table(name = "PARKING_LOT")
public class ParkingLot {

    @Id
    @Column(name = "ID")
    private long id;

    @Column(name = "PRICE_PER_HOUR")
    private double pricePerHour;

    @Column(name ="NAME")
    private String name;

    @Column(name = "MAX_CAPACITY")
    private int maxCapacity;

    private ContactPerson contactPerson;

    @Embedded
    private Address address;

    @Column(name = "CATEGORY")
    @Enumerated
    private Category category;


//    @JoinColumn(name = "DIVISION_ID")
//    @ManyToOne
//    private Division division;


    public ParkingLot() {
    }

}
