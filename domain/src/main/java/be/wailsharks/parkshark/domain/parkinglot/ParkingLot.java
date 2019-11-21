package be.wailsharks.parkshark.domain.parkinglot;

import be.wailsharks.parkshark.domain.common.Address;
import be.wailsharks.parkshark.domain.common.ContactPerson;
import be.wailsharks.parkshark.domain.division.Division;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "PARKING_LOT")
public class ParkingLot {

    @Id
    @SequenceGenerator(name = "parkingLotSeqGen", sequenceName = "PARKING_LOT_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parkingLotSeqGen")
    @Column(name = "ID")
    private long id;

    @Column(name = "PRICE_PER_HOUR")
    private double pricePerHour;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MAX_CAPACITY")
    private int maxCapacity;

    @ManyToOne
    @JoinColumn(name = "CONTACT_PERSON_ID")
    private ContactPerson contactPerson;

    @Embedded
    private Address address;

    @Column(name = "CATEGORY")
    @Enumerated(EnumType.STRING)
    private Category category;


    @JoinColumn(name = "DIVISION_ID")
    @ManyToOne
    private Division division;

    @Column(name = "AMOUNT_OF_CARS_PARKED")
    private int amountOfCarsParked;

    public ParkingLot() {
    }

    public ParkingLot(double pricePerHour, String name, int maxCapacity, ContactPerson contactPerson, Address address, Category category, Division division) {
        this.pricePerHour = pricePerHour;
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.category = category;
        this.division = division;
    }

    public boolean isFull() {
        return (amountOfCarsParked >= maxCapacity);
    }

    public long getId() {
        return id;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public String getName() {
        return name;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public ContactPerson getContactPerson() {
        return contactPerson;
    }

    public Address getAddress() {
        return address;
    }

    public Category getCategory() {
        return category;
    }

    public Division getDivision() {
        return division;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void addCar() {
        amountOfCarsParked++;
    }

    public void releaseParkingSpot() {
        amountOfCarsParked--;
    }


}
