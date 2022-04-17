package exception;

/**
 * Custom exception for Drawing related exceptions
 *
 * @author Manoj Swain
 * created on 17-04-2022
 */
public class DrawException extends RuntimeException {

    static final long serialVersionUID = 1L;


    public DrawException() {
        super();
    }


    public DrawException(String message) {
        super(message);
    }


    public DrawException(String message, Throwable cause) {
        super(message, cause);
    }


    public DrawException(Throwable cause) {
        super(cause);
    }

}
