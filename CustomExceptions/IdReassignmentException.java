package CustomExceptions;

public class IdReassignmentException extends RuntimeException {
    public IdReassignmentException(String message) {
        super(message);
    }
}
