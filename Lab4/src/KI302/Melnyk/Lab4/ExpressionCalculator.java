package KI302.Melnyk.Lab4;

import static java.lang.Math.*;

/**
 * A class for calculating the expression y = sin(x) / ctg(8x).
 * It handles potential calculation errors by throwing a custom exception.
 *
 * @author Vladyslav Melnyk
 * @version 1.0
 * @since version 1.0
 */
public class ExpressionCalculator {

    /**
     * Calculates the value of the expression y = sin(x) / ctg(8x).
     *
     * @param x The input value in degrees.
     * @return The result of the calculation.
     * @throws CalculationException if the denominator (ctg(8x)) is zero.
     */
    public double calculate(double x) throws CalculationException {
        double radiansX = toRadians(x);
        double radians8X = toRadians(8 * x);

        double numerator = sin(radiansX);
        double denominator = 1.0 / tan(radians8X); // ctg(a) = 1 / tan(a)

        // Перевіряємо умову, яка може призвести до помилки
        if (abs(denominator) < 1E-12) { // Порівнюємо з дуже малим числом, щоб уникнути проблем з точністю
            // Якщо знаменник дорівнює нулю, "викидаємо" наше власне виключення
            throw new CalculationException("Error: Division by zero. ctg(8x) is zero for x = " + x);
        }

        return numerator / denominator;
    }
}