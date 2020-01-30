package application.exception;

public class MoveNotPossibleException extends RuntimeException {
    public MoveNotPossibleException(String message) {
        super(message);
    }
}
