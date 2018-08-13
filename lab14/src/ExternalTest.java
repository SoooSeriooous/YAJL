import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Objects;

public class ExternalTest implements Externalizable {
  private String textField;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExternalTest that = (ExternalTest) o;
    return Objects.equals(textField, that.textField);
  }

  @Override
  public int hashCode() {
    return Objects.hash(textField);
  }

  public ExternalTest(String textField) {
    this.textField = textField;
  }

  public ExternalTest() {
    this.textField = "Some text";
  }

  public String getTextField() {
    return textField;
  }

  public void setTextField(String textField) {
    this.textField = textField;
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeUTF(textField);
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
      this.textField = in.readUTF();
  }
}
