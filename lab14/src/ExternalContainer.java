import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ExternalContainer implements Externalizable {

  private List<ExternalTest> externalTests;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExternalContainer that = (ExternalContainer) o;
    return Objects.equals(externalTests, that.externalTests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalTests);
  }

  public ExternalContainer() {
    this.externalTests = new LinkedList<>();
  }

  public void addItem(ExternalTest test) {
    this.externalTests.add(test);
  }

  public ExternalTest getItem(int index) {
    return this.externalTests.get(index);
  }

  @Override
  public void writeExternal(ObjectOutput out) throws IOException {
    out.writeInt(externalTests.size());
    for (ExternalTest ext : externalTests) {
      out.writeObject(ext);
    }
  }

  @Override
  public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    int counter = in.readInt();
    for (int i = 0; i < counter; i++) {
      ExternalTest et = (ExternalTest) in.readObject();
      externalTests.add(et);
    }
  }
}
