import java.util.ArrayList;
import java.util.List;

public class Test implements Testing {

  private Integer first;
  private Integer second;

  public static final String NAME = "TEST CLASS";

  public Test() {
    this("Test class");
    InnerTest innerTest = new InnerTest();
    innerTest.printSomeInfo();
  }

  private Test(String message) {
    System.out.println("Constructor message is " + message);
  }

  private Integer makePrivateDivision(Integer first, Integer second) throws ArithmeticException {
    return first / second;
  }

  protected void makeSomeMath(Integer first, Integer second) {
    Integer result = makePrivateDivision(first, second);
    System.out.println(result);
  }

  public void printDivision() {
    makeSomeMath(this.first, this.second);
  }

  public void printDivision(Integer first, Integer second) {
    makeSomeMath(first, second);
  }

  public void setFirst(Integer first) {
    this.first = first;
  }

  public void setSecond(Integer second) {
    this.second = second;
  }

  class InnerTest {
    public void printSomeInfo() {
      System.out.println("I'm inner class");
    }
  }
}
