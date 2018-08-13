import java.io.Serializable;
import java.util.Objects;

public class SerialTest implements Serializable {
  private String textField;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SerialTest that = (SerialTest) o;
        return Objects.equals(textField, that.textField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textField);
    }

    public SerialTest(String textField) {
    this.textField = textField;
  }

  public SerialTest() {
    this.textField = "Some text";
  }

  public String getTextField() {
    return textField;
  }

  public void setTextField(String textField) {
    this.textField = textField;
  }
}
