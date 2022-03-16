package Classes;

public class SignalGenerator extends PowerSource {
    public static final double FREQUENCY = 2.45;

    public SignalGenerator() {
        super();
    }

    public SignalGenerator(String name) {
        super(name);
    }

    public SignalGenerator(double power) {
        super(power);
    }
    
    public SignalGenerator(String name, double power) {
        super(name, power);
    }

    public double getFrequency() {
        return FREQUENCY;
    }
}

