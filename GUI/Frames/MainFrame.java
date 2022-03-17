package GUI.Frames;

// import GUI.Buttons.*;
import GUI.Labels.Label;
import GUI.Panels.*;

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

    public MainFrame (String title) {
        super(title);
    }

    public MainFrame (String title, LayoutManager layout) {
        super(title, layout);

        createPanels();
    }

    public void createPanels() {
        topPanel = new Panel(null);
        powerSourcesPanel = new PowerSourcePanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
        signalGeneratorsPanel = new SignalGeneratorPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
        amplifiersPanel = new AmplifierPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));
        transmittersPanel = new TransmitterPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));

        topPanel.setBounds(0, 0, WIDTH, 100);
        powerSourcesPanel.setBounds(10, 200, 130, HEIGHT - 500);
        signalGeneratorsPanel.setBounds(powerSourcesPanel.getBounds().x + powerSourcesPanel.getWidth() + 10, 200, 130, HEIGHT - 500);
        amplifiersPanel.setBounds(signalGeneratorsPanel.getBounds().x + signalGeneratorsPanel.getWidth() + 10, 200, 140, HEIGHT - 500);
        transmittersPanel.setBounds(amplifiersPanel.getBounds().x + amplifiersPanel.getWidth() + 10, 200, 140, HEIGHT - 500);

        topPanel.setBackground(Color.DARK_GRAY);

        Color blue = new Color(45, 112, 226);

        powerSourcesPanel.setBackground(blue);
        signalGeneratorsPanel.setBackground(blue);
        amplifiersPanel.setBackground(blue);
        transmittersPanel.setBackground(blue);

        Label titleLabel = new Label("WPT System Simulation", 580, 20);
        Label powerSourceLabel = new Label("Power Sources", powerSourcesPanel.getBounds().x + 10, powerSourcesPanel.getBounds().y - 30);
        Label signalGeneratorsLabel = new Label("Signal Generators", signalGeneratorsPanel.getBounds().x + 10, signalGeneratorsPanel.getBounds().y - 30);
        Label amplifiersLabel = new Label("Amplifiers", amplifiersPanel.getBounds().x + 30, amplifiersPanel.getBounds().y - 30);
        Label transmittersLabel = new Label("Transmitters", transmittersPanel.getBounds().x + 30, transmittersPanel.getBounds().y - 30);

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
    }

    public void addPanel (Panel p) {
        this.add(p);

        refresh();
    }

    public void addLabel (Label l) { 
        this.add(l);

        refresh();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
