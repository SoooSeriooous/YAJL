import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** Рефлексия */
public class EleventhLabs {
  public static void main(String[] args) {
    Class clazz = Test.class; // можно также и через Test t = new Test; t.getClass();
    // имя класса
    System.out.println(clazz.getSimpleName());
    // имя класса-родителя
    System.out.println(clazz.getSuperclass());
    // классы, объявленные внутри
    List<String> declaredClasses =
        Arrays.stream(clazz.getDeclaredClasses()).map(Class::toString).collect(Collectors.toList());
    System.out.println(declaredClasses);
    // все методы класса
    List<String> declaredMethod =
        Arrays.stream(clazz.getDeclaredMethods())
            .map(s -> s.toString())
            .collect(Collectors.toList());
    System.out.println(declaredMethod);
    // все конструкторы
    List<String> constructors =
        Arrays.stream(clazz.getDeclaredConstructors())
            .map(s -> s.toString())
            .collect(Collectors.toList());
    System.out.println(constructors);
    // все поля
    List<String> fields =
        Arrays.stream(clazz.getDeclaredFields())
            .map(s -> s.toString())
            .collect(Collectors.toList());
    System.out.println(fields);
    // вызов приватного метода
    try {
      Object obj = clazz.newInstance();
      Method makePrivateDivision =
          clazz.getDeclaredMethod("makePrivateDivision", Integer.class, Integer.class);
      makePrivateDivision.setAccessible(true);
      Integer i = (Integer) makePrivateDivision.invoke(obj, 20, 4);
      System.out.println(i);
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    // вызов приватного конструктора
    try {
      Constructor constructor = clazz.getDeclaredConstructor(String.class);
      constructor.setAccessible(true);
      Test test = (Test) constructor.newInstance("Kick private constructor");
      test.setFirst(12);
      test.setSecond(2);
      test.printDivision();
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }
}
