package KI302.Melnyk.Lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A driver class to test the ExpressionCalculator.
 * It takes user input for 'x' and a filename, calculates the expression,
 * handles potential errors, and writes the result to a file.
 *
 * @author Vladyslav Melnyk
 * @version 1.0
 * @since version 1.0
 */
public class Lab4Driver {
    /**
     * The main method is the entry point of the program.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter fileWriter = null;
        
        try {
            // Створюємо об'єкт нашого калькулятора
            ExpressionCalculator calculator = new ExpressionCalculator();

            // Отримуємо дані від користувача
            System.out.print("Enter a value for X (in degrees): ");
            double x = scanner.nextDouble();

            System.out.print("Enter the filename to save the result: ");
            String fileName = scanner.next();
            
            fileWriter = new PrintWriter(new File(fileName));

            // Викликаємо метод обчислення
            double result = calculator.calculate(x);

            // Якщо все добре, виводимо результат і записуємо у файл
            System.out.println("Result: y = " + result);
            fileWriter.println("Input X (degrees): " + x);
            fileWriter.println("Result y = sin(x) / ctg(8x): " + result);

        } catch (CalculationException e) {
            // БЛОК 1: Ловимо НАШЕ власне виключення
            System.err.println("Calculation Error: " + e.getMessage());
            if (fileWriter != null) {
                fileWriter.println("Calculation Error: " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            // БЛОК 2: Ловимо помилку, якщо не вдалося створити файл
            System.err.println("File Error: Cannot create or write to the specified file.");
        } catch (Exception e) {
            // БЛОК 3: Ловимо будь-які інші непередбачувані помилки
            System.err.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            // БЛОК finally: цей код виконається ЗАВЖДИ
            System.out.println("Final block executed.");
            if (fileWriter != null) {
                fileWriter.close(); // Гарантовано закриваємо файл
            }
            scanner.close(); // Закриваємо сканер
        }
    }
}
//java -cp Lab4/bin KI302.Melnyk.Lab4.Lab4Driver