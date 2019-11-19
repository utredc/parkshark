package be.wailsharks.parkshark.api.allocation;

import be.wailsharks.parkshark.api.allocation.dto.ParkingAllocationDto;
import be.wailsharks.parkshark.api.allocation.dto.StartParkingAllocationDto;
import be.wailsharks.parkshark.domain.allocation.ParkingAllocation;
import be.wailsharks.parkshark.domain.members.Member;
import be.wailsharks.parkshark.domain.members.MembershipLevel;
import be.wailsharks.parkshark.domain.parkinglot.ParkingLot;
import be.wailsharks.parkshark.service.MemberService;
import be.wailsharks.parkshark.service.parkinglot.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ParkingAllocationMapper {

    private MemberService memberService;
    private ParkingLotService parkingLotService;

    @Autowired
    public ParkingAllocationMapper(MemberService memberService, ParkingLotService parkingLotService) {
        this.memberService = memberService;
        this.parkingLotService = parkingLotService;
    }

    public ParkingAllocation mapToDomain(StartParkingAllocationDto startParkingAllocationDto) {
        Member parkingMember = memberService.getSpecificMember(startParkingAllocationDto.getMemberId());
        if (parkingMember.getMembershipLevel() != MembershipLevel.GOLD) {
            if (!startParkingAllocationDto.getLicensePlateNr().equals(parkingMember.getLicensePlate().getPlateNumber())) {
                throw new IllegalArgumentException("Wrong car");
            }
        }
        ParkingLot parkingLot = parkingLotService.getByID(startParkingAllocationDto.getParkingLotId());
        if (parkingLot.isFull()) {
            throw new IllegalStateException("Parking is vol");
        }
        return new ParkingAllocation(parkingMember, startParkingAllocationDto.licensePlateNr, parkingLot);
    }

    public static ParkingAllocationDto mapToDto(ParkingAllocation parkingAllocation) {
        return new ParkingAllocationDto()
                .setId(parkingAllocation.getId())
                .setMemberId(parkingAllocation.getMember().getId())
                .setLicensePlateNumber(parkingAllocation.getLicensePlateNr())
                .setParkingLotId(parkingAllocation.getParkingLot().getId())
                .setStartTime(parkingAllocation.getStartTime().toString());
    }
}
