import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.reflect.Proxy.newProxyInstance;

public class DynamicProxy implements InvocationHandler {
  Object obj;

  public DynamicProxy(Object obj) {
    this.obj = obj;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    Object result = null;
    try {
      System.out.println("Proxy invocation.");
      result = method.invoke(obj, args);

    } catch (InvocationTargetException e) {
      throw e.getTargetException();
    } catch (Exception e) {
      throw e;
    }
    return result;
  }

  public static Object newInstance(Object obj) {
    return newProxyInstance(
        obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new DynamicProxy(obj));
  }
}
