package GUI.Panels;

import java.awt.Color;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;

public class SelectionPanel extends Panel {

    public SelectionPanel(LayoutManager layout) {
        super(layout);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
}
