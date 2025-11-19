package parrot;

public class Parrot {

    // Constantes para evitar números mágicos
    private static final double BASE_SPEED = 12.0;
    private static final double LOAD_FACTOR = 9.0;
    private static final double MAX_NORWEGIAN_BLUE_SPEED = 24.0;

    private final ParrotTypeEnum type;
    private final int numberOfCoconuts;
    private final double voltage;
    private final boolean isNailed;

    // Construtor centralizado: mantido, mas agora apoiado por fábricas
    public Parrot(ParrotTypeEnum type, int numberOfCoconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.numberOfCoconuts = numberOfCoconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    // -----------------------------
    // Fábricas estáticas (melhoram assinatura e intenção)
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
    // Velocidade
    // -----------------------------

    // Nova assinatura mais clara
    public double calculateSpeed() {
        return switch (type) {
            case EUROPEAN -> getEuropeanSpeed();
            case AFRICAN -> getAfricanSpeed();
            case NORWEGIAN_BLUE -> getNorwegianBlueSpeed();
        };
    }

    // Metodo antigo mantido por compatibilidade com o código legado/testes
    @Deprecated
    public double getSpeed() {
        return calculateSpeed();
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

    // Nova assinatura mais expressiva
    public String getCrySound() {
        return switch (type) {
            case EUROPEAN -> getEuropeanCry();
            case AFRICAN -> getAfricanCry();
            case NORWEGIAN_BLUE -> getNorwegianBlueCry();
        };
    }

    // Metodo antigo mantido para compatibilidade
    @Deprecated
    public String getCry() {
        return getCrySound();
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