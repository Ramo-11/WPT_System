package GUI.Frames;

import GUI.Buttons.*;
import GUI.Labels.Label;
import GUI.Panels.*;
// import Classes.*;

import java.awt.event.*;
// import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.FlowLayout;
import java.awt.Font;


public class MainFrame extends Frame {

    Panel topPanel;
    PowerSourcePanel powerSourcesPanel;
    SignalGeneratorPanel signalGeneratorsPanel;
    AmplifierPanel amplifiersPanel;
    TransmitterPanel transmittersPanel;
    SelectionPanel selectionPanel;

    Button selectComponent;

    public MainFrame (String title, LayoutManager layout) {
        super(title, layout);

        createPanels();
    }

    public void createPanels() {
        topPanel = new Panel(null);
        selectionPanel = new SelectionPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        powerSourcesPanel = new PowerSourcePanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
        signalGeneratorsPanel = new SignalGeneratorPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
        amplifiersPanel = new AmplifierPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));
        transmittersPanel = new TransmitterPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));

        topPanel.setBounds(0, 0, WIDTH, 100);
        powerSourcesPanel.setBounds(10, 200, 130, HEIGHT - 500);
        signalGeneratorsPanel.setBounds(powerSourcesPanel.getX() + powerSourcesPanel.getWidth() + 10, 200, 130, HEIGHT - 500);
        amplifiersPanel.setBounds(signalGeneratorsPanel.getX() + signalGeneratorsPanel.getWidth() + 10, 200, 140, HEIGHT - 500);
        transmittersPanel.setBounds(amplifiersPanel.getX() + amplifiersPanel.getWidth() + 10, 200, 140, HEIGHT - 500);
        selectionPanel.setBounds(powerSourcesPanel.getX(), powerSourcesPanel.getY() + powerSourcesPanel.getHeight() + 10, 570, HEIGHT - 600);

        topPanel.setBackground(Color.DARK_GRAY);

        Color blue = new Color(45, 112, 226);

        powerSourcesPanel.setBackground(blue);
        signalGeneratorsPanel.setBackground(blue);
        amplifiersPanel.setBackground(blue);
        transmittersPanel.setBackground(blue);
        selectionPanel.setBackground(new Color(21, 122, 48));

        Label titleLabel = new Label("WPT System Simulation", 580, 20);
        Label powerSourceLabel = new Label("Power Sources", powerSourcesPanel.getX() + 10, powerSourcesPanel.getY() - 30);
        Label signalGeneratorsLabel = new Label("Signal Generators", signalGeneratorsPanel.getX() + 10, signalGeneratorsPanel.getY() - 30);
        Label amplifiersLabel = new Label("Amplifiers", amplifiersPanel.getX() + 30, amplifiersPanel.getY() - 30);
        Label transmittersLabel = new Label("Transmitters", transmittersPanel.getX() + 30, transmittersPanel.getY() - 30);

        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 25));

        addLabel(titleLabel);
        addLabel(powerSourceLabel);
        addLabel(signalGeneratorsLabel);
        addLabel(amplifiersLabel);
        addLabel(transmittersLabel);

        addPanel(topPanel);
        addPanel(powerSourcesPanel);
        addPanel(signalGeneratorsPanel);
        addPanel(amplifiersPanel);
        addPanel(transmittersPanel);
        addPanel(selectionPanel);
    }

    public void addPanel (Panel p) {
        this.add(p);

        refresh();
    }

    public void addLabel (Label l) { 
        this.add(l);

        refresh();
    }

    public void createAndAddSelectComponentButton() {
        selectComponent = new Button("Okay");
        selectComponent.setBounds(selectionPanel.getX() + 215, selectionPanel.getY() + selectionPanel.getHeight() + 20, 120, 20);
        selectComponent.addActionListener(this);
        this.add(selectComponent);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectComponent) {
        }
    }
}
