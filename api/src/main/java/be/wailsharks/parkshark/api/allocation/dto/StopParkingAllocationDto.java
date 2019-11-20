package be.wailsharks.parkshark.api.allocation.dto;

public class StopParkingAllocationDto {
    private String memberId;
    private String allocationId;

    public StopParkingAllocationDto(String memberId, String allocationId) {
        this.memberId = memberId;
        this.allocationId = allocationId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(String allocationId) {
        this.allocationId = allocationId;
    }
}
