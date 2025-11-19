package parrot;

public class Parrot {

    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

    private final ParrotBehavior behavior;

    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
        this.behavior = createBehavior(type);
    }

    // -----------------------------
    // Fábricas estáticas (do item 4)
    // -----------------------------

    public static Parrot europeanParrot() {
        return new Parrot(ParrotTypeEnum.EUROPEAN, 0, 0.0, false);
    }

    public static Parrot africanParrotWithCoconuts(int numberOfCoconuts) {
        return new Parrot(ParrotTypeEnum.AFRICAN, numberOfCoconuts, 0.0, false);
    }

    public static Parrot norwegianBlueParrot(double voltage, boolean isNailed) {
        return new Parrot(ParrotTypeEnum.NORWEGIAN_BLUE, 0, voltage, isNailed);
    }

    // -----------------------------
    // Delegação de comportamento
    // -----------------------------

    public double calculateSpeed() {
        return behavior.calculateSpeed(numberOfCoconuts, voltage, isNailed);
    }

    @Deprecated
    public double getSpeed() {
        return calculateSpeed();
    }

    public String getCrySound() {
        return behavior.getCry(voltage);
    }

    @Deprecated
    public String getCry() {
        return getCrySound();
    }

    // -----------------------------
    // Fábrica interna de comportamento
    // -----------------------------

    private ParrotBehavior createBehavior(ParrotTypeEnum type) {
        return switch (type) {
            case EUROPEAN -> new EuropeanParrotBehavior();
            case AFRICAN -> new AfricanParrotBehavior();
            case NORWEGIAN_BLUE -> new NorwegianBlueParrotBehavior();
        };
    }
}