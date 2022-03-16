package GUI.Frames;

import GUI.Buttons.Button;
import java.awt.event.*;

public class MainFrame extends Frame {
    Button b;
    
    public MainFrame () {
        setUpFrame("default title", WIDTH, HEIGHT, "exit", true);

        b = new Button("select power source");
    }

    public MainFrame (String title) {
        setUpFrame(title, WIDTH, HEIGHT, "exit", true);

        b = new Button("select power source");
        addButtonToFrame(b);
    }

    public MainFrame (int width, int height) {
        setUpFrame("default title", width, height, "exit", true);
    }

    public MainFrame (String title, int width, int height) {
        super(title);

        setUpFrame(title, width, height, "exit", true);
    }

    public MainFrame (String title, int width, int height, String closeOperation, boolean isResizable) {
        setUpFrame(title, width, height, closeOperation, isResizable);
    }

    public void addButtonToFrame(Button b) {
        b.addActionListener(this);
        this.add(b);

        this.invalidate();
        this.validate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("ok");
    }
}
