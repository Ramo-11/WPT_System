package GUI.Buttons;

import Classes.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Button extends JButton {
    Component component;

    public Button (String text) {
        setupButton(text, 120, 30);
    }

    public Button(String text, int width, int height) {
        setupButton(text, width, height);
        setFont(new Font("Arial", 0, 15));
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    public Button(String text, int width, int height, int fontSize) {
        setupButton(text, width, height);
        setFont(new Font("Arial", 0, fontSize));
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    public Button (Component component) {
        this.component = component;
        setupButton(component.getName(), 120, 30);
    }

    public Button (ImageIcon image) {
        super(image);
    }

    public Button (String text, ImageIcon image) {
        super(image);
        setupButton(text, 280, 70);
        setFont(new Font("Arial", 0, 12));
        // make the button transparent
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
    }

    public void setupButton (String text, int width, int height) {
        setText(text);
        setPreferredSize(new Dimension(width, height));
        setFocusable(false);
        setForeground(Color.BLACK);
    }

    public void setComponent (Component component) {
        this.component = component;
    }
    
    public Component getComponent () {
        return this.component;
    }
}
