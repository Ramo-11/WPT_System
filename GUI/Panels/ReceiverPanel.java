package GUI.Panels;

import Classes.*;
import GUI.Buttons.Button;

import java.util.*;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class ReceiverPanel extends Panel {

    ArrayList<Receiver> receivers;

    public ReceiverPanel(LayoutManager layout) {
        super(layout);
        setBackground(new Color(11, 68, 161));
        createAllReceivers();
        createReceiverButtons();
        addActionListenerToButtons();
    }
    
    public void createAllReceivers () {
        receivers = new ArrayList<>();

        receivers.add(new Receiver("Patch element", 0.4, "Images/patch_element.png"));
        receivers.add(new Receiver("Patch array", 0.6, "Images/patch_array.png"));
        receivers.add(new Receiver("Horn antenna", 0.7, "Images/horn.png"));
    }

    public void createReceiverButtons () {
        buttons = new ArrayList<>();

        for(Receiver a : receivers)
            buttons.add(new Button(a));

        for(Button b : buttons) {
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
