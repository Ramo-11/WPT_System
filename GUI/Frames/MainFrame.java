package GUI.Frames;

import GUI.Labels.Label;
import GUI.Panels.*;

import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;


public class MainFrame extends Frame {

    public MainFrame (String title) {
        super(title);
    }

    public MainFrame (String title, LayoutManager layout) {
        super(title, layout);

        createTopPanel();
    }

    public void createTopPanel() {
        Panel p = new Panel(null);

        p.setBounds(0, 0, WIDTH, 100);
        p.setBackground(Color.DARK_GRAY);
        Label newLabel = new Label("choose a power source", (WIDTH/2 - 100), 20);
        newLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        newLabel.setForeground(Color.WHITE);
        p.addLabel(newLabel);
        addPanel(p);
    }

    public void addPanel(Panel p) {
        this.add(p);

        refresh();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ok");
    }
}
