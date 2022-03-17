package GUI.Panels;

import GUI.Buttons.*;
import GUI.Labels.*;

import java.util.*;
import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.LayoutManager;

public class Panel extends JPanel implements ActionListener {
    ArrayList<Button> buttons;

    public Panel(LayoutManager layout) {
        super(layout);

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

    @Override
    public void actionPerformed(ActionEvent e) { }
}
