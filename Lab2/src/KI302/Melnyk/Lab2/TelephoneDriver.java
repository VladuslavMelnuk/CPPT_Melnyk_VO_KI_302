package KI302.Melnyk.Lab2;

import java.io.FileNotFoundException;

/**
 * This is a driver class to test the Telephone class functionality.
 *
 * @author Vladyslav Melnyk
 * @version 1.0
 * @since version 1.0
 */
public class TelephoneDriver {
    /**
     * The main method is the entry point of the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Створюємо телефон з параметрами
            Screen customScreen = new Screen(6.7, "2778x1284");
            Battery customBattery = new Battery(5000);
            SimCard customSim = new SimCard("Vodafone", "+380991234567");
            
            Telephone myPhone = new Telephone("iPhone 15 Pro", customScreen, customBattery, customSim);

            // Демонструємо роботу методів
            myPhone.getFullPhoneInfo();
            
            myPhone.turnOn();
            myPhone.makeCall("+380507654321");
            myPhone.sendSms("+380679876543", "Hello from Java Lab!");
            
            System.out.println("Current battery level: " + myPhone.getBatteryLevel() + "%");
            
            myPhone.chargePhone();
            
            System.out.println("Screen status is: " + myPhone.getScreenStatus());
            
            myPhone.turnOff();
            
            System.out.println("Screen status now is: " + myPhone.getScreenStatus());

            // Важливо! Завершуємо роботу з файлом логів
            myPhone.dispose();
            System.out.println("\nLog file 'telephone_log.txt' has been created/updated.");

        } catch (FileNotFoundException e) {
            System.err.println("Error: Could not create or write to the log file.");
            e.printStackTrace();
        }
    }
}