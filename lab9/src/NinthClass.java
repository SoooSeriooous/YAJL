import java.util.*;

/** Коллекции и дженерики */
public class NinthClass {

  public static void main(String[] args) throws InterruptedException {

    // arrays
    List<Integer> integers = new ArrayList<>();
    setArrays(integers);
    System.out.println(integers);

    Integer i;
    Iterator iterator = integers.iterator();
    for (; iterator.hasNext(); ) {
      i = (Integer) iterator.next();
      if (i % 2 == 0) {
        iterator.remove();
      }
    }
    System.out.println(integers);
    integers.clear();
    setArrays(integers);

    System.out.println();

    // set
    List<String> strings = new ArrayList<>();
    strings.add("One");
    strings.add("Two");
    strings.add("Two");
    strings.add("Three");
    strings.add("Four");
    strings.add("Five");
    strings.add("Five");

    System.out.println(strings);
    Set<String> stringSet = new LinkedHashSet<>(); //
    stringSet.addAll(strings);
    System.out.println(stringSet);
    System.out.println();

    // map
    Map<String, Integer> map = new HashMap<>();

    iterator = stringSet.iterator();
    for (int j = 0; j < integers.size() & iterator.hasNext(); j++) {
      map.put((String) iterator.next(), integers.get(j));
    }

    System.out.println(map);
    System.out.println(map.get("Two"));
    System.out.println();

    // queue
    Queue<Integer> queue = new LinkedList<>();
    for (int j = 10; j >=0; j--) {
      ((LinkedList<Integer>) queue).add(j);
    }

    while (!queue.isEmpty()) {
      System.out.println(queue.remove());
      Thread.sleep(1000);
    }

  }

  private static void setArrays(List<Integer> integers) {
    integers.add(1);
    integers.add(2);
    integers.add(3);
    integers.add(4);
    integers.add(5);
  }
}
