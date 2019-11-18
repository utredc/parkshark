//package be.wailsharks.parkshark.domain.parkinglot;
//
//import be.wailsharks.parkshark.domain.common.Address;
//import be.wailsharks.parkshark.domain.common.ContactPerson;
//import be.wailsharks.parkshark.domain.division.Division;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "PARKING_LOT")
//public class ParkingLot {
//
//    @Id
//    @SequenceGenerator(name = "parkingLotSeqGen", sequenceName = "PARKING_LOT_SEQ", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parkingLotSeqGen")
//    @Column(name = "ID")
//    private long id;
//
//    @Column(name = "PRICE_PER_HOUR")
//    private double pricePerHour;
//
//    @Column(name ="NAME")
//    private String name;
//
//    @Column(name = "MAX_CAPACITY")
//    private int maxCapacity;
//
//    private ContactPerson contactPerson;
//
//    @Embedded
//    private Address address;
//
//    @Column(name = "CATEGORY")
//    @Enumerated
//    private Category category;
//
//
//    @JoinColumn(name = "DIVISION_ID")
//    @ManyToOne
//    private Division division;
//
//    public ParkingLot() {
//    }
//
//    public ParkingLot(double pricePerHour, String name, int maxCapacity, ContactPerson contactPerson, Address address, Category category, Division division) {
//        this.pricePerHour = pricePerHour;
//        this.name = name;
//        this.maxCapacity = maxCapacity;
//        this.contactPerson = contactPerson;
//        this.address = address;
//        this.category = category;
//        this.division = division;
//    }
//}
