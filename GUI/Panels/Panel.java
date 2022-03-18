package GUI.Panels;

import GUI.Buttons.*;
import GUI.Labels.*;
import Classes.*;

import java.util.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.LayoutManager;

public class Panel extends JPanel implements ActionListener {
    ArrayList<Button> buttons;
    Component selectedComponent;
    boolean selected = false;

    public Panel(LayoutManager layout) {
        super(layout);

        selectedComponent = new Component("none");
        buttons = new ArrayList<>();
    }

    public void addButton(Button b) {
        b.addActionListener(this);
        this.add(b);
    }

    public void addLabel(Label label) {
        label.setFocusable(false);
        this.add(label);
    }

    public ArrayList<Button> getButtons () {
        return this.buttons;
    }

    public void addActionListenerToButtons () {
        for (Button b : buttons)
            b.addActionListener(this);
    }

    public Component getComponent () {
        return this.selectedComponent;
    }

    public boolean isSelected () {
        return this.selected;
    }

    public void clearSelected () {
        this.selected = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
    }
}
