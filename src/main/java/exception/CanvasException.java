package exception;

/**
 * Custom exception for Canvas related exceptions
 *
 * @author Manoj Swain
 * created on 17-04-2022
 */
public class CanvasException extends DrawException {

    static final long serialVersionUID = 1L;


    public CanvasException() {
        super();
    }


    public CanvasException(String message) {
        super(message);
    }


    public CanvasException(String message, Throwable cause) {
        super(message, cause);
    }


    public CanvasException(Throwable cause) {
        super(cause);
    }
}