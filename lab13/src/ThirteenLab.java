import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ThirteenLab {
  public static void main(String[] args) {
    ThirteenLab lab = new ThirteenLab();

    lab.createFileWithDir(args[0], args[1]);
    lab.writeFileInDir(args[0], args[1]);
    lab.readFileInDir(args[0], args[1]);
    lab.deleteFileWithDir(args[0], args[1]);

    //    lab.writeFile(args[0], args[1]);
    //    lab.zipFile(args[0], args[1]);
    //    lab.deleteFile(args[0], args[1]);
    //    lab.unzipFile(args[0]);
    //    lab.readFile(args[0], args[1]);
  }

  // NIO
  private void createFileWithDir(String path, String name) {
    String dirPath = path + "/TestDir";
    Path toDir = Paths.get(dirPath);
    Path toFile = Paths.get(toDir + "/" + name + ".txt");
    try {
      Files.createDirectory(toDir);
      Files.createFile(toFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void writeFileInDir(String path, String name) {
    String text = "Some file's data:\n1) first line\n2) second line\n3) third line";
    Path toFile = Paths.get(path + "/TestDir/" + name + ".txt");
    byte[] bytes = text.getBytes();
    try {
      Files.write(toFile, bytes);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void readFileInDir(String path, String name) {
    Path toFile = Paths.get(path + "/TestDir/" + name + ".txt");
    try {
      System.out.println(Files.readAllLines(toFile));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void deleteFileWithDir(String path, String name) {
    Path toDir = Paths.get(path + "/TestDir");
    Path toFile = Paths.get(toDir + "/"+ name + ".txt");
    try {
      Files.delete(toFile);
      Files.delete(toDir);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // IO
  private void createFile(String path, String name) {
    File file = new File(path + "/" + name + ".txt");
    try {
      file.createNewFile();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void writeFile(String path, String name) {
    String text = "Some file's data:\n1) first line\n2) second line\n3) third line";
    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter(path + "/" + name + ".txt", true));
      writer.append(text);
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void readFile(String path, String name) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(path + "/" + name + ".txt"));
      List<String> lines = reader.lines().collect(Collectors.toList());
      System.out.println(lines);
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void deleteFile(String path, String name) {
    File file = new File(path + "/" + name + ".txt");
    file.delete();
  }

  private void zipFile(String path, String name) {
    String filePath = path + "/" + name + ".txt";
    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream("archive.zip");
      ZipOutputStream zipOut = new ZipOutputStream(fos);
      File fileToZip = new File(filePath);
      FileInputStream fis = new FileInputStream(fileToZip);
      ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
      zipOut.putNextEntry(zipEntry);
      final byte[] bytes = new byte[1024];
      int length;
      while ((length = fis.read(bytes)) >= 0) {
        zipOut.write(bytes, 0, length);
      }
      zipOut.close();
      fis.close();
      fos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void unzipFile(String path) {
    String zipFile = "archive.zip";
    byte[] buffer = new byte[1024];
    ZipInputStream zis = null;
    try {
      zis = new ZipInputStream(new FileInputStream(zipFile));
      ZipEntry entry = zis.getNextEntry();
      while (entry != null) {
        String fileName = entry.getName();
        File newFile = new File(path + "/" + fileName);
        FileOutputStream fos = new FileOutputStream(newFile);
        int len;
        while ((len = zis.read(buffer)) > 0) {
          fos.write(buffer, 0, len);
        }
        fos.close();
        entry = zis.getNextEntry();
      }
      zis.closeEntry();
      zis.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
