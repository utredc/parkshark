package be.wailsharks.parkshark.api.allocation;

import be.wailsharks.parkshark.api.allocation.dto.GetParkingAllocationFilterDto;
import be.wailsharks.parkshark.api.allocation.dto.ParkingAllocationDto;
import be.wailsharks.parkshark.api.allocation.dto.StartParkingAllocationDto;
import be.wailsharks.parkshark.api.allocation.dto.StopParkingAllocationDto;
import be.wailsharks.parkshark.domain.allocation.ParkingAllocation;
import be.wailsharks.parkshark.service.allocation.ParkingAllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/allocation")
public class ParkingAllocationController {

    private static final String APPLICATION_JSON_VALUE = MediaType.APPLICATION_JSON_VALUE;
    private ParkingAllocationService parkingAllocationService;
    private ParkingAllocationMapper parkingAllocationMapper;

    @Autowired
    public ParkingAllocationController(ParkingAllocationService parkingAllocationService, ParkingAllocationMapper parkingAllocationMapper) {
        this.parkingAllocationService = parkingAllocationService;
        this.parkingAllocationMapper = parkingAllocationMapper;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingAllocationDto startParkingAllocation(@RequestBody StartParkingAllocationDto startParkingAllocationDto) {
        return ParkingAllocationMapper.mapToDto(
                parkingAllocationService.startParkingAllocation(
                        parkingAllocationMapper.mapToDomain(startParkingAllocationDto)));
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ParkingAllocationDto stopParkingAllocation(@RequestBody StopParkingAllocationDto stopParkingAllocationDto) {
        ParkingAllocation allocation = parkingAllocationService.stopParkingAllocation(stopParkingAllocationDto.getMemberId(), stopParkingAllocationDto.getAllocationId());
        return ParkingAllocationMapper.mapStoppedToDto(allocation);
    }

    @GetMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<ParkingAllocationDto> getAllParkingAllocations(@RequestBody GetParkingAllocationFilterDto getParkingAllocationFilterDto) {
        List<ParkingAllocation> resultList = parkingAllocationService.getAllParkingAllocations(getParkingAllocationFilterDto.getStatus(), getParkingAllocationFilterDto.getAmount());
        return resultList.stream()
                .map(ParkingAllocationMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
