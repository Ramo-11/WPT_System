package Frames;

// import Classes.*;

public class MainFrame extends Frame {

    public MainFrame () {
        setUpFrame(WIDTH, HEIGHT, "exit", true);
    }

    public MainFrame (String title) {
        super(title);

        setUpFrame(WIDTH, HEIGHT, "exit", true);
    }

    public MainFrame (int width, int height) {
        setUpFrame(width, height, "exit", true);
    }

    public MainFrame (String title, int width, int height) {
        super(title);

        setUpFrame(width, height, "exit", true);
    }

    public MainFrame (String title, int width, int height, String closeOperation, boolean isResizable) {
        super(title);
        setUpFrame(width, height, closeOperation, isResizable);
    }
}
