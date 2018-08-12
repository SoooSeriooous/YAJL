import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Работа с массивами */
public class SeventhLab {
  public static void main(String[] args) {
    String[] strings = new String[] {"One", "Two", "Three", "Four", "Five"};
    for (String elem : strings) {
      System.out.println(elem);
    }

    System.out.println();
    List<String> stringList = new ArrayList<>(Arrays.asList(strings));
    stringList.remove(3);
    strings = stringList.toArray(strings);
    for (String elem : strings) {
      System.out.println(elem);
    }

    System.out.println("\n");
    int[][] integers = new int[3][];
    int[] anotherInts = new int[3];

    for (int i = 0; i < 3; i++) {
      anotherInts[i] = i;
      System.out.println(i);
    }

    System.out.println();
    integers[0] = anotherInts;
    integers[1] = new int[] {44, 66};
    integers[2] = new int[] {555, 7, 999, 1111};

    for (int[] ints : integers) {
      for (int i = 0; i < ints.length; i++) {
        System.out.print(ints[i] + " ");
      }
      System.out.println();
    }
  }
}
