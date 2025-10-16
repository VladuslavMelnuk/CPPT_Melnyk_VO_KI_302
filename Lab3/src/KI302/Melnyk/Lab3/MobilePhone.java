package KI302.Melnyk.Lab3;

import java.io.FileNotFoundException;

/**
 * Class MobilePhone represents a specific type of telephone that extends the abstract Telephone class
 * and implements the Camera interface.
 *
 * @author Vladyslav Melnyk
 * @version 1.0
 * @since version 2.0
 */
public class MobilePhone extends Telephone implements Camera {
    
    private boolean hasTouchScreen;

    public MobilePhone() throws FileNotFoundException {
        super();
        this.hasTouchScreen = true;
        log("MobilePhone default constructor called.");
    }

    public MobilePhone(String modelName, Screen screen, Battery battery, SimCard simCard, boolean hasTouchScreen) throws FileNotFoundException {
        super(modelName, screen, battery, simCard);
        this.hasTouchScreen = hasTouchScreen;
        log("MobilePhone parameterized constructor called.");
    }

    @Override
    public String getConnectionType() {
        return "Mobile Network (4G/5G)";
    }
    
    /**
     * Implementation of the takePhoto method from the Camera interface.
     * Simulates taking a photo.
     */
    @Override
    public void takePhoto() {
        log("Taking a photo with the mobile phone's camera.");
        System.out.println("Click! Photo taken.");
    }

    public void connectToWifi(String networkName) {
        log("Connecting to Wi-Fi network: " + networkName);
        System.out.println("Successfully connected to " + networkName);
    }

    @Override
    public void getFullPhoneInfo() {
        super.getFullPhoneInfo();
        System.out.println("Touch Screen: " + (hasTouchScreen ? "Yes" : "No"));
        log("Displayed full info for MobilePhone.");
    }
}