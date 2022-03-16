package Classes;

public class PowerSource extends Component {
    double power;

    public PowerSource () {
        super();

        power = 0.0;
    }

    public PowerSource (String name) {
        super(name);

        power = 0.0;
    }

    public PowerSource (double power) {
        this.power = power;
    }

    public PowerSource (String name, double power) {
        super(name);

        this.power = power;
    }

    public void setPower (double power) {
        this.power = power;
    }

    public double getPower () {
        return this.power;
    }
}
