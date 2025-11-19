package parrot;

public class AfricanParrotBehavior implements ParrotBehavior {

    private static final double BASE_SPEED = 12.0;
    private static final double LOAD_FACTOR = 9.0;

    @Override
    public double calculateSpeed(int numberOfCoconuts, double voltage, boolean isNailed) {
        double load = LOAD_FACTOR * numberOfCoconuts;
        double adjustedSpeed = BASE_SPEED - load;
        return Math.max(0, adjustedSpeed);
    }

    @Override
    public String getCry(double voltage) {
        return "Sqaark!";
    }
}