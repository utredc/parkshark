package be.wailsharks.parkshark.service.parkinglot;

import be.wailsharks.parkshark.domain.parkinglot.ParkingLot;
import be.wailsharks.parkshark.domain.parkinglot.ParkingLotRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot addParkingLot(ParkingLot parkingLotToAdd) {
        return parkingLotRepository.save(parkingLotToAdd);
    }

    public List<ParkingLot> getAllParkingLots() {
        List<ParkingLot> parkingLots = new ArrayList<>();
        parkingLotRepository.findAll().forEach(parkingLots::add);
        return parkingLots;
    }

    public ParkingLot getByID(long id) {
        return parkingLotRepository.findById(id).get();
    }
}
