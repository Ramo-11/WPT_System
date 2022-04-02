package GUI.Panels;

import GUI.Buttons.*;

import java.awt.LayoutManager;
import java.awt.Color;

public class HelperPanel extends Panel {
    Button select;
    Button submit;
    Button clear;
    Button clearAll;
    Button metamaterial;

    public HelperPanel(LayoutManager layout) {
        super(layout);
        setBackground(new Color(0, 0, 0, 0));
        createButtons();
    }

    public void createButtons () {
        select = new Button("Select");
        submit = new Button("Submit");
        clear = new Button("Clear");
        clearAll = new Button("Clear All");
        metamaterial = new Button("Metamaterial");

        this.add(select);
        this.add(submit);
        this.add(clear);
        this.add(clearAll);
        this.add(metamaterial);
    }

    public Button getSelectButton () {
        return this.select;
    }

    public Button getSubmitButton () {
        return this.submit;
    }

    public Button getClearButton () {
        return this.clear;
    }

    public Button getClearAllButton () {
        return this.clearAll;
    }

    public Button getMetamaterialButton () {
        return this.metamaterial;
    }
}
