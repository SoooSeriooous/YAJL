/** Работа с созданием объектов */
public class CycleEntity {
  public CycleEntity() {
    System.out.println("New cycle entity");
  }

  public CycleEntity(int i) {
    System.out.println("New cycle entity #" + i);
  }

  public CycleEntity(int i, String message) {
    System.out.println(message + i);
  }
}
