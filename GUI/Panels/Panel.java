package GUI.Panels;

import GUI.Buttons.*;
import GUI.Labels.*;
import Classes.*;

import java.util.*;
import java.text.DecimalFormat;
import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.LayoutManager;
import java.awt.Color;

public class Panel extends JPanel implements ActionListener {
    ArrayList<Button> buttons;
    Component selectedComponent;
    int numSelections;
    DecimalFormat formatter;

    public Panel(LayoutManager layout) {
        super(layout);
        setBackground(new Color(108, 110, 112));
        selectedComponent = new Component("none");
        buttons = new ArrayList<>();
        numSelections = 0;
        formatter = new DecimalFormat();
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

    public void setNumSelections (int numSelections) {
        this.numSelections = numSelections;
    }

    public int getNumSelections () {
        return this.numSelections;
    }

    public void setColorToDefault() {
        for (Button b : buttons)
            b.setBackground(new Color(237, 232, 232));
    }

    public void disableAllButton () {
        for (Button b : buttons)
            b.setEnabled(false);
    }

    public void enableAllButton () {
        for (Button b : buttons)
            b.setEnabled(true);
    }

    public void refreshPanel () {
        revalidate();
        repaint();
    }

    public void clearPanel () {
        removeAll();
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
    }
}
