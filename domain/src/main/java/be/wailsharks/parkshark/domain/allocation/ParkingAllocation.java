package be.wailsharks.parkshark.domain.allocation;

import be.wailsharks.parkshark.domain.members.Member;
import be.wailsharks.parkshark.domain.parkinglot.ParkingLot;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PARKING_ALLOCATION")
public class ParkingAllocation {

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

    public ParkingAllocation() {
    }

    public void stopParkingSpotAllocation() {
        if (status.equals(Status.ACTIVE)) {
            status = Status.STOPPED;
            stopTime = LocalDateTime.now();
        } else throw new IllegalArgumentException("parking allocation is already stopped");
    }

    public long getId() {
        return id;
    }

    public Member getMember() {
        return member;
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
}
