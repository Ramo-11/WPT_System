package GUI.Frames;

import GUI.Labels.Label;
import GUI.Panels.*;

import java.awt.event.*;
import javax.swing.JOptionPane;
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
    SelectionPanelHelperPanel helperPanel;

    public MainFrame (String title, LayoutManager layout) {
        super(title, layout);
        createPanels();
    }

    public void createPanels() {
        topPanel = new Panel(null);
        selectionPanel = new SelectionPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        helperPanel = new SelectionPanelHelperPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));
        powerSourcesPanel = new PowerSourcePanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
        signalGeneratorsPanel = new SignalGeneratorPanel(new FlowLayout(FlowLayout.CENTER, 30, 30));
        amplifiersPanel = new AmplifierPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));
        transmittersPanel = new TransmitterPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));

        topPanel.setBounds(0, 0, WIDTH, 50);
        powerSourcesPanel.setBounds(10, 100, 130, HEIGHT - 500);
        signalGeneratorsPanel.setBounds(powerSourcesPanel.getX() + powerSourcesPanel.getWidth() + 10, 100, 130, HEIGHT - 500);
        amplifiersPanel.setBounds(signalGeneratorsPanel.getX() + signalGeneratorsPanel.getWidth() + 10, 100, 140, HEIGHT - 500);
        transmittersPanel.setBounds(amplifiersPanel.getX() + amplifiersPanel.getWidth() + 10, 100, 140, HEIGHT - 500);
        selectionPanel.setBounds(powerSourcesPanel.getX(), powerSourcesPanel.getY() + powerSourcesPanel.getHeight() + 10, 570, HEIGHT - 500);
        helperPanel.setBounds(selectionPanel.getX(), selectionPanel.getY() + selectionPanel.getHeight() + 10, 570, HEIGHT - 670);

        createPanelsTitles();

        addPanel(topPanel);
        addPanel(powerSourcesPanel);
        addPanel(signalGeneratorsPanel);
        addPanel(amplifiersPanel);
        addPanel(transmittersPanel);
        addPanel(selectionPanel);
        addPanel(helperPanel);

        assignListenerToHelpersButtons();
    }

    public void addPanel (Panel p) {
        this.add(p);
        refresh();
    }

    public void addLabel (Label l) { 
        this.add(l);
        refresh();
    }

    public void assignListenerToHelpersButtons () {
        helperPanel.getSelectButton().addActionListener(this);
        helperPanel.getSubmitButton().addActionListener(this);
        helperPanel.getClearButton().addActionListener(this);
    }

    public void createPanelsTitles () {
        Label titleLabel = new Label("WPT System Simulation", 580, 0);
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
    }

    public void clearSelectionPanel () {
        selectionPanel.clearPanel();
        powerSourcesPanel.setNumSelections(0);
        signalGeneratorsPanel.setNumSelections(0);
        amplifiersPanel.setNumSelections(0);
        transmittersPanel.setNumSelections(0);
    }

    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == helperPanel.getSelectButton()) {
            Label imageLabel = null;
            if (powerSourcesPanel.getNumSelections() == 1) {
                imageLabel = new Label(powerSourcesPanel.getComponent().getImage());
                powerSourcesPanel.setNumSelections(powerSourcesPanel.getNumSelections() + 1);
            }
            else if (signalGeneratorsPanel.getNumSelections() == 1) {
                imageLabel = new Label(signalGeneratorsPanel.getComponent().getImage());
                signalGeneratorsPanel.setNumSelections(signalGeneratorsPanel.getNumSelections() + 1);
            }
            else if (amplifiersPanel.getNumSelections() == 1) {
                imageLabel = new Label(amplifiersPanel.getComponent().getImage());
                amplifiersPanel.setNumSelections(amplifiersPanel.getNumSelections() + 1);
            }
            else if (transmittersPanel.getNumSelections() == 1) {
                imageLabel = new Label(transmittersPanel.getComponent().getImage());
                transmittersPanel.setNumSelections(transmittersPanel.getNumSelections() + 1);
            }
            if (imageLabel != null)
                selectionPanel.add(imageLabel);
            refresh();
        }
        else if (e.getSource() == helperPanel.getSubmitButton()) {
            if ((powerSourcesPanel.getNumSelections() != 2) || (signalGeneratorsPanel.getNumSelections() != 2) || (amplifiersPanel.getNumSelections() != 2) || (transmittersPanel.getNumSelections() != 2))
                JOptionPane.showMessageDialog(null, "Fail: Select at least one element from each subsystem", "Error", JOptionPane.ERROR_MESSAGE);
            else {
                JOptionPane.showMessageDialog(null, "Success: Your selections have been submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearSelectionPanel();
            }
        }
        else if (e.getSource() == helperPanel.getClearButton()) {
            clearSelectionPanel();
        }
    }
}
