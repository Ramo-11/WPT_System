package GUI.Panels;

import Classes.*;
import GUI.Buttons.*;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.awt.Color;

public class ResultsPanels extends Panel {
    ArrayList<Button> buttons;

    public ResultsPanels (LayoutManager layout) {
        super (layout);
        buttons = new ArrayList<>();
        setBackground(new Color(200, 200, 200));
    }

    public void startResultsPanel (PowerSource ps, SignalGenerator sg, Amplifier amp, Transmitter t, Receiver r, Load l) {
        
        buttons.add(new Button("Power = " + String.format("%.5f", sg.getPower()) + " W", sg.getImage()));
        
        // No amplifier was picked
        if(amp.getName().equals("")) {
            buttons.add(new Button("Power = " + String.format("%.5f", t.calculatePowerOutput(sg.getPower())) + " W", t.getImage()));
            buttons.add(new Button("Power = " + String.format("%.5f", r.calculatePowerOutput(t.calculatePowerOutput(sg.getPower()))) + " W", r.getImage()));
        }

        else {
            buttons.add(new Button("Power = " + String.format("%.5f", amp.calculatePowerOutput(sg.getPower())) + " W", amp.getImage()));
            buttons.add(new Button("Power = " + String.format("%.5f", t.calculatePowerOutput(amp.calculatePowerOutput(sg.getPower()))) + " W", t.getImage()));
            buttons.add(new Button("Power = " + String.format("%.5f", r.calculatePowerOutput(t.calculatePowerOutput(amp.calculatePowerOutput(sg.getPower())))) + " W", r.getImage()));
            l.setPowerReceived(r.calculatePowerOutput(t.calculatePowerOutput(amp.calculatePowerOutput(sg.getPower()))));        
        }

        double pReceivedMinusRequired = l.getReceivedPower() - l.getRequiredPower();
        if(pReceivedMinusRequired > 50) {
            buttons.add(new Button("Too much power has been supplied to the load", 350, 30));
        }
        else if (pReceivedMinusRequired < 0.02) {
            buttons.add(new Button("Not enough power has been sent to the load", 350, 30));
        }
        else {
            buttons.add(new Button("Load is receiving sufficient power", 350, 30));
        }

        addButtonsToPanel();
        refreshPanel();
    }

    public void enableMetamaterial () {
        Transmitter metamaterial = new Transmitter("Metamaterial", 1.1, "Images/metamateria.png");
        Button metamaterialButton = new Button(metamaterial);
        addButton(metamaterialButton);
        refreshPanel();
    }

    public void addButtonsToPanel() {
        for (Button b : buttons)
            addButton(b);
        // This allows the buttons to be reseted in the case of a clear event so they don't get duplicated
        buttons.clear();
    }

}
