package be.wailsharks.parkshark.domain.allocation;

import be.wailsharks.parkshark.domain.members.Member;
import be.wailsharks.parkshark.domain.parkinglot.ParkingLot;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "PARKING_ALLOCATION")
public class ParkingAllocation {

    public static final double FINE_PER_HOUR_IF_PARKED_TOO_LONG = 2.5;

    @Id
    @SequenceGenerator(name = "parking_allocation_seq_gen", sequenceName = "PARKING_ALLOCATION_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parking_allocation_seq_gen")
    @Column(name = "ID")
    private long id;

    @JoinColumn(name = "MEMBER_ID")
    @ManyToOne
    private Member member;

    @Column(name = "LICENSE_PLATE")
    private String licensePlateNr;

    @JoinColumn(name = "PARKING_LOT_ID")
    @ManyToOne
    private ParkingLot parkingLot;

    @Column(name = "START_TIME")
    private LocalDateTime startTime;

    @Column(name = "STOP_TIME")
    private LocalDateTime stopTime;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    public ParkingAllocation(Member member, String licensePlateNr, ParkingLot parkingLot) {
        this.member = member;
        this.licensePlateNr = licensePlateNr;
        this.parkingLot = parkingLot;
        this.startTime = LocalDateTime.now();
        this.status = Status.ACTIVE;
    }

    public ParkingAllocation(Member member, String licensePlateNr, ParkingLot parkingLot, LocalDateTime startTime, LocalDateTime stopTime, Status status) {
        this.member = member;
        this.licensePlateNr = licensePlateNr;
        this.parkingLot = parkingLot;
        this.startTime = startTime;
        this.stopTime = stopTime;
        this.status = status;
    }

    public ParkingAllocation() {
        this.startTime = LocalDateTime.now();
        this.status = Status.ACTIVE;
    }

    public void stopParkingSpotAllocation() {
        if (!status.equals(Status.ACTIVE)) {
            throw new IllegalArgumentException("parking allocation is already stopped");
        }
        status = Status.STOPPED;
        parkingLot.releaseParkingSpot();
        stopTime = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public Member getMember() {
        return member;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getLicensePlateNr() {
        return licensePlateNr;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getStopTime() {
        return stopTime;
    }

    public Status getStatus() {
        return status;
    }

    public double calculatePrice() {

        return getBasePriceToPay() + getFineIfParkedTooLong();
    }

    private double getFineIfParkedTooLong() {
        if (!parkedTooLong()){
            return 0;
        }
        return ( calculateParkedHours() - member.getMembershipLevel().getMaxAllowedTime()) * FINE_PER_HOUR_IF_PARKED_TOO_LONG;
    }

    private boolean parkedTooLong() {
        return calculateParkedHours() > member.getMembershipLevel().getMaxAllowedTime();
    }

    private double getBasePriceToPay() {
        return calculateParkedHours() * parkingLot.getPricePerHour() * member.getMembershipLevel().getAllocationReduction();
    }

    private int calculateParkedHours() {
        double diffInMinutes = ChronoUnit.MINUTES.between(startTime,stopTime);
        return (int) Math.ceil(diffInMinutes/60);
    }

    public void switchStatusToInvoiced() {
        this.status = Status.INVOICED;
    }
}
