package GUI.Buttons;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

public class Button extends JButton {
    public Button () {
        ImageIcon defaultIcon = new ImageIcon("GUI/Images/defaultButtonIcon.png");
        Color defaultColor = new Color(255, 255, 255); // White

        setUpButton("default text", defaultIcon, 120, 20, defaultColor);
    }

    public Button (String text) {
        ImageIcon defaultIcon = new ImageIcon("GUI/Images/defaultButtonIcon.png");
        Color defaultColor = new Color(255, 255, 255); // White

        setUpButton(text, defaultIcon, 120, 20, defaultColor);
    }

    public Button (String text, int width, int height) {
        ImageIcon defaultIcon = new ImageIcon("GUI/Images/defaultButtonIcon.png");
        Color defaultColor = new Color(255, 255, 255); // White

        setUpButton(text, defaultIcon, width, height, defaultColor);
    }

    public void setUpButton (String text, ImageIcon icon, int width, int height, Color c) {
        this.setText(text);
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(false);
        this.setForeground(c);
        this.setIcon(icon);
        this.setForeground(Color.BLACK);
    }
}
