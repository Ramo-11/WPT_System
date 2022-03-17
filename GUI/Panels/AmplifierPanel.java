package GUI.Panels;

import Classes.*;
import GUI.Buttons.Button;

import java.util.*;
import java.awt.Font;
import java.awt.LayoutManager;

public class AmplifierPanel extends Panel {

    ArrayList<Amplifier> amplifiers;
    ArrayList<Button> amplifiersButtons;

    public AmplifierPanel(LayoutManager layout) {
        super(layout);

        createAllPowerSources();
        createPowerSourceButtons();
    }
    
    public void createAllPowerSources () {
        amplifiers = new ArrayList<>();

        amplifiers.add(new Amplifier("z22", 20));
        amplifiers.add(new Amplifier("German", 40));
    }

    public void createPowerSourceButtons () {
        amplifiersButtons = new ArrayList<>();

        for(Amplifier a : amplifiers)
        amplifiersButtons.add(new Button(a.getName()));

        for(Button b : amplifiersButtons) {
            b.setFont(new Font("Aria", Font.PLAIN, 10));
            this.add(b);
        }
    }
}
