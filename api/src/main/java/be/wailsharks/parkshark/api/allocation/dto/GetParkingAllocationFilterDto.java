package be.wailsharks.parkshark.api.allocation.dto;

public class GetParkingAllocationFilterDto {
    private int amount;
    private String status;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
