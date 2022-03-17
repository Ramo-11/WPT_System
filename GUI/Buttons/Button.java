package GUI.Buttons;

import Classes.Component;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;

public class Button extends JButton {
    ImageIcon image;
    Color color;

    public Button (Component c) {
        image = new ImageIcon("GUI/Images/defaultButtonIcon.png");
        color = new Color(255, 255, 255); // White

        setUpButton(c.getName(), 120, 20);
    }

    public Button (Component c, ImageIcon image) {
        this.image = image;
        color = new Color(255, 255, 255);

        setUpButton(c.getName(), 120, 20);;
    }

    public Button (Component c, int width, int height) {
        image = new ImageIcon("GUI/Images/defaultButtonIcon.png");
        color = new Color(255, 255, 255);

        setUpButton(c.getName(), width, height);
    }

    public void setUpButton (String text, int width, int height) {
        this.setText(text);
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(false);
        this.setForeground(color);
        this.setIcon(image);
        this.setForeground(Color.BLACK);
    }
}
