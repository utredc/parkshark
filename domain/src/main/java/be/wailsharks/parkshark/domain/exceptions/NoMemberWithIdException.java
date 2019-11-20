package be.wailsharks.parkshark.domain.exceptions;

public class NoMemberWithIdException extends RuntimeException {

    public NoMemberWithIdException(String message) {
        super(message);
    }

}
