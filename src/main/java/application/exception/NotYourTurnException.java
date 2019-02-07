package application.exception;

public class NotYourTurnException extends Exception {

	private static final long serialVersionUID = -4733113218120339184L;

	public NotYourTurnException(String message) {
		super(message);
	}
}
