public interface Vehicle {

  String TYPE = "Vehicle";

  /* Двигаемся вперёд */
  void goForward(int segment);

  /* Двигаемся назад */
  void goBackwards(int segment);

  public default void makeSound() {
    System.out.println("Some noisy sound.");
  }
}
