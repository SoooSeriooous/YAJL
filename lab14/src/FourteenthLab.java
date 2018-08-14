import java.io.*;

public class FourteenthLab {
  public static void main(String[] args) {
    System.out.println("Serializable");
    startSerialTests();
    System.out.println("\nExternalizable");
    startExternalTests();
  }

  private static void startExternalTests() {
    ExternalTest first = new ExternalTest("First");
    ExternalTest second = new ExternalTest("Second");
    ExternalTest third = new ExternalTest();

    ExternalContainer container = new ExternalContainer();
    container.addItem(first);
    container.addItem(second);
    container.addItem(third);
    container.addItem(first);
    container.addItem(second);
    container.addItem(third);
    container.addItem(first);
    container.addItem(second);
    container.addItem(third);

    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      container.writeExternal(oos);
      oos.flush();
      oos.close();
      baos.flush();
      baos.close();

      ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
      ObjectInputStream ois = new ObjectInputStream(bais);
      ExternalContainer externalContainer = new ExternalContainer();
      externalContainer.readExternal(ois);

      ois.close();
      bais.close();

      container.getItem(0).setTextField("New text value");

      System.out.println("First element is equal to third element: " + (container.getItem(0).equals(container.getItem(3))));
      System.out.println("First element's hash code is equal to third element's: " + (container.getItem(0).hashCode() == container.getItem(3).hashCode()));
      System.out.println("First element is equal to sixth element's: " + (container.getItem(0).equals(container.getItem(6))));
      System.out.println("First element's hash code is equal to sixth element's: " + (container.getItem(0).hashCode() == container.getItem(6).hashCode()));

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void startSerialTests() {
    SerialTest first = new SerialTest("Test text for first instance");
    SerialTest second = new SerialTest("Second instance");
    SerialTest third = new SerialTest();

    SerialTest[] tests = new SerialTest[9];
    tests[0] = first;
    tests[1] = second;
    tests[2] = third;
    tests[3] = first;
    tests[4] = second;
    tests[5] = third;
    tests[6] = first;
    tests[7] = second;
    tests[8] = third;

    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos);
      oos.writeObject(tests);
      oos.flush();
      baos.flush();
      oos.close();
      baos.close();

      ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
      ObjectInputStream ois = new ObjectInputStream(bais);
      SerialTest[] serialTests = (SerialTest[]) ois.readObject();

      serialTests[0].setTextField("New text field data");

      System.out.println("First element is equal to third element: " + (serialTests[0].equals(serialTests[3])));
      System.out.println("First element's hash code is equal to third element's: " + (serialTests[0].hashCode() == serialTests[3].hashCode()));
      System.out.println("First element is equal to sixth element's: " + (serialTests[0].equals(serialTests[6])));
      System.out.println("First element's hash code is equal to sixth element's: " + (serialTests[0].hashCode() == serialTests[6].hashCode()));

    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
