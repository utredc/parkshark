package be.wailsharks.parkshark.domain.allocation;

import be.wailsharks.parkshark.domain.common.LicensePlate;
import be.wailsharks.parkshark.domain.members.Member;
import be.wailsharks.parkshark.domain.parkinglot.ParkingLot;

import java.time.LocalDateTime;

public class ParkingAllocation {

    private long id;

    private Member member;

    private LicensePlate licensePlate;

    private ParkingLot parkingLot;

    private LocalDateTime startTime;

    public ParkingAllocation(Member member, LicensePlate licensePlate, ParkingLot parkingLot) {
        this.member = member;
        this.licensePlate = licensePlate;
        this.parkingLot = parkingLot;
        this.startTime = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public LicensePlate getLicensePlate() {
        return licensePlate;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}
