package GUI.Panels;

import Classes.*;
import GUI.Buttons.Button;

import java.util.*;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class AmplifierPanel extends Panel {

    ArrayList<Amplifier> amplifiers;

    public AmplifierPanel(LayoutManager layout) {
        super(layout);
        setBackground(new Color(48, 124, 255));
        createAllAmplifiers();
        createAmplifierButtons();
        addActionListenerToButtons();
    }
    
    public void createAllAmplifiers () {
        amplifiers = new ArrayList<>();

        amplifiers.add(new Amplifier("SZA2044", 40, "Images/SZA2044.png"));
        amplifiers.add(new Amplifier("TQP7M9103", 40, "Images/TQP7M9103.png"));
        amplifiers.add(new Amplifier("SZM2166", 40, "Images/SZM2166.png"));
    }

    public void createAmplifierButtons () {
        for(Amplifier a : amplifiers)
            buttons.add(new Button(a));

        for(Button b : buttons) {
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
                    if (numSelections == 1)
                        JOptionPane.showMessageDialog(null, "Fail: only one component is allowed from each subsystem", "Error", JOptionPane.ERROR_MESSAGE);
                    else 
                        numSelections++;
                }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Exception was caught", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
