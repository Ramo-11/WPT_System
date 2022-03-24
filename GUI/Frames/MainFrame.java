package GUI.Frames;

import GUI.Labels.Label;
import GUI.Panels.*;
import Classes.*;

import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.FlowLayout;
import java.awt.Font;

public class MainFrame extends Frame {

    PowerSource selectedPowerSource;
    SignalGenerator selectedSignalGenerator;
    Amplifier selectedAmplifier;
    Transmitter selectedTransmitter;
    Receiver selectedReceiver;
    Payload selectedPayload;

    Panel topPanel;

    PowerSourcePanel powerSourcesPanel;
    SignalGeneratorPanel signalGeneratorsPanel;
    AmplifierPanel amplifiersPanel;
    TransmitterPanel transmittersPanel;
    ReceiverPanel receiverPanel;
    PayloadPanel payloadPanel;

    SelectionPanel selectionPanel;
    SelectionPanelHelperPanel helperPanel;

    OptionsPanel optionsPanel;
    Panel resultsPanel;

    public MainFrame (String title, LayoutManager layout) {
        super(title, layout);
        
        initializeComponents ();
        setupLeftPanels();
        setupRightPanels();
    }

    public void initializeComponents () {
        selectedPowerSource = new PowerSource("");
        selectedSignalGenerator = new SignalGenerator("");
        selectedAmplifier = new Amplifier("");
        selectedTransmitter = new Transmitter("");
        selectedReceiver = new Receiver("");
        selectedPayload = new Payload("");

        resultsPanel = new Panel(null);
        optionsPanel = new OptionsPanel(new FlowLayout(FlowLayout.CENTER, 0, 50));

        topPanel = new Panel(null);
        powerSourcesPanel = new PowerSourcePanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        signalGeneratorsPanel = new SignalGeneratorPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        amplifiersPanel = new AmplifierPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        transmittersPanel = new TransmitterPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        receiverPanel = new ReceiverPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        payloadPanel = new PayloadPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));

        selectionPanel = new SelectionPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        helperPanel = new SelectionPanelHelperPanel(new FlowLayout(FlowLayout.CENTER, 50, 10));
    }

    public void setupLeftPanels () {

        topPanel.setBounds(0, 0, WIDTH, 50);
        powerSourcesPanel.setBounds(10, 100, 135, HEIGHT - 550);
        signalGeneratorsPanel.setBounds(powerSourcesPanel.getX() + powerSourcesPanel.getWidth() + 10, 100, 135, HEIGHT - 550);
        amplifiersPanel.setBounds(signalGeneratorsPanel.getX() + signalGeneratorsPanel.getWidth() + 10, 100, 135, HEIGHT - 550);
        transmittersPanel.setBounds(amplifiersPanel.getX() + amplifiersPanel.getWidth() + 10, 100, 135, HEIGHT - 550);
        receiverPanel.setBounds(powerSourcesPanel.getX(), powerSourcesPanel.getY() + powerSourcesPanel.getHeight() + 20, 135, HEIGHT - 550);
        payloadPanel.setBounds(receiverPanel.getX() + receiverPanel.getWidth() + 10, receiverPanel.getY(), 135, HEIGHT - 550);
        selectionPanel.setBounds(receiverPanel.getX(), receiverPanel.getY() + receiverPanel.getHeight() + 10, 570, HEIGHT - 600);
        helperPanel.setBounds(selectionPanel.getX(), selectionPanel.getY() + selectionPanel.getHeight() + 10, 570, HEIGHT - 670);

        createSetupPanelsTitles();

        addPanel(topPanel);
        addPanel(powerSourcesPanel);
        addPanel(signalGeneratorsPanel);
        addPanel(amplifiersPanel);
        addPanel(transmittersPanel);
        addPanel(receiverPanel);
        addPanel(payloadPanel);
        addPanel(selectionPanel);
        addPanel(helperPanel);

        assignListenerToHelpersButtons();
    }

    public void setupRightPanels () {
        resultsPanel.setBounds(selectionPanel.getX() + selectionPanel.getWidth() + 20, powerSourcesPanel.getY(), 500, powerSourcesPanel.getHeight() + selectionPanel.getHeight() + 10);
        resultsPanel.setBackground(new Color(200, 200, 200));

        optionsPanel.setBounds(resultsPanel.getX() + resultsPanel.getWidth() + 10, resultsPanel.getY(), 140, resultsPanel.getHeight());
        optionsPanel.setBackground(new Color(48, 124, 255));

        addPanel(resultsPanel);
        addPanel(optionsPanel);
    }

    public void assignListenerToHelpersButtons () {
        helperPanel.getSelectButton().addActionListener(this);
        helperPanel.getSubmitButton().addActionListener(this);
        helperPanel.getClearButton().addActionListener(this);
    }

    public void startResultsPanel () {
        Label powerOutput = new Label("output power = " + selectedAmplifier.calculatePowerOutput(selectedSignalGenerator.getPower()));
        
        resultsPanel.addLabel(powerOutput);
        refresh();
    }

    public void createSetupPanelsTitles () {
        Label titleLabel = new Label("WPT System Simulation", 580, 0);
        Label powerSourceLabel = new Label("Power Sources", powerSourcesPanel.getX() + 20, powerSourcesPanel.getY() - 30);
        Label signalGeneratorsLabel = new Label("Signal Generators", signalGeneratorsPanel.getX() + 10, signalGeneratorsPanel.getY() - 30);
        Label amplifiersLabel = new Label("Amplifiers", amplifiersPanel.getX() + 30, amplifiersPanel.getY() - 30);
        Label transmittersLabel = new Label("Transmitters", transmittersPanel.getX() + 30, transmittersPanel.getY() - 30);
        Label receiversLabel = new Label("Receivers", receiverPanel.getX() + 30, receiverPanel.getY() - 30);
        Label payloadsLabel = new Label("Payloads", payloadPanel.getX() + 30, payloadPanel.getY() - 30);

        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 25));

        addLabel(titleLabel);
        addLabel(powerSourceLabel);
        addLabel(signalGeneratorsLabel);
        addLabel(amplifiersLabel);
        addLabel(transmittersLabel);
        addLabel(receiversLabel);
        addLabel(payloadsLabel);
    }

    public void clearSelectionPanel () {
        selectionPanel.clearPanel();
        powerSourcesPanel.setNumSelections(0);
        signalGeneratorsPanel.setNumSelections(0);
        amplifiersPanel.setNumSelections(0);
        transmittersPanel.setNumSelections(0);
        receiverPanel.setNumSelections(0);
        payloadPanel.setNumSelections(0);
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
            else if (receiverPanel.getNumSelections() == 1) {
                imageLabel = new Label(receiverPanel.getComponent().getImage());
                receiverPanel.setNumSelections(receiverPanel.getNumSelections() + 1);
            }
            else if (payloadPanel.getNumSelections() == 1) {
                imageLabel = new Label(payloadPanel.getComponent().getImage());
                payloadPanel.setNumSelections(payloadPanel.getNumSelections() + 1);
            }
            if (imageLabel != null)
                selectionPanel.add(imageLabel);
            refresh();
        }
        else if (e.getSource() == helperPanel.getSubmitButton()) {
            if ((powerSourcesPanel.getNumSelections() != 2) || (signalGeneratorsPanel.getNumSelections() != 2) || (transmittersPanel.getNumSelections() != 2))
                JOptionPane.showMessageDialog(null, "Fail: Select exactly one element from each subsystem, amplifiers are optional", "Error", JOptionPane.ERROR_MESSAGE);
            else {
                selectedPowerSource = (PowerSource) powerSourcesPanel.getComponent();
                selectedSignalGenerator = (SignalGenerator) signalGeneratorsPanel.getComponent();
                selectedAmplifier = (Amplifier) amplifiersPanel.getComponent();
                selectedTransmitter = (Transmitter) transmittersPanel.getComponent();
                selectedReceiver = (Receiver) receiverPanel.getComponent();
                selectedPayload = (Payload) payloadPanel.getComponent();
                JOptionPane.showMessageDialog(null, "Success: Your selections have been submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
                clearSelectionPanel();
                startResultsPanel();
            }
        }
        else if (e.getSource() == helperPanel.getClearButton())
            clearSelectionPanel();
    }
}
