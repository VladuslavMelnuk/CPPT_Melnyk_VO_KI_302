package KI302.Melnyk.Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class Telephone represents a telephone. It includes components like Screen, Battery, and SimCard.
 * The class logs its activities to a file named "telephone_log.txt".
 *
 * @author Vladyslav Melnyk
 * @version 1.0
 * @since version 1.0
 */
public class Telephone {
    private String modelName;
    private Screen screen;
    private Battery battery;
    private SimCard simCard;
    private PrintWriter logFile;

    /**
     * Default constructor. Creates a default phone and initializes the log file.
     * @throws FileNotFoundException if the log file cannot be created.
     */
    public Telephone() throws FileNotFoundException {
        this.modelName = "UnknownPhone";
        this.screen = new Screen();
        this.battery = new Battery();
        this.simCard = new SimCard();
        this.logFile = new PrintWriter(new File("telephone_log.txt"));
        log("A default telephone was created.");
    }

    /**
     * Constructor with parameters. Creates a custom phone and initializes the log file.
     * @param modelName The model name of the phone.
     * @param screen The screen object for the phone.
     * @param battery The battery object for the phone.
     * @param simCard The SIM card object for the phone.
     * @throws FileNotFoundException if the log file cannot be created.
     */
    public Telephone(String modelName, Screen screen, Battery battery, SimCard simCard) throws FileNotFoundException {
        this.modelName = modelName;
        this.screen = screen;
        this.battery = battery;
        this.simCard = simCard;
        this.logFile = new PrintWriter(new File("telephone_log.txt"));
        log("A custom telephone '" + modelName + "' was created.");
    }

    // Method 1
    public void turnOn() {
        if (!screen.isTurnedOn()) {
            screen.turnOn();
            log("Phone screen turned ON.");
        } else {
            log("Attempted to turn on the screen, but it's already on.");
        }
    }

    // Method 2
    public void turnOff() {
        if (screen.isTurnedOn()) {
            screen.turnOff();
            log("Phone screen turned OFF.");
        } else {
            log("Attempted to turn off the screen, but it's already off.");
        }
    }

    // Method 3
    public void makeCall(String number) {
        if (screen.isTurnedOn() && battery.getChargeLevel() > 5) {
            battery.discharge(5);
            log("Making a call to " + number + ". Battery level is now " + battery.getChargeLevel() + "%.");
        } else {
            log("Call failed. Either screen is off or battery is too low.");
        }
    }

    // Method 4
    public void sendSms(String number, String message) {
        if (screen.isTurnedOn() && battery.getChargeLevel() > 2) {
            battery.discharge(2);
            log("Sending SMS to " + number + ": '" + message + "'. Battery level is now " + battery.getChargeLevel() + "%.");
        } else {
            log("SMS failed. Either screen is off or battery is too low.");
        }
    }

    // Method 5
    public void chargePhone() {
        int oldCharge = battery.getChargeLevel();
        battery.charge();
        log("Charging the phone. Battery level changed from " + oldCharge + "% to " + battery.getChargeLevel() + "%.");
    }

    // Method 6
    public int getBatteryLevel() {
        log("Checked battery level: " + battery.getChargeLevel() + "%.");
        return battery.getChargeLevel();
    }
    
    // Method 7
    public String getScreenStatus() {
        String status = screen.isTurnedOn() ? "ON" : "OFF";
        log("Checked screen status: " + status);
        return status;
    }

    // Method 8
    public String getSimCardInfo() {
        log("Retrieved SIM card info.");
        return simCard.getInfo();
    }
    
    // Method 9
    public String getModelName() {
        log("Retrieved model name: " + this.modelName);
        return this.modelName;
    }
    
    // Method 10
    public void getFullPhoneInfo() {
        log("Displaying full phone info.");
        System.out.println("====================");
        System.out.println("Model: " + this.modelName);
        System.out.println("Screen: " + screen.getInfo());
        System.out.println("Battery: " + battery.getInfo());
        System.out.println("SIM Card: " + simCard.getInfo());
        System.out.println("====================");
    }
    
    // Method to log activities
    private void log(String message) {
        logFile.println("[LOG] " + message);
        logFile.flush();
    }
    
    /**
     * Method to correctly close the log file and release resources.
     */
    public void dispose() {
        log("Disposing phone object. Closing log file.");
        logFile.close();
    }
}