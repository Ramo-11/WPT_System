package GUI.Panels;

import GUI.Buttons.*;

import java.awt.LayoutManager;
import java.awt.Color;

public class HelperPanel extends Panel {
    Button select;
    Button submit;
    Button clear;

    public HelperPanel(LayoutManager layout) {
        super(layout);
        setBackground(new Color(0, 0, 0, 0));
        createButtons();
        setColorToDefault();
    }

    public void createButtons () {
        select = new Button("Select");
        submit = new Button("Submit");
        clear = new Button("Clear");

        select.setBackground(new Color(237, 232, 232));
        submit.setBackground(new Color(237, 232, 232));
        clear.setBackground(new Color(237, 232, 232));

        this.add(select);
        this.add(submit);
        this.add(clear);
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
}
