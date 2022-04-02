package GUI.Panels;

import Classes.*;
import GUI.Buttons.Button;

import java.util.*;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class LoadPanel extends Panel {

    ArrayList<Load> loads;

    public LoadPanel(LayoutManager layout) {
        super(layout);
        setBackground(new Color(48, 124, 255));
        createAllReceivers();
        createReceiverButtons();
        addActionListenerToButtons();
    }
    
    public void createAllReceivers () {
        loads = new ArrayList<>();

        loads.add(new Load("Drone", 40.0, "Images/drone.png"));
        loads.add(new Load("LED", 0.01, "Images/LED.png"));
    }

    public void createReceiverButtons () {
        buttons = new ArrayList<>();

        for(Load a : loads)
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
