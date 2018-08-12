public class StringConcatMeasurement implements Measurement {
    @Override
    public void run() {
        "Measure ".concat("Time");
    }
}
