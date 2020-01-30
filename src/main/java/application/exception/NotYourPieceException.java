package application.exception;

public class NotYourPieceException extends RuntimeException {
    public NotYourPieceException(String message) {
        super(message);
    }
}
