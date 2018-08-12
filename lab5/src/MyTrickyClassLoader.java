import java.io.*;

public class MyTrickyClassLoader extends ClassLoader {

  private String path;

  public MyTrickyClassLoader(String path) {
    this.path = path;
  }

  @Override
  protected Class<?> findClass(String name) throws ClassNotFoundException {
    InputStream inputStream = null;
    try {
      String pathname = path + name + ".class";
      File classFile = new File(pathname);
      inputStream = new BufferedInputStream(new FileInputStream(classFile));

      byte[] bytes = new byte[(int) classFile.length()];
      inputStream.read(bytes);

      return defineClass(name, bytes, 0, bytes.length);

    } catch (Exception e) {
      e.printStackTrace();
      return super.findClass(name);
    } finally {
      try {
        inputStream.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
