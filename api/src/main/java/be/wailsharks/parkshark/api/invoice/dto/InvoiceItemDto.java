package be.wailsharks.parkshark.api.invoice.dto;

import be.wailsharks.parkshark.api.allocation.dto.ParkingAllocationDto;
import be.wailsharks.parkshark.domain.allocation.ParkingAllocation;

public class InvoiceItemDto {
    private long id;
    private ParkingAllocationDto parkingAllocation;
    private double price;

    public long getId() {
        return id;
    }

    public InvoiceItemDto setId(long id) {
        this.id = id;
        return this;
    }

    public ParkingAllocationDto getParkingAllocation() {
        return parkingAllocation;
    }

    public InvoiceItemDto setParkingAllocation(ParkingAllocationDto parkingAllocation) {
        this.parkingAllocation = parkingAllocation;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public InvoiceItemDto setPrice(double price) {
        this.price = price;
        return this;
    }
}
