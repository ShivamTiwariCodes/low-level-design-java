package problems.onlinestockbrokeragesystem.exceptions;

public class InsufficientAmountException extends RuntimeException {

    public InsufficientAmountException() {
        super("Not enough amount in the account.");
    }

    public InsufficientAmountException(String message) {
        super(message);
    }

}
