package be.wailsharks.parkshark.api.allocation.dto;

public class ParkingAllocationDto {

    private long id;

    private long memberId;

    private String licensePlateNumber;

    private long parkingLotId;

    private String startTime;

    private String stopTime;
    private String status;

    public static ParkingAllocationDto ParkingAllocationDto() {
        return new ParkingAllocationDto();
    }

    public ParkingAllocationDto setId(long id) {
        this.id = id;
        return this;
    }

    public ParkingAllocationDto setMemberId(long memberId) {
        this.memberId = memberId;
        return this;
    }

    public ParkingAllocationDto setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
        return this;
    }

    public ParkingAllocationDto setParkingLotId(long parkingLotId) {
        this.parkingLotId = parkingLotId;
        return this;
    }

    public ParkingAllocationDto setStartTime(String startTime) {
        this.startTime = startTime;
        return this;
    }

    public ParkingAllocationDto setStopTime(String stopTime) {
        this.stopTime = stopTime;
        return this;
    }

    public ParkingAllocationDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getStopTime() {
        return stopTime;
    }

    public String getStatus() {
        return status;
    }

    public long getId() {
        return id;
    }

    public long getMemberId() {
        return memberId;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public long getParkingLotId() {
        return parkingLotId;
    }

    public String getStartTime() {
        return startTime;
    }
}
