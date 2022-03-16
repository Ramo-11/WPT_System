package GUI.Buttons;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

public class Button extends JButton {
    public Button () {
        ImageIcon defaultIcon = new ImageIcon("GUI/Images/defaultButtonIcon.png");
        Color defaultColor = new Color(64, 64, 64); // darkGray

        setUpButton("default text", defaultIcon, 50, 50, defaultColor);
    }

    public Button (String text) {
        ImageIcon defaultIcon = new ImageIcon("GUI/Images/defaultButtonIcon.png");
        Color defaultColor = new Color(64, 64, 64); // darkGray

        setUpButton(text, defaultIcon, 50, 50, defaultColor);
    }

    public Button (String text, int width, int height) {
        ImageIcon defaultIcon = new ImageIcon("GUI/Images/defaultButtonIcon.png");
        Color defaultColor = new Color(64, 64, 64); // darkGray

        setUpButton(text, defaultIcon, width, height, defaultColor);
    }

    public void setUpButton (String text, ImageIcon icon, int width, int height, Color c) {
        this.setText(text);
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(false);
        this.setForeground(c);
        this.setIcon(icon);
    }
}
