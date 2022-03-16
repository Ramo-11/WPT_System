package Classes;

public class Amplifier extends Component {
    int gain;

    public Amplifier () {
        super();
    }

    public Amplifier (String name) {
        super(name);
    }

    public Amplifier (String name, int gain) {
        super(name);

        this.gain = gain;
    }

    public void setGain (int gain) {
        this.gain = gain;
    }

    public int getGain () {
        return this.gain;
    }
}
