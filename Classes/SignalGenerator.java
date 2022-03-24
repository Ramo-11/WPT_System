package Classes;

public class SignalGenerator extends Component {
    static final double FREQUENCY = 2.45;
    final double power;

    public SignalGenerator (String name) {
        super(name);
        power = 0.0;
    }

    public SignalGenerator (String name, double power) {
        super(name);
        this.power = power;
    }

    public SignalGenerator (String name, double power, String fileName) {
        super(name, fileName);
        this.power = power;
    }

    public double getPower () {
        return this.power;
    }

    public double getFrequency () {
        return FREQUENCY;
    }
}

