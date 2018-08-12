import com.sun.deploy.security.ValidationState;

/** Интерфейсы и классы */
public class EighthLab {
  public static void main(String[] args) {
    Car car = new Car();
    Car.Engine engine = car.new Engine();

    engine.start();
    car.setSpeed(10);
    car.goForward(25);
    car.setSpeed(4);
    car.goBackwards(5);
    engine.stop();
    System.out.println("Your speed was: " + car.getSpeed() + "\n");

    car.makeDriverTalk();
    System.out.println(car.TYPE);
    car.makeSound();
  }
}
