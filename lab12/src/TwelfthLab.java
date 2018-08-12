public class TwelfthLab {
  public static void main(String[] args) {
    Test test = new Test();
    Testing testProxy = (Testing) DynamicProxy.newInstance(test);
    testProxy.printDivision(40, 5);
  }
}
