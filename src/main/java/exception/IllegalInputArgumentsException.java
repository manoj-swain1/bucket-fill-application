package exception;

/**
 * Custom exception for Illegal Input related exceptions
 *
 * @author Manoj Swain
 * created on 17-04-2022
 */
public class IllegalInputArgumentsException extends DrawException {

    static final long serialVersionUID = 1L;


    public IllegalInputArgumentsException() {
        super();
    }


    public IllegalInputArgumentsException(String message) {
        super(message);
    }


    public IllegalInputArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }


    public IllegalInputArgumentsException(Throwable cause) {
        super(cause);
    }
}
