package KI302.Melnyk.Lab2;

/**
 * Class SimCard describes a SIM card.
 * It contains information about the mobile operator and phone number.
 */
public class SimCard {
    private String operator;
    private String phoneNumber;

    /**
     * Default constructor. Creates a SIM card with default parameters.
     */
    public SimCard() {
        this.operator = "Kyivstar";
        this.phoneNumber = "+380000000000";
    }

    /**
     * Constructor with parameters.
     * @param operator The mobile operator.
     * @param phoneNumber The phone number.
     */
    public SimCard(String operator, String phoneNumber) {
        this.operator = operator;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getInfo() {
        return "Operator: " + operator + ", Number: " + phoneNumber;
    }
}