package Classes;

public class Transmitter extends Amplifier {
    int gain;

    public Transmitter () {
        super();
    }

    public Transmitter (String name) {
        super(name);
    }

    public Transmitter(String name, int gain) {
        super(name, gain);
    }
}
