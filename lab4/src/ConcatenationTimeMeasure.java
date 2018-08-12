/**
 * Проверка скорости работы String и StringBuffer
 */
public class ConcatenationTimeMeasure {
    private static long start, stop;

    public static void main(String[] args) {
        start = System.nanoTime();
        new StringBufferMeasurement().run(); // подставить сюда нужный класс из package
        stop = System.nanoTime();
        System.out.println("Time: " + (stop - start));
    }
}
