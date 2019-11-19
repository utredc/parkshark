package be.wailsharks.parkshark.api.allocation.dto;

public class ParkingAllocationDto {

    private long id;

    private long memberId;

    private String licensePlateNumber;

    private long parkingLotId;

    private String startTime;

    public static ParkingAllocationDto DivisionDto() {
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
}
