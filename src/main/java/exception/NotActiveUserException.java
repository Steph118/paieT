package exception;

public class NotActiveUserException extends LoginException {

    public NotActiveUserException(String message) {
        super(message);
    }
}
