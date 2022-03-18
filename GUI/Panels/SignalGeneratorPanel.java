package GUI.Panels;

import Classes.*;
import GUI.Buttons.Button;

import java.util.*;
import java.awt.Font;
import java.awt.LayoutManager;

public class SignalGeneratorPanel extends Panel {
    ArrayList<SignalGenerator> signalGenerators;
    ArrayList<Button> signalGeneratorsButtons;

    public SignalGeneratorPanel(LayoutManager layout) {
        super(layout);

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
        signalGeneratorsButtons = new ArrayList<>();

        for(SignalGenerator s : signalGenerators)
        signalGeneratorsButtons.add(new Button(s));

        for(Button b : signalGeneratorsButtons) {
            b.setFont(new Font("Aria", Font.PLAIN, 10));
            this.add(b);
        }
    }
}
