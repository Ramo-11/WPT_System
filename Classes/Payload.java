package Classes;

public class Payload extends Component {
    double powerReceived;
    final double requiredPower; 

    public Payload (String name) {
        super (name);
        powerReceived = 0;
        requiredPower = 0;
    }

    public Payload (String name, double requiredPower, String fileName) {
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
