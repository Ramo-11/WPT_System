package GUI.Frames;

import java.awt.event.*;
import javax.swing.*;
import java.awt.LayoutManager;

public class Frame extends JFrame implements ActionListener {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 720;

    public Frame (String title) {
        setUpFrame(title, WIDTH, HEIGHT, "exit", false, null);
    }

    public Frame (String title, LayoutManager layout) {
        setUpFrame(title, WIDTH, HEIGHT, "exit", false, layout);
    }

    public Frame (String title, int width, int height) {
        setUpFrame(title, width, height, "exit", false, null);
    }

    public Frame (String title, int width, int height, String closeOperation, boolean isResizable) {
        setUpFrame(title, width, height, closeOperation, isResizable, null);
    }

    public void setUpFrame (String title, int width, int height, String closeOperation, boolean isResizable, LayoutManager layout) {
        setLayout(layout);
        setTitle(title);
        setSize(width, height);
        setResizable(isResizable);

        if (closeOperation == "exit")
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        else if (closeOperation == "hide")
            setDefaultCloseOperation(HIDE_ON_CLOSE);
        else if (closeOperation == "dispose")
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        else if (closeOperation == "do_nothing")
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
    }

    public void refresh() {
        this.invalidate();
        this.validate();
        this.repaint();
    }

    public void clear() {
        this.getContentPane().removeAll();
        this.revalidate();
        this.repaint();
    }
}
