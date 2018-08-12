/** Исключия */
public class TenthLab {
  public static void main(String[] args) throws Exception {
    try {
      throwException();
    } catch (MyTrickyException e) {
      System.out.println("First block");
      throw new Exception(e);
    } catch (Exception e) {
      System.out.println("Second block");
      throw e;
    } finally {
      System.out.println("Finally block");
    }
  }

  private static void throwException() throws Exception {
    throw new MyTrickyException("New exception", new RuntimeException());
  }
}
