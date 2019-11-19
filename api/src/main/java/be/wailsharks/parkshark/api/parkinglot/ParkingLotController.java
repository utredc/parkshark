package be.wailsharks.parkshark.api.parkinglot;

import be.wailsharks.parkshark.api.parkinglot.dto.CreateParkingLotDto;
import be.wailsharks.parkshark.api.parkinglot.dto.ParkingLotDto;
import be.wailsharks.parkshark.service.parkinglot.ParkingLotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(ParkingLotController.PARKING_LOT_CONTROLLER_RESOURCE_URL)
public class ParkingLotController {

    static final String PARKING_LOT_CONTROLLER_RESOURCE_URL = "/parkinglot";
    private static final String APPLICATION_JSON_VALUE = MediaType.APPLICATION_JSON_VALUE;
    private static final Logger LOGGER = LoggerFactory.getLogger(ParkingLotController.class);

    private ParkingLotService parkingLotService;
    private ParkingLotMapper parkingLotMapper;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService, ParkingLotMapper parkingLotMapper){
        this.parkingLotService = parkingLotService;
        this.parkingLotMapper = parkingLotMapper;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ParkingLotDto> getAllParkingLots(){
        return parkingLotService.getAllParkingLots()
                .stream()
                .map(parkingLot -> parkingLotMapper.mapToParkingLotDto(parkingLot))
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ParkingLotDto getParkingLotById(@PathVariable ("id") long id){
        return parkingLotMapper.mapToParkingLotDto(parkingLotService.getByID(id));
    }



    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ParkingLotDto createParkingLot(@RequestBody CreateParkingLotDto createParkingLotDto) {
        LOGGER.info("Create division - name: " + createParkingLotDto.name);
        return parkingLotMapper.mapToParkingLotDto(
                parkingLotService.addParkingLot(
                        parkingLotMapper.mapToDomain(createParkingLotDto)));
    }
}
