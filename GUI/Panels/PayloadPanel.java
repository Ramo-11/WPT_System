package GUI.Panels;

import Classes.*;
import GUI.Buttons.Button;

import java.util.*;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class PayloadPanel extends Panel {

    ArrayList<Payload> payloads;

    public PayloadPanel(LayoutManager layout) {
        super(layout);
        setBackground(new Color(48, 124, 255));
        createAllReceivers();
        createReceiverButtons();
        addActionListenerToButtons();
    }
    
    public void createAllReceivers () {
        payloads = new ArrayList<>();

        payloads.add(new Payload("Drone", 40.0, "Images/drone.png"));
        payloads.add(new Payload("LED", 0.01, "Images/LED.png"));
    }

    public void createReceiverButtons () {
        buttons = new ArrayList<>();

        for(Payload a : payloads)
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
                    if (numSelections == 2)
                        JOptionPane.showMessageDialog(null, "Fail: only one component is allowed from each subsystem", "Error", JOptionPane.ERROR_MESSAGE);
                    else 
                        numSelections++;
                }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Exception was caught", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
