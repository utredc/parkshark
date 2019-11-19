package be.wailsharks.parkshark.api.allocation;

import be.wailsharks.parkshark.api.allocation.dto.ParkingAllocationDto;
import be.wailsharks.parkshark.api.allocation.dto.StartParkingAllocationDto;
import be.wailsharks.parkshark.service.allocation.ParkingAllocationService;
import org.springframework.beans.factory.annotation.Autowired;

public class ParkingAllocationController {

    ParkingAllocationService parkingAllocationService;

    @Autowired
    public ParkingAllocationController(ParkingAllocationService parkingAllocationService) {
        this.parkingAllocationService = parkingAllocationService;
    }

    public ParkingAllocationDto startParkingAllocation(StartParkingAllocationDto startParkingAllocationDto) {
        return ParkingAllocationMapper.mapToDto(
                parkingAllocationService.startParkingAllocation(
                        ParkingAllocationMapper.mapToDomain(startParkingAllocationDto)));
    }
}
