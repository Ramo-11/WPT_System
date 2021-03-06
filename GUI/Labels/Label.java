package GUI.Labels;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Label extends JLabel {
    public Label () {
        setUpLabel("", 0, 0, 300, 40);
    }

    public Label (String text) {
        setUpLabel(text, 0, 0, 300, 40);
    }

    public Label (ImageIcon image) {
        super(image);

        setUpLabel("", 0, 0, 300, 40);
    }

    public Label (String text, int x, int y) {
        setUpLabel(text, x, y, 300, 40);
    }

    public Label (String text, int x, int y, int width, int height) {
        setUpLabel(text, x, y, width, height);
    }

    public void setUpLabel (String text, int x, int y, int width, int height) {
        setText(text);
        setBounds(x, y, width, height);
    }
}
