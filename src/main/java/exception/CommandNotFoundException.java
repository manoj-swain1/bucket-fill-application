package exception;

/**
 * Custom exception for Command related exceptions
 *
 * @author Manoj Swain
 * created on 17-04-2022
 */
public class CommandNotFoundException extends DrawException {

    static final long serialVersionUID = 1L;


    public CommandNotFoundException() {
        super();
    }


    public CommandNotFoundException(String message) {
        super(message);
    }


    public CommandNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


    public CommandNotFoundException(Throwable cause) {
        super(cause);
    }
}
