package be.wailsharks.parkshark.service.allocation;

import be.wailsharks.parkshark.domain.allocation.ParkingAllocation;
import be.wailsharks.parkshark.domain.allocation.ParkingAllocationRepository;
import be.wailsharks.parkshark.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingAllocationService {

    private MemberService memberService;

    private ParkingAllocationRepository parkingAllocationRepository;

    @Autowired
    public ParkingAllocationService(MemberService memberService, ParkingAllocationRepository parkingAllocationRepository) {
        this.memberService = memberService;
        this.parkingAllocationRepository = parkingAllocationRepository;
    }

    public ParkingAllocation startParkingAllocation(ParkingAllocation parkingAllocation) {
        parkingAllocationRepository.save(parkingAllocation);
        parkingAllocation.getParkingLot().addCar();
        return parkingAllocation;
    }

    public ParkingAllocation getParkingAllocationById(Long allocationId) {
        if (parkingAllocationRepository.existsById(allocationId)) {
            return parkingAllocationRepository.findById(allocationId).get();
        }
        throw new IllegalArgumentException("No allocation with this id");
    }

    public ParkingAllocation stopParkingAllocation(String memberId, String allocationId) {
        ParkingAllocation allocation = getParkingAllocationById(Long.parseLong(allocationId));
        if (allocation.getMember().getId() != Long.parseLong(memberId)) {
            throw new IllegalArgumentException("Member does not own this allocation");
        }
        allocation.stopParkingSpotAllocation();
        return allocation;
    }
}
