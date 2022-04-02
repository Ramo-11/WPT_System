package Classes;

public class Load extends Component {
    double powerReceived;
    final double requiredPower; 

    public Load (String name) {
        super (name);
        powerReceived = 0;
        requiredPower = 0;
    }

    public Load (String name, double requiredPower, String fileName) {
        super (name, fileName);
        powerReceived = 0;
        this.requiredPower = requiredPower;
    }

    public void setPowerReceived (double powerReceived) {
        this.powerReceived = powerReceived;
    }

    public double getReceivedPower () {
        return this.powerReceived;
    }

    public double getRequiredPower () {
        return this.requiredPower;
    }
}
