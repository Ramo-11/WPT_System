package GUI.Panels;

import Classes.*;
import GUI.Labels.*;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.awt.Color;

public class ResultsPanels extends Panel {
    ArrayList<Label> labels;

    public ResultsPanels (LayoutManager layout) {
        super (layout);
        labels = new ArrayList<>();
        setBackground(new Color(200, 200, 200));
    }

    public void startResultsPanel (SignalGenerator sg, Amplifier amp, Transmitter t, Receiver r, Payload p) {
        labels.add(new Label("Power before amplifier = " + sg.getPower() + " W"));
        labels.add(new Label("Power after amplifier = " + amp.calculatePowerOutput(sg.getPower()) + " W"));
        labels.add(new Label("Power after transmitter = " + t.calculatePowerOutput(amp.calculatePowerOutput(sg.getPower())) + " W"));
        labels.add(new Label("Power after receiver = " + r.calculatePowerOutput(t.calculatePowerOutput(amp.calculatePowerOutput(sg.getPower()))) + " W"));
        
        p.setPowerReceived(r.calculatePowerOutput(t.calculatePowerOutput(amp.calculatePowerOutput(sg.getPower()))));
        double pReceivedMinusRequired = p.getReceivedPower() - p.getRequiredPower();
        if(pReceivedMinusRequired >= 0 && pReceivedMinusRequired > 50) {
            labels.add(new Label("Too much power has been supplied to the paylaod"));
        }
        else if (pReceivedMinusRequired <= 0) {
            labels.add(new Label("Not enought power has been sent to the paylaod"));
        }
        else {
            labels.add(new Label("Payload is operating perfectly"));
        }

        addLabels();
    }

    public void addLabels() {
        for (Label l : labels)
            addLabel(l);
    }

}
