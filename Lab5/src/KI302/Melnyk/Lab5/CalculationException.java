package KI302.Melnyk.Lab5;

/**
 * A custom exception class for handling calculation errors.
 * Extends ArithmeticException.
 *
 * @author Vladyslav Melnyk
 * @version 1.0
 * @since version 1.0
 */
public class CalculationException extends ArithmeticException {
    /**
     * Default constructor.
     */
    public CalculationException() {
        super();
    }

    /**
     * Constructor that takes a custom error message.
     * @param message The detailed error message.
     */
    public CalculationException(String message) {
        super(message);
    }
}