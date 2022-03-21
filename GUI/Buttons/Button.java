package GUI.Buttons;

import Classes.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class Button extends JButton {
    Component component;

    public Button (String text) {
        setUpButton(text, 120, 30);
    }

    public Button (Component component) {
        this.component = component;
        setUpButton(component.getName(), 120, 30);
    }

    public Button (ImageIcon image) {
        super (image);
    }

    public void setUpButton (String text, int width, int height) {
        this.setText(text);
        this.setPreferredSize(new Dimension(width, height));
        this.setFocusable(false);
        this.setForeground(Color.BLACK);
    }

    public void setComponent (Component component) {
        this.component = component;
    }
    
    public Component getComponent () {
        return this.component;
    }
}
