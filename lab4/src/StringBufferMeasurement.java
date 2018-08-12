public class StringBufferMeasurement implements Measurement {
    @Override
    public void run() {
        new StringBuffer("Measure ").append(new StringBuffer("Time"));
    }
}
