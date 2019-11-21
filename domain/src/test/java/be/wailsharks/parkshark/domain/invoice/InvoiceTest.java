package be.wailsharks.parkshark.domain.invoice;

import be.wailsharks.parkshark.domain.allocation.ParkingAllocation;
import be.wailsharks.parkshark.domain.allocation.Status;
import be.wailsharks.parkshark.domain.common.Address;
import be.wailsharks.parkshark.domain.common.LicensePlate;
import be.wailsharks.parkshark.domain.common.Name;
import be.wailsharks.parkshark.domain.members.Member;
import be.wailsharks.parkshark.domain.members.MembershipLevel;
import be.wailsharks.parkshark.domain.parkinglot.ParkingLot;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.catchThrowable;


class InvoiceTest {

    @Test
    void creatingNewInvoice() {
        Member member = getMember();

        List<ParkingAllocation> parkingAllocations = getParkingAllocationsFor(member);

        Invoice invoice = new Invoice(parkingAllocations,member);

        Assertions.assertThat(invoice.getInvoiceItems()).isNotEmpty();
        Assertions.assertThat(invoice.getInvoiceItems().size()).isEqualTo(2);
        Assertions.assertThat(invoice.getExpireDate()).isEqualTo(LocalDate.now().plusDays(Invoice.DAYS_BEFORE_EXPIRING));
        Assertions.assertThat(invoice.getStatus()).isEqualTo(InvoiceStatus.OPEN);
    }

    @Test
    void creatingNewInvoiceDifferentMembersInParkingAllocations() {
        Member member = getMember();

        List<ParkingAllocation> parkingAllocations = getParkingAllocationsFor(member);

        Throwable thrown = catchThrowable(() -> new Invoice(parkingAllocations,getMember()));

        Assertions.assertThat(thrown).hasMessage("Member and member in parkinglotallocations don't match");
    }

    private Member getMember() {
        return new Member(new Name(" ", " "), new LicensePlate(), " ", " ", new Address(), MembershipLevel.BRONZE);
    }


    private List<ParkingAllocation> getParkingAllocationsFor(Member member) {
        ParkingAllocation parkingAllocation1 = new ParkingAllocation(member,
                " ",
                new ParkingLot(1.0, null, 200, null, null, null, null),
                LocalDateTime.of(2019, 8, 2, 12, 0),
                LocalDateTime.of(2019, 8, 2, 13, 0),
                Status.STOPPED);

        ParkingAllocation parkingAllocation2 = new ParkingAllocation(member,
                " ",
                new ParkingLot(1.0, null, 200, null, null, null, null),
                LocalDateTime.of(2019, 8, 2, 12, 0),
                LocalDateTime.of(2019, 8, 2, 13, 0),
                Status.STOPPED);

        return List.of(parkingAllocation1,parkingAllocation2);
    }
}