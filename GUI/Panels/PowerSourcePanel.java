package GUI.Panels;

import Classes.*;
import GUI.Buttons.Button;

import java.util.*;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class PowerSourcePanel extends Panel {

    ArrayList<PowerSource> powerSources;

    public PowerSourcePanel(LayoutManager layout) {
        super(layout);
        setBackground(new Color(11, 68, 161));
        createAllPowerSources();
        createPowerSourceButtons();
        addActionListenerToButtons();
    }
    
    public void createAllPowerSources () {
        powerSources = new ArrayList<>();

        powerSources.add(new PowerSource("Outlet", "Images/outlet.jpg"));
        powerSources.add(new PowerSource("Laptop", "Images/laptop.png"));
        powerSources.add(new PowerSource("Diesel Engine", "Images/diesel_engine.png"));
    }

    public void createPowerSourceButtons () {
        this.buttons = new ArrayList<>();

        for(PowerSource p : powerSources)
            this.buttons.add(new Button(p));

        for(Button b : this.buttons) {
            b.setFont(new Font("Aria", Font.PLAIN, 10));
            this.add(b);
        }
        setColorToDefault();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (Button button : buttons)
                if (e.getSource() == button) {
                    if (this.numSelections >= 1)
                        JOptionPane.showMessageDialog(null, "Fail: only one component is allowed from each subsystem", "Error", JOptionPane.ERROR_MESSAGE);
                    else {
                        selectedComponent = button.getComponent();
                        this.numSelections++;
                        button.setBackground(new Color(171, 203, 255));
                    }
                }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Exception was caught", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
