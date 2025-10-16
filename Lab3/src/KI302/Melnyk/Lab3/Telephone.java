package KI302.Melnyk.Lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Abstract Class Telephone represents a generic telephone. 
 * It serves as a base for more specific types of phones.
 *
 * @author Vladyslav Melnyk
 * @version 2.0
 * @since version 1.0
 */
public abstract class Telephone { 
    private String modelName;
    private Screen screen;
    private Battery battery;
    private SimCard simCard;
    private PrintWriter logFile;

    public Telephone() throws FileNotFoundException {
        this.modelName = "UnknownPhone";
        this.screen = new Screen();
        this.battery = new Battery();
        this.simCard = new SimCard();
        this.logFile = new PrintWriter(new File("telephone_log_v3.txt")); // Змінимо назву файлу логів для 3 лаби
        log("A default telephone was created.");
    }

    public Telephone(String modelName, Screen screen, Battery battery, SimCard simCard) throws FileNotFoundException {
        this.modelName = modelName;
        this.screen = screen;
        this.battery = battery;
        this.simCard = simCard;
        this.logFile = new PrintWriter(new File("telephone_log_v3.txt"));
        log("A custom telephone '" + modelName + "' was created.");
    }

    /**
     * Abstract method to get the connection type of the phone.
     * Must be implemented by subclasses.
     * @return A string describing the connection type.
     */
    public abstract String getConnectionType();


    
    public void turnOn() {
        if (!screen.isTurnedOn()) {
            screen.turnOn();
            log("Phone screen turned ON.");
        } else {
            log("Attempted to turn on the screen, but it's already on.");
        }
    }

    public void turnOff() {
        if (screen.isTurnedOn()) {
            screen.turnOff();
            log("Phone screen turned OFF.");
        } else {
            log("Attempted to turn off the screen, but it's already off.");
        }
    }

    public void makeCall(String number) {
        if (screen.isTurnedOn() && battery.getChargeLevel() > 5) {
            battery.discharge(5);
            log("Making a call to " + number + ". Battery level is now " + battery.getChargeLevel() + "%.");
        } else {
            log("Call failed. Either screen is off or battery is too low.");
        }
    }

    public void sendSms(String number, String message) {
        if (screen.isTurnedOn() && battery.getChargeLevel() > 2) {
            battery.discharge(2);
            log("Sending SMS to " + number + ": '" + message + "'. Battery level is now " + battery.getChargeLevel() + "%.");
        } else {
            log("SMS failed. Either screen is off or battery is too low.");
        }
    }

    public void chargePhone() {
        int oldCharge = battery.getChargeLevel();
        battery.charge();
        log("Charging the phone. Battery level changed from " + oldCharge + "% to " + battery.getChargeLevel() + "%.");
    }

    public int getBatteryLevel() {
        log("Checked battery level: " + battery.getChargeLevel() + "%.");
        return battery.getChargeLevel();
    }
    
    public String getScreenStatus() {
        String status = screen.isTurnedOn() ? "ON" : "OFF";
        log("Checked screen status: " + status);
        return status;
    }

    public String getSimCardInfo() {
        log("Retrieved SIM card info.");
        return simCard.getInfo();
    }
    
    public String getModelName() {
        log("Retrieved model name: " + this.modelName);
        return this.modelName;
    }
    
    public void getFullPhoneInfo() {
        log("Displaying full phone info.");
        System.out.println("====================");
        System.out.println("Model: " + this.modelName);
        System.out.println("Screen: " + screen.getInfo());
        System.out.println("Battery: " + battery.getInfo());
        System.out.println("SIM Card: " + simCard.getInfo());
        System.out.println("Connection: " + this.getConnectionType()); 
        System.out.println("====================");
    }
    
    protected void log(String message) {
        logFile.println("[LOG] " + message);
        logFile.flush();
    }
    
    public void dispose() {
        log("Disposing phone object. Closing log file.");
        logFile.close();
    }
}