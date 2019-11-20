package be.wailsharks.parkshark.domain.exceptions;

public class LicensePlateMissMatchException extends RuntimeException{

    public LicensePlateMissMatchException(String message) {
        super(message);
    }
}
