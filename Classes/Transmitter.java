package Classes;

public class Transmitter extends Component {
    final double efficiency;

    public Transmitter (String name) {
        super(name);
        efficiency = 0.0;
    }

    public Transmitter (String name, double efficiency, String fileName) {
        super(name, fileName);
        this.efficiency = efficiency;
    }

    public double getEfficiency () {
        return this.efficiency;
    }

    public double calculatePowerOutput (double powerIn) {
        return powerIn * this.efficiency;
    }
}
