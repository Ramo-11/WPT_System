package GUI.Panels;

import Classes.*;
import GUI.Buttons.Button;

import java.util.*;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class MetamaterialPanel extends Panel {

    Transmitter metamaterial;

    public MetamaterialPanel(LayoutManager layout) {
        super(layout);
        setBackground(new Color(48, 124, 255));

        metamaterial = new Transmitter("Metamaterial", 1.2);
        createTransmitterButtons();
        addActionListenerToButtons();
    }


    public void createTransmitterButtons () {
        buttons = new ArrayList<>();

        buttons.add(new Button(metamaterial));

        for(Button b : buttons) {
            b.setFont(new Font("Aria", Font.PLAIN, 13));
            this.add(b);
        }

        setColorToDefault();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (Button button : buttons)
                if (e.getSource() == button) {
                    selectedComponent = button.getComponent();
                    this.numSelections++;

                    Color m_green = new Color(77, 158, 73);
                    Color m_red = new Color(230, 30, 16);

                    if (button.getBackground().getRGB() == m_green.getRGB())
                            button.setBackground(m_red);
                    else
                        button.setBackground(m_green);
                }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Exception was caught", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
