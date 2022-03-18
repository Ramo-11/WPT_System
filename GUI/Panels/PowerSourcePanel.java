package GUI.Panels;

import Classes.*;
import GUI.Buttons.Button;

import java.util.*;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class PowerSourcePanel extends Panel {

    ArrayList<PowerSource> powerSources;

    public PowerSourcePanel(LayoutManager layout) {
        super(layout);

        createAllPowerSources();
        createPowerSourceButtons();
        addActionListenerToButtons();
    }
    
    public void createAllPowerSources () {
        powerSources = new ArrayList<>();

        powerSources.add(new PowerSource("outlet"));
        powerSources.add(new PowerSource("laptop"));
    }

    public void createPowerSourceButtons () {
        this.buttons = new ArrayList<>();

        for(PowerSource p : powerSources)
        this.buttons.add(new Button(p));

        for(Button b : this.buttons) {
            b.setFont(new Font("Aria", Font.PLAIN, 10));
            this.add(b);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (Button ps : buttons) {
                if (e.getSource() == ps) {
                    System.out.println("power source is: " + ps.getText());
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Exception was caught", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
