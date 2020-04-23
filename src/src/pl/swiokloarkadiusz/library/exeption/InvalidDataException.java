package pl.swiokloarkadiusz.library.exeption;

public class InvalidDataException extends RuntimeException {
    public InvalidDataException(String message) {
        super(message);
    }
}
