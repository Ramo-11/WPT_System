package GUI.Panels;

import Classes.*;
import GUI.Buttons.Button;

import java.util.*;
import java.awt.Font;
import java.awt.LayoutManager;

public class PowerSourcePanel extends Panel {

    ArrayList<PowerSource> powerSources;
    ArrayList<Button> powerSourcesButtons;

    public PowerSourcePanel(LayoutManager layout) {
        super(layout);

        createAllPowerSources();
        createPowerSourceButtons();
    }
    
    public void createAllPowerSources () {
        powerSources = new ArrayList<>();

        powerSources.add(new PowerSource("outlet"));
        powerSources.add(new PowerSource("laptop"));
    }

    public void createPowerSourceButtons () {
        powerSourcesButtons = new ArrayList<>();

        for(PowerSource p : powerSources)
            powerSourcesButtons.add(new Button(p.getName()));

        for(Button b : powerSourcesButtons) {
            b.setFont(new Font("Aria", Font.PLAIN, 10));
            this.add(b);
        }
    }
}
