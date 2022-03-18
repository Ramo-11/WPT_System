package GUI.Panels;

import Classes.*;
import GUI.Buttons.Button;

import java.util.*;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class SignalGeneratorPanel extends Panel {
    ArrayList<SignalGenerator> signalGenerators;

    public SignalGeneratorPanel(LayoutManager layout) {
        super(layout);
        setBackground(new Color(48, 124, 255));
        createAllSignalGenerators();
        createSignalGeneratorButtons();
        addActionListenerToButtons();
    }
    
    public void createAllSignalGenerators () {
        signalGenerators = new ArrayList<>();

        signalGenerators.add(new SignalGenerator("magnetron", 1100, "Images/magnetron.jpg"));
        signalGenerators.add(new SignalGenerator("TPI-1001-B", 0.01, "Images/TPI.jpg"));
    }

    public void createSignalGeneratorButtons () {
        buttons = new ArrayList<>();

        for(SignalGenerator s : signalGenerators)
            buttons.add(new Button(s));

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
                    selected = true;
                }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Exception was caught", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
