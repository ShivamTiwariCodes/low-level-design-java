package problems.onlinestockbrokeragesystem.exceptions;

public class InsufficientStockException extends RuntimeException{

    public InsufficientStockException() {
        super("Sufficient stocks not found.");
    }

    public InsufficientStockException(String message) {
        super(message);
    }
}
