public class Car implements Vehicle {

  private int speed;
  private int distance;
  public static final String TYPE = "CAR";

  @Override
  public void goForward(int segment) {
    this.distance += segment;
  }

  @Override
  public void goBackwards(int segment) {
    this.distance -= segment;
  }

  public int getSpeed() {
    return speed;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  // внутренний класс
  class Engine {
    public void start() {
      System.out.println("Engine starts here!");
    }

    public void stop() {
      System.out.println("Your ride time is " + distance / speed + ". Thank you.");
    }
  }

  public void makeDriverTalk() {
    // анонимный класс
    Person person =
        new Person() {
          @Override
          public String say() {
            return "Hello there!";
          }
        };

    System.out.println(person.say());
  }
}
