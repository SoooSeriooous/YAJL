import java.lang.reflect.Method;

import static java.lang.ClassLoader.getSystemClassLoader;

/**
 * ClassLoaders & Custom ClassLoader
 */
public class FifthLab {
  public static void main(String[] args) throws Exception {
    System.out.println("Start\n");
    FirstClass[] classesArray = new FirstClass[10];
    for (int i = 0; i < 10; i++) {
      if (i % 2 == 0) {
        classesArray[i] = new FirstClass();
      } else {
        classesArray[i] = new SecondClass();
      }
    }
    for (int i = 0; i < 10; i++) {
      System.out.println(i + ") " + classesArray[i].doSomeMath(i, i));
    }
    System.out.println("\nFinish\n\n");

    ClassLoader loader = getSystemClassLoader();
    FirstClass firstClass = (FirstClass) loader.loadClass("FirstClass").newInstance();
    SecondClass secondClass = (SecondClass) loader.loadClass("SecondClass").newInstance();

    Method firstClassMethodDoMath = firstClass.getClass().getMethod("doSomeMath", int.class, int.class);
    System.out.println(firstClassMethodDoMath.invoke(firstClass, 2,3));
    Method firstClassMethodAddToString = firstClass.getClass().getMethod("addSomethingToString", String.class);
    System.out.println(firstClassMethodAddToString.invoke(firstClass, "string") + "\n");

    Method secondClassMethodDoMath = secondClass.getClass().getMethod("doSomeMath", int.class, int.class);
    System.out.println(secondClassMethodDoMath.invoke(secondClass, 4,5));

    System.out.println("\nMy tricky ClassLoader");
    MyTrickyClassLoader trickyClassLoader = new MyTrickyClassLoader(args[0]);
    Class firstClazz = trickyClassLoader.findClass("FirstClass");
    Method method = firstClazz.getMethod("doSomeMath", int.class, int.class);
    System.out.println(method.invoke(firstClazz.newInstance(), 4,5) + "\n");

    Class secondClazz = trickyClassLoader.findClass("SecondClass");
    method = secondClazz.getMethod("doSomeMath", int.class, int.class);
    System.out.println(method.invoke(secondClazz.newInstance(), 4,5));
  }
}
