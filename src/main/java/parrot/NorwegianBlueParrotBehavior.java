package parrot;

public class NorwegianBlueParrotBehavior implements ParrotBehavior {

    private static final double BASE_SPEED = 12.0;
    private static final double MAX_SPEED = 24.0;

    @Override
    public double calculateSpeed(int numberOfCoconuts, double voltage, boolean isNailed) {
        if (isNailed) {
            return 0;
        }

        double calculatedSpeed = voltage * BASE_SPEED;
        return Math.min(MAX_SPEED, calculatedSpeed);
    }

    @Override
    public String getCry(double voltage) {
        boolean hasVoltage = voltage > 0;
        return hasVoltage ? "Bzzzzzz" : "...";
    }
}
