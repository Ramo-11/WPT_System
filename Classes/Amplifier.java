package Classes;

import javax.swing.ImageIcon;

public class Amplifier extends Component {
    int gain;

    public Amplifier () {
        super();

        gain = 0;
    }

    public Amplifier (String name) {
        super(name);

        gain = 0;
    }

    public Amplifier (String name, int gain, String fileName) {
        super(name);

        this.gain = gain;
        this.image = new ImageIcon(fileName);
    }

    public void setGain (int gain) {
        this.gain = gain;
    }

    public int getGain () {
        return this.gain;
    }

    public double calculatePowerOutput (double powerIn) {
        double powerOut = powerIn * Math.pow(10, (gain/10));

        return powerOut;
    }
}
