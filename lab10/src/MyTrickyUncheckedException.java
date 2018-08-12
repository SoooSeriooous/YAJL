/**
 * unchecked exception
 */
public class MyTrickyUncheckedException extends RuntimeException {
    public MyTrickyUncheckedException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }

}
