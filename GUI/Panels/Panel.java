package GUI.Panels;

import GUI.Buttons.*;
import GUI.Labels.*;

import java.awt.event.*;
import javax.swing.JPanel;
import java.awt.LayoutManager;

public class Panel extends JPanel implements ActionListener {
    public Panel(LayoutManager layout) {
        super(layout);
    }

    public void addButton(Button b) {
        b.addActionListener(this);
        this.add(b);
    }

    public void addLabel(Label label) {
        label.setFocusable(false);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
