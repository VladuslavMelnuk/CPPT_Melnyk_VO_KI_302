package KI302.Melnyk.Lab2;

/**
 * Class Screen describes a telephone screen.
 * It contains information about its diagonal, resolution, and state (on/off).
 */
public class Screen {
    private double diagonal;
    private String resolution;
    private boolean isTurnedOn;

    /**
     * Default constructor. Creates a screen with default parameters.
     */
    public Screen() {
        this.diagonal = 6.1; // Default diagonal in inches
        this.resolution = "1170x2532";
        this.isTurnedOn = false;
    }

    /**
     * Constructor with parameters.
     * @param diagonal Screen diagonal in inches.
     * @param resolution Screen resolution (e.g., "1920x1080").
     */
    public Screen(double diagonal, String resolution) {
        this.diagonal = diagonal;
        this.resolution = resolution;
        this.isTurnedOn = false;
    }

    public void turnOn() {
        isTurnedOn = true;
    }

    public void turnOff() {
        isTurnedOn = false;
    }

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public String getInfo() {
        return "Diagonal: " + diagonal + "\", Resolution: " + resolution;
    }
}