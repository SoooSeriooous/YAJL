public class SuperTest implements Testing {
  @Override
  public void printDivision() {
    System.out.println("Without arguments");
  }

  @Override
  public void printDivision(Integer first, Integer second) {
    System.out.println("With arguments: " + first + " and " + second);
  }
}
