package GUI.Frames;

// import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener{
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    public Frame () {
        setUpFrame("default title", WIDTH, HEIGHT, "exit", true);
    }

    public Frame (String title) {
        setUpFrame(title, WIDTH, HEIGHT, "exit", true);
    }

    public Frame (int width, int height) {
        setUpFrame("default title", width, height, "exit", true);
    }

    public Frame (String title, int width, int height) {
        setUpFrame(title, width, height, "exit", true);
    }

    public Frame (String title, int width, int height, String closeOperation, boolean isResizable) {
        setUpFrame(title, width, height, closeOperation, isResizable);
    }

    public void setUpFrame (String title, int width, int height, String closeOperation, boolean isResizable) {
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

        System.out.println("Hello?");
        this.setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
    }
}
