/** Checked exception */
public class MyTrickyException extends Exception {
  public MyTrickyException(String errorMessage, Throwable throwable) {
    super(errorMessage, throwable);
  }
}
