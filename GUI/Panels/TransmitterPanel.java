package GUI.Panels;

import Classes.*;
import GUI.Buttons.Button;

import java.util.*;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class TransmitterPanel extends Panel {

    ArrayList<Transmitter> transmitters;

    public TransmitterPanel(LayoutManager layout) {
        super(layout);
        setBackground(new Color(48, 124, 255));
        createAllTransmitters();
        createTransmitterButtons();
        addActionListenerToButtons();
    }
    
    public void createAllTransmitters () {
        transmitters = new ArrayList<>();

        transmitters.add(new Transmitter("Patch element", 0.6, "Images/patch_element.png"));
        transmitters.add(new Transmitter("Patch array", 0.8, "Images/patch_array.png"));
        transmitters.add(new Transmitter("Horn antenna", 0.9, "Images/horn.png"));
    }

    public void createTransmitterButtons () {
        buttons = new ArrayList<>();

        for(Transmitter a : transmitters)
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
