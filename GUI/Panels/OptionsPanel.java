package GUI.Panels;

import GUI.Buttons.*;

import java.awt.LayoutManager;
import java.awt.Color;

public class OptionsPanel extends Panel {

    Button metalensOption;
    Button anotherOption;

    public OptionsPanel(LayoutManager layout) {
        super(layout);
        setBackground(new Color(48, 124, 255));
        setupButtons();
    }
    
    public void setupButtons () {
        metalensOption = new Button("Metalens");
        anotherOption = new Button("Another option");

        this.addButton(metalensOption);
        this.addButton(anotherOption);
    }
}
