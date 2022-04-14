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

    public void startResultsPanel (PowerSource ps, SignalGenerator sg, Amplifier amp, Transmitter t, Transmitter m, Receiver r, Load l) {
        double sg_power = 0;
        double amp_power = 0;
        double t_power = 0;
        double m_power = 0;
        double r_power = 0;

        sg_power = sg.getPower();
        amp_power = amp.calculatePowerOutput(sg_power);
        t_power = t.calculatePowerOutput(amp_power);
        m_power = m.calculatePowerOutput(t_power);
        r_power = r.calculatePowerOutput(m_power);
            
        buttons.add(new Button("Power out = " + String.format("%.5f", sg_power) + " W", sg.getImage()));
        
        // No amplifier nor metamaterial were picked
        if(amp.getName().equals("") && m.getName().equals("")) {
            buttons.add(new Button("Power out = " + String.format("%.5f", t_power) + " W", t.getImage()));
            buttons.add(new Button("Power out = " + String.format("%.5f", r_power) + " W", r.getImage()));
        }
        else if(amp.getName().equals("")) {
            buttons.add(new Button("Power out = " + String.format("%.5f", t_power) + " W", t.getImage()));
            buttons.add(new Button("Power out = " + String.format("%.5f", m_power) + " W", m.getImage()));
            buttons.add(new Button("Power out = " + String.format("%.5f", r_power) + " W", r.getImage()));
        }

        else if(m.getName().equals("")) {
            buttons.add(new Button("Power out = " + String.format("%.5f", amp_power) + " W", amp.getImage()));
            buttons.add(new Button("Power out = " + String.format("%.5f", t_power) + " W", t.getImage()));
            buttons.add(new Button("Power out = " + String.format("%.5f", r_power) + " W", r.getImage()));     
        }
        else {
            buttons.add(new Button("Power out = " + String.format("%.5f", amp_power) + " W", amp.getImage()));
            buttons.add(new Button("Power out = " + String.format("%.5f", t_power) + " W", t.getImage()));
            buttons.add(new Button("Power out = " + String.format("%.5f", m_power) + " W", m.getImage()));
            buttons.add(new Button("Power out = " + String.format("%.5f", r_power) + " W", r.getImage()));
        }

        l.setPowerReceived(r_power);   

        double pReceivedMinusRequired = l.getReceivedPower() - l.getRequiredPower();
        if(pReceivedMinusRequired > 500)
            buttons.add(new Button("load is receiving too much power", 400, 30, 18));
        else if (pReceivedMinusRequired < 0.02)
            buttons.add(new Button("load is not receiving sufficient power", 400, 30, 18));
        else 
            buttons.add(new Button("Load is receiving sufficient power", 400, 30, 18));

        double efficiency = Math.round(l.getReceivedPower()/amp_power * 100);
        buttons.add(new Button("System's Efficiency = " + efficiency + "%", 350, 30, 18));
        addButtonsToPanel();
        refreshPanel();
    }

    public void addButtonsToPanel() {
        for (Button b : buttons)
            addButton(b);
        // This allows the buttons to be reseted in the case of a clear event so they don't get duplicated
        buttons.clear();
    }

}
