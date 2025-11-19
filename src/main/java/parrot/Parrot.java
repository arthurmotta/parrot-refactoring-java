package parrot;

public class Parrot {

    // Constantes para evitar "números mágicos"
    private static final double BASE_SPEED = 12.0;
    private static final double LOAD_FACTOR = 9.0;
    private static final double MAX_NORWEGIAN_BLUE_SPEED = 24.0;

    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    // -----------------------------
    // Velocidade
    // -----------------------------
    public double getSpeed() {
        return switch (type) {
            case EUROPEAN -> getEuropeanSpeed();
            case AFRICAN -> getAfricanSpeed();
            case NORWEGIAN_BLUE -> getNorwegianBlueSpeed();
        };
    }

    private double getEuropeanSpeed() {
        return getBaseSpeed();
    }

    private double getAfricanSpeed() {
        double baseSpeed = getBaseSpeed();
        double load = getLoadFactor() * numberOfCoconuts;
        double adjustedSpeed = baseSpeed - load;

        return Math.max(0, adjustedSpeed);
    }

    private double getNorwegianBlueSpeed() {
        if (isNailed) {
            return 0;
        }
        return getBaseSpeed(voltage);
    }

    private double getBaseSpeed(double voltage) {
        double calculatedSpeed = voltage * getBaseSpeed();
        return Math.min(MAX_NORWEGIAN_BLUE_SPEED, calculatedSpeed);
    }

    private double getLoadFactor() {
        return LOAD_FACTOR;
    }

    private double getBaseSpeed() {
        return BASE_SPEED;
    }

    // -----------------------------
    // Grito
    // -----------------------------
    public String getCry() {
        return switch (type) {
            case EUROPEAN -> getEuropeanCry();
            case AFRICAN -> getAfricanCry();
            case NORWEGIAN_BLUE -> getNorwegianBlueCry();
        };
    }

    private String getEuropeanCry() {
        return "Sqoork!";
    }

    private String getAfricanCry() {
        return "Sqaark!";
    }

    private String getNorwegianBlueCry() {
        boolean hasVoltage = voltage > 0;
        return hasVoltage ? "Bzzzzzz" : "...";
    }
}
