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

        powerSources.add(new PowerSource("outlet", "Images/default.png"));
        powerSources.add(new PowerSource("laptop", "Images/laptop.jpg"));
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
            for (Button button : buttons)
                if (e.getSource() == button) {
                    selectedComponent = button.getComponent();
                    selected = true;
                }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Exception was caught", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
