package parrot;

public class EuropeanParrotBehavior implements ParrotBehavior {

    private static final double BASE_SPEED = 12.0;

    @Override
    public double calculateSpeed(int numberOfCoconuts, double voltage, boolean isNailed) {
        return BASE_SPEED;
    }

    @Override
    public String getCry(double voltage) {
        return "Sqoork!";
    }
}