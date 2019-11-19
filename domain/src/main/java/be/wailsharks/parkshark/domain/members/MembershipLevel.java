package be.wailsharks.parkshark.domain.members;

public enum MembershipLevel {
    BRONZE(0, 1, 4),
    SILVER(10, 0.8, 6),
    GOLD(40, 0.7, 24);

    private int monthlyCost;
    private double allocationReduction;
    private int maxAllowedTime;

    MembershipLevel(int monthlyCost, double allocationMultiplier, int maxAllowedTime) {
        this.monthlyCost = monthlyCost;
        this.allocationReduction = allocationMultiplier;
        this.maxAllowedTime = maxAllowedTime;
    }

    public int getMonthlyCost() {
        return monthlyCost;
    }

    public double getAllocationReduction() {
        return allocationReduction;
    }

    public int getMaxAllowedTime() {
        return maxAllowedTime;
    }
}
