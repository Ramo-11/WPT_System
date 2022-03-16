package Frames;

// import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener{
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;

    public Frame () {
        setUpFrame(WIDTH, HEIGHT, "exit", true);
    }

    public Frame (String title) {
        super(title);

        setUpFrame(WIDTH, HEIGHT, "exit", true);
    }

    public Frame (int width, int height) {
        setUpFrame(width, height, "exit", true);
    }

    public Frame (String title, int width, int height) {
        super(title);

        setUpFrame(width, height, "exit", true);
    }

    public Frame (String title, int width, int height, String closeOperation, boolean isResizable) {
        super(title);
        setUpFrame(width, height, closeOperation, isResizable);
    }

    public void setUpFrame (int width, int height, String closeOperation, boolean isResizable) {
        this.setSize(width, height);
        this.setResizable(isResizable);

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
    public void actionPerformed(ActionEvent e) {
    }
}
