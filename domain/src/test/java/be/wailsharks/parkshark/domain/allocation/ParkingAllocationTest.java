package be.wailsharks.parkshark.domain.allocation;

import be.wailsharks.parkshark.domain.common.Address;
import be.wailsharks.parkshark.domain.common.LicensePlate;
import be.wailsharks.parkshark.domain.common.Name;
import be.wailsharks.parkshark.domain.members.Member;
import be.wailsharks.parkshark.domain.members.MembershipLevel;
import be.wailsharks.parkshark.domain.parkinglot.ParkingLot;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ParkingAllocationTest {

    @Nested
    class TestCalculatePrice {


        public static final int PRICE_PER_HOUR = 1;
        public static final int HOURS_TO_ADD = 2;


        @Test
        void calculatePriceBronzeMemberNoFine() {
            MembershipLevel membership = MembershipLevel.BRONZE;

            ParkingAllocation parkingAllocation = getParkingAllocation(membership,false);

            Assertions.assertThat(parkingAllocation.calculatePrice()).isEqualTo(getExpectedNoFine(membership));
        }

        @Test
        void calculatePriceBronzeMemberWithFine() {
            MembershipLevel membership = MembershipLevel.BRONZE;

            ParkingAllocation parkingAllocation = getParkingAllocation(membership,true);

            Assertions.assertThat(parkingAllocation.calculatePrice()).isEqualTo(getExpectedFine(membership));
        }

        @Test
        void calculatePriceSilverMemberNoFine() {
            MembershipLevel membership = MembershipLevel.SILVER;

            ParkingAllocation parkingAllocation = getParkingAllocation(membership,false);

            Assertions.assertThat(parkingAllocation.calculatePrice()).isEqualTo(getExpectedNoFine(membership));
        }

        @Test
        void calculatePriceSilverMemberFine() {
            MembershipLevel membership = MembershipLevel.SILVER;

            ParkingAllocation parkingAllocation = getParkingAllocation(membership,true);

            Assertions.assertThat(parkingAllocation.calculatePrice()).isEqualTo(getExpectedFine(membership));
        }

        @Test
        void calculatePriceGoldMemberFine() {
            MembershipLevel membership = MembershipLevel.GOLD;

            ParkingAllocation parkingAllocation = getParkingAllocation(membership,true);

            Assertions.assertThat(parkingAllocation.calculatePrice()).isEqualTo(getExpectedFine(membership));
        }

        @Test
        void calculatePriceGoldMemberNoFine() {
            MembershipLevel membership = MembershipLevel.GOLD;

            ParkingAllocation parkingAllocation = getParkingAllocation(membership,false);

            Assertions.assertThat(parkingAllocation.calculatePrice()).isEqualTo(getExpectedNoFine(membership));
        }

        @Test
        void calculateParkedHoursTestedTroughCalculation() {
            ParkingAllocation parkingAllocation = new ParkingAllocation(new Member(new Name(" ", " "), new LicensePlate(" ", " "), " ", "null", new Address(), MembershipLevel.BRONZE),
                    " ",
                    new ParkingLot(1.0, null, 200, null, null, null, null),
                    LocalDateTime.of(2019, 8, 2, 12, 0),
                    LocalDateTime.of(2019, 8, 2, 12, 1),
                    Status.STOPPED);
            Assertions.assertThat(parkingAllocation.calculatePrice()).isEqualTo(1);

            parkingAllocation = new ParkingAllocation(new Member(new Name(" ", " "), new LicensePlate(" ", " "), " ", "null", new Address(), MembershipLevel.BRONZE),
                    " ",
                    new ParkingLot(1.0, null, 200, null, null, null, null),
                    LocalDateTime.of(2019, 8, 2, 12, 0),
                    LocalDateTime.of(2019, 8, 2, 12, 59),
                    Status.STOPPED);
            Assertions.assertThat(parkingAllocation.calculatePrice()).isEqualTo(1);

            parkingAllocation = new ParkingAllocation(new Member(new Name(" ", " "), new LicensePlate(" ", " "), " ", "null", new Address(), MembershipLevel.BRONZE),
                    " ",
                    new ParkingLot(1.0, null, 200, null, null, null, null),
                    LocalDateTime.of(2019, 8, 2, 12, 0),
                    LocalDateTime.of(2019, 8, 2, 13, 0),
                    Status.STOPPED);
            Assertions.assertThat(parkingAllocation.calculatePrice()).isEqualTo(1);

            parkingAllocation = new ParkingAllocation(new Member(new Name(" ", " "), new LicensePlate(" ", " "), " ", "null", new Address(), MembershipLevel.BRONZE),
                    " ",
                    new ParkingLot(1.0, null, 200, null, null, null, null),
                    LocalDateTime.of(2019, 8, 2, 12, 0),
                    LocalDateTime.of(2019, 8, 2, 13, 1),
                    Status.STOPPED);
            Assertions.assertThat(parkingAllocation.calculatePrice()).isEqualTo(2);

        }

        private ParkingAllocation getParkingAllocation(MembershipLevel membershipLevel, boolean toLate) {
            LocalDateTime start = LocalDateTime.of(2019, 8, 2, 12, 0);
            LocalDateTime stop = start.plusHours(HOURS_TO_ADD);
            if (toLate) {
                stop = stop.plusHours(membershipLevel.getMaxAllowedTime());
            }

            return new ParkingAllocation(new Member(new Name(" ", " "), new LicensePlate(" ", " "), " ", "null", new Address(),membershipLevel),
                    " ",
                    new ParkingLot(PRICE_PER_HOUR, null, 200, null, null, null, null),
                    start,
                    stop,
                    Status.STOPPED);
        }

        private double getExpectedNoFine(MembershipLevel membership) {
            return PRICE_PER_HOUR * HOURS_TO_ADD * membership.getAllocationReduction();
        }

        private double getExpectedFine(MembershipLevel membership) {
            return (HOURS_TO_ADD + membership.getMaxAllowedTime()) * PRICE_PER_HOUR * membership.getAllocationReduction() + HOURS_TO_ADD * ParkingAllocation.FINE_PER_HOUR_IF_PARKED_TOO_LONG;
        }
    }
}