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

//            check for valid member
//            check if license plate belongs to member
//            parking lot is valid
        //parking lot != full
        return null;
    }

}