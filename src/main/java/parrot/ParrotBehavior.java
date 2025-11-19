package parrot;

public interface ParrotBehavior {

    double calculateSpeed(int numberOfCoconuts, double voltage, boolean isNailed);

    String getCry(double voltage);
}