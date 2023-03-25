package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Locale;

public interface Calculatable {
    default void writeToCSV(double initialX, double finalX, double eps, double step, String filePath) {
        String csvString;
        BigDecimal res;
        try(PrintStream printStream = new PrintStream(new FileOutputStream(filePath))) {
            for (double i = initialX; i < finalX; i += step) {
                res = calculate(i, eps);
                csvString = String.format(Locale.US, "%f%s %f\n", i, ',', res);
                printStream.print(csvString);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    BigDecimal calculate(double i, double eps);
}
