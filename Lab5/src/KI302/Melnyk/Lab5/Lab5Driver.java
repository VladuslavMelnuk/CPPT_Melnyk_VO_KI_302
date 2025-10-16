package KI302.Melnyk.Lab5;

import java.io.IOException;
import java.util.Scanner;

/**
 * A driver class to test the ExpressionCalculator's file I/O capabilities.
 *
 * @author Vladyslav Melnyk
 * @version 1.0
 * @since version 1.0
 */
public class Lab5Driver {
    /**
     * The main method is the entry point of the program.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            ExpressionCalculator calculator = new ExpressionCalculator();
            
            System.out.print("Enter a value for X (in degrees): ");
            double x = scanner.nextDouble();
            
            calculator.calculate(x);
            System.out.println("Calculated result: " + calculator.getResult());

            String textFileName = "TextResult.txt";
            calculator.writeResTxt(textFileName);
            System.out.println("\nResult saved to " + textFileName);

            calculator.readResTxt(textFileName);
            System.out.println("Result read from " + textFileName + ": " + calculator.getResult());

            String binFileName = "BinaryResult.bin";
            calculator.writeResBin(binFileName);
            System.out.println("\nResult saved to " + binFileName);

            calculator.readResBin(binFileName);
            System.out.println("Result read from " + binFileName + ": " + calculator.getResult());
        } catch (CalculationException | IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
//java -cp Lab5/bin KI302.Melnyk.Lab5.Lab5Driver