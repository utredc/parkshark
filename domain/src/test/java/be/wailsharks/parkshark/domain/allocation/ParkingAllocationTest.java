package be.wailsharks.parkshark.domain.allocation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParkingAllocationTest {

    private ParkingAllocation parkingAllocation;

    @BeforeEach
    void setUp() {
        parkingAllocation = new ParkingAllocation();
    }


    @Test
    void statusIsActiveOnCreation() {
        assertThat(parkingAllocation.getStatus()).isEqualByComparingTo(Status.ACTIVE);
    }


    @Test
    void stopAllocation() {
        parkingAllocation.stopParkingSpotAllocation();
        assertThat(parkingAllocation.getStatus()).isEqualByComparingTo(Status.STOPPED);
    }
}