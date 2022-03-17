package GUI.Panels;

import Classes.*;
import GUI.Buttons.Button;

import java.util.*;
import java.awt.Font;
import java.awt.LayoutManager;

public class TransmitterPanel extends Panel {

    ArrayList<Transmitter> transmitters;
    ArrayList<Button> transmittersButtons;

    public TransmitterPanel(LayoutManager layout) {
        super(layout);

        createAllPowerSources();
        createPowerSourceButtons();
    }
    
    public void createAllPowerSources () {
        transmitters = new ArrayList<>();

        transmitters.add(new Transmitter("patch element", 6));
        transmitters.add(new Transmitter("patch array", 20));
        transmitters.add(new Transmitter("horn antenna", 15));
    }

    public void createPowerSourceButtons () {
        transmittersButtons = new ArrayList<>();

        for(Transmitter a : transmitters)
        transmittersButtons.add(new Button(a.getName()));

        for(Button b : transmittersButtons) {
            b.setFont(new Font("Aria", Font.PLAIN, 10));
            this.add(b);
        }
    }
}
