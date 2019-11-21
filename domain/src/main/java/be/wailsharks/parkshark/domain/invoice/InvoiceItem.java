package be.wailsharks.parkshark.domain.invoice;

import be.wailsharks.parkshark.domain.allocation.ParkingAllocation;

import javax.persistence.*;

@Entity
@Table(name = "INVOICE_ITEM")
public class InvoiceItem {

    @Id
    @SequenceGenerator(name = "invoice_seq_gen", sequenceName = "INVOICE_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq_gen")
    @Column(name = "ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "PARKING_ALLOCATION_ID")
    private ParkingAllocation parkingAllocation;

    @Column(name = "PRICE")
    private double price;

    public InvoiceItem (ParkingAllocation parkingAllocation){
        this.parkingAllocation = parkingAllocation;
        price = parkingAllocation.calculatePrice();
    }

    public InvoiceItem() {
    }

    public ParkingAllocation getParkingAllocation() {
        return parkingAllocation;
    }

    public double getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }
}
