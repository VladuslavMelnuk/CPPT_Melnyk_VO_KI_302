package KI302.Melnyk.Lab3;

import java.io.FileNotFoundException;

/**
 * Driver class to demonstrate the functionality of the MobilePhone class.
 *
 * @author Vladyslav Melnyk
 * @version 1.0
 * @since version 2.0
 */
public class Lab3Driver {
    /**
     * The main method is the entry point of the program.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            // Створюємо об'єкт нашого нового класу MobilePhone
            MobilePhone myMobile = new MobilePhone("Samsung Galaxy S23", new Screen(6.1, "2340x1080"), new Battery(3900), new SimCard("Lifecell", "+380631112233"), true);

            // Демонструємо успадковані методи від Telephone
            System.out.println("--- Testing inherited methods ---");
            myMobile.turnOn();
            myMobile.makeCall("+380987654321");
            System.out.println("Current battery: " + myMobile.getBatteryLevel() + "%");
            myMobile.turnOff();
            
            System.out.println("\n--- Testing new MobilePhone methods ---");
            // Демонструємо нові, власні методи MobilePhone
            myMobile.connectToWifi("MyHomeNetwork");

            // Демонструємо метод, реалізований з інтерфейсу Camera
            System.out.println("\n--- Testing implemented interface method ---");
            myMobile.takePhoto();

            // Демонструємо перевизначений (overridden) метод
            System.out.println("\n--- Testing overridden method ---");
            myMobile.getFullPhoneInfo();

            //Завершуємо роботу з файлом логів
            myMobile.dispose();
            System.out.println("\nProgram finished. Check 'telephone_log_v3.txt' for details.");

        } catch (FileNotFoundException e) {
            System.err.println("Error: Could not create or write to the log file.");
            e.printStackTrace();
        }
    }
}
//java -cp Lab3/bin KI302.Melnyk.Lab3.Lab3Driver