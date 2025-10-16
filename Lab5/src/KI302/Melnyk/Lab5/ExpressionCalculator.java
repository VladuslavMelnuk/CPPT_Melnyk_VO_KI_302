package KI302.Melnyk.Lab5;

import java.io.*;
import java.util.Scanner;
import static java.lang.Math.*;

/**
 * A class for calculating the expression y = sin(x) / ctg(8x) and
 * handling file I/O for the result.
 *
 * @author Vladyslav Melnyk
 * @version 2.0
 * @since version 1.0
 */
public class ExpressionCalculator {

    private double result;

    /**
     * Calculates the value of the expression y = sin(x) / ctg(8x).
     * The result is stored in the 'result' field.
     *
     * @param x The input value in degrees.
     * @throws CalculationException if the denominator (ctg(8x)) is zero.
     */
    public void calculate(double x) throws CalculationException {
        double radiansX = toRadians(x);
        double radians8X = toRadians(8 * x);

        double numerator = sin(radiansX);
        double denominator = 1.0 / tan(radians8X);

        if (abs(denominator) < 1E-12) {
            throw new CalculationException("Error: Division by zero. ctg(8x) is zero for x = " + x);
        }

        this.result = numerator / denominator;
    }
    
    /**
     * Returns the last calculated result.
     * @return The result.
     */
    public double getResult() {
        return this.result;
    }

    /**
     * Writes the result to a text file.
     * @param fName The name of the text file.
     * @throws FileNotFoundException If the file cannot be created.
     */
    public void writeResTxt(String fName) throws FileNotFoundException {
        PrintWriter f = new PrintWriter(fName);
        f.printf("%f", result);
        f.close();
    }

    /**
     * Reads the result from a text file.
     * @param fName The name of the text file.
     */
    public void readResTxt(String fName) {
        try {
            File f = new File(fName);
            if (f.exists()) {
                Scanner s = new Scanner(f);
                result = s.nextDouble();
                s.close();
            } else {
                throw new FileNotFoundException("File " + fName + " not found");
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Writes the result to a binary file.
     * @param fName The name of the binary file.
     * @throws IOException If an I/O error occurs.
     */
    public void writeResBin(String fName) throws IOException {
        DataOutputStream f = new DataOutputStream(new FileOutputStream(fName));
        f.writeDouble(result);
        f.close();
    }

    /**
     * Reads the result from a binary file.
     * @param fName The name of the binary file.
     * @throws IOException If an I/O error occurs.
     */
    public void readResBin(String fName) throws IOException {
        DataInputStream f = new DataInputStream(new FileInputStream(fName));
        result = f.readDouble();
        f.close();
    }
}