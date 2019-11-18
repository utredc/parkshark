package be.wailsharks.parkshark.service.parkinglot;

import be.wailsharks.parkshark.domain.parkinglot.ParkingLot;
import be.wailsharks.parkshark.domain.parkinglot.ParkingLotRepository;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot addParkingLot(ParkingLot parkingLotToAdd) {
        return parkingLotRepository.save(parkingLotToAdd);
    }
}
