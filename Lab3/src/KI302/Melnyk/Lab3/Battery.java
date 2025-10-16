package KI302.Melnyk.Lab3;

/**
 * Class Battery describes a telephone battery.
 * It contains information about its capacity and current charge level.
 */
public class Battery {
    private int capacityMah;
    private int chargeLevelPercent;

    /**
     * Default constructor. Creates a battery with default parameters.
     */
    public Battery() {
        this.capacityMah = 4000;
        this.chargeLevelPercent = 100;
    }

    /**
     * Constructor with parameters.
     * @param capacityMah Battery capacity in mAh.
     */
    public Battery(int capacityMah) {
        this.capacityMah = capacityMah;
        this.chargeLevelPercent = 100;
    }

    public void charge() {
        if (this.chargeLevelPercent < 100) {
            this.chargeLevelPercent += 10;
            if (this.chargeLevelPercent > 100) {
                this.chargeLevelPercent = 100;
            }
        }
    }

    public void discharge(int amount) {
        if (this.chargeLevelPercent > 0) {
            this.chargeLevelPercent -= amount;
            if (this.chargeLevelPercent < 0) {
                this.chargeLevelPercent = 0;
            }
        }
    }

    public int getChargeLevel() {
        return chargeLevelPercent;
    }
    
    public String getInfo() {
        return "Capacity: " + capacityMah + "mAh, Charge: " + chargeLevelPercent + "%";
    }
}