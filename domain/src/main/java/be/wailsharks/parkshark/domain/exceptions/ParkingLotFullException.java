package be.wailsharks.parkshark.domain.exceptions;

public class ParkingLotFullException extends RuntimeException {

    public ParkingLotFullException(String message) {
        super(message);
    }
}
