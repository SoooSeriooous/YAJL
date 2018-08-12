import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/** пример работы с регулярными выражениями */
public class RegularExpression {
  public static void main(String[] args) {
    String firstString = "Some analysis data for tests";
    String secondString = "123abc456def";

    Pattern pattern = compile("[analysis]");
    Matcher matcher = pattern.matcher(firstString);
    boolean isInString = matcher.find(); // поиск слова analysis в предложении
    System.out.println(isInString);

    pattern = compile("\\d{3}"); // три числа подряд
    String[] result = pattern.split(secondString); // разбиваем на подстроки
    for (String elem : result) {
      System.out.print(elem);
    }

    pattern = compile("[[a-zA-Z]]{3}$"); // 3 буквенны[ символа в конце строки
    matcher = pattern.matcher(secondString);
    secondString = matcher.replaceAll("!!!"); // заменяем на !!!
    System.out.println("\n" + secondString);
  }
}
