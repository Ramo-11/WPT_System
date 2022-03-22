package GUI.Panels;

import GUI.Buttons.*;

import java.awt.LayoutManager;

public class OptionsPanel extends Panel {

    Button metalensOption;
    Button anotherOption;

    public OptionsPanel(LayoutManager layout) {
        super(layout);
        setupButtons();
    }
    
    public void setupButtons () {
        metalensOption = new Button("Metalens");
        anotherOption = new Button("Another option");

        this.addButton(metalensOption);
        this.addButton(anotherOption);
    }
}
