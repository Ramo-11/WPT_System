package GUI.Frames;

import GUI.Labels.Label;
import GUI.Panels.*;
import Classes.*;

import java.awt.event.*;
import javax.swing.JOptionPane;
import java.awt.LayoutManager;
import java.awt.FlowLayout;

public class MainFrame extends Frame {

    final static int GAP = 50;
    
    PowerSource selectedPowerSource;
    SignalGenerator selectedSignalGenerator;
    Amplifier selectedAmplifier;
    Transmitter selectedTransmitter;
    Receiver selectedReceiver;
    Payload selectedPayload;

    PowerSourcePanel powerSourcesPanel;
    SignalGeneratorPanel signalGeneratorsPanel;
    AmplifierPanel amplifiersPanel;
    TransmitterPanel transmittersPanel;
    ReceiverPanel receiverPanel;
    PayloadPanel payloadPanel;

    ResultsPanels resultsPanel;
    SelectionPanelHelperPanel helperPanel;

    OptionsPanel optionsPanel;
    SelectionPanel okPanel;

    public MainFrame (String title, LayoutManager layout) {
        super(title, layout);
        
        initializeComponents ();
        setupPanels();
    }

    public void initializeComponents () {
        selectedPowerSource = new PowerSource("");
        selectedSignalGenerator = new SignalGenerator("");
        selectedAmplifier = new Amplifier("");
        selectedTransmitter = new Transmitter("");
        selectedReceiver = new Receiver("");
        selectedPayload = new Payload("");
        
        okPanel = new SelectionPanel(new FlowLayout(FlowLayout.LEFT, 10, 20));
        optionsPanel = new OptionsPanel(new FlowLayout(FlowLayout.CENTER, 0, 50));

        powerSourcesPanel = new PowerSourcePanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        signalGeneratorsPanel = new SignalGeneratorPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        amplifiersPanel = new AmplifierPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        transmittersPanel = new TransmitterPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        receiverPanel = new ReceiverPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        payloadPanel = new PayloadPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));

        resultsPanel = new ResultsPanels(new FlowLayout(FlowLayout.LEFT, 70, 35));
        helperPanel = new SelectionPanelHelperPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
    }

    public void setupPanels () {

        powerSourcesPanel.setBounds(30, 30, 160, 170);
        signalGeneratorsPanel.setBounds(powerSourcesPanel.getX() + powerSourcesPanel.getWidth() + GAP, powerSourcesPanel.getY(), 160, 170);
        amplifiersPanel.setBounds(signalGeneratorsPanel.getX() + signalGeneratorsPanel.getWidth() + GAP, signalGeneratorsPanel.getY(), 160,170);

        transmittersPanel.setBounds(powerSourcesPanel.getX(), powerSourcesPanel.getY() + powerSourcesPanel.getHeight() + GAP, 160, 170);
        receiverPanel.setBounds(transmittersPanel.getX() + transmittersPanel.getWidth() + GAP, transmittersPanel.getY(), 160, 170);
        payloadPanel.setBounds(receiverPanel.getX() + receiverPanel.getWidth() + GAP, receiverPanel.getY(), 160, 170);

        resultsPanel.setBounds(transmittersPanel.getX(), transmittersPanel.getY() + transmittersPanel.getHeight() + 10, 1180, 170);
        helperPanel.setBounds(resultsPanel.getX(), resultsPanel.getY() + resultsPanel.getHeight() + 10, resultsPanel.getWidth(), 50);

        okPanel.setBounds(payloadPanel.getX() + payloadPanel.getWidth() + 50, powerSourcesPanel.getY(), 400, amplifiersPanel.getHeight() + payloadPanel.getHeight() + GAP);
        optionsPanel.setBounds(okPanel.getX() + okPanel.getWidth() + 10, okPanel.getY(), 140, okPanel.getHeight());

        createSetupPanelsTitles();

        addPanel(powerSourcesPanel);
        addPanel(signalGeneratorsPanel);
        addPanel(amplifiersPanel);
        addPanel(transmittersPanel);
        addPanel(receiverPanel);
        addPanel(payloadPanel);
        addPanel(resultsPanel);
        addPanel(helperPanel);
        addPanel(okPanel);
        addPanel(optionsPanel);

        assignListenerToHelpersButtons();
    }

    public void assignListenerToHelpersButtons () {
        helperPanel.getSelectButton().addActionListener(this);
        helperPanel.getSubmitButton().addActionListener(this);
        helperPanel.getClearButton().addActionListener(this);
    }

    public void createSetupPanelsTitles () {
        Label powerSourceLabel = new Label("Power Sources", powerSourcesPanel.getX() + 30, powerSourcesPanel.getY() - 30);
        Label signalGeneratorsLabel = new Label("Signal Generators", signalGeneratorsPanel.getX() + 20, signalGeneratorsPanel.getY() - 30);
        Label amplifiersLabel = new Label("Amplifiers", amplifiersPanel.getX() + 50, amplifiersPanel.getY() - 30);
        Label transmittersLabel = new Label("Transmitters", transmittersPanel.getX() + 40, transmittersPanel.getY() - 30);
        Label receiversLabel = new Label("Receivers", receiverPanel.getX() + 50, receiverPanel.getY() - 30);
        Label payloadsLabel = new Label("Payloads", payloadPanel.getX() + 50, payloadPanel.getY() - 30);

        addLabel(powerSourceLabel);
        addLabel(signalGeneratorsLabel);
        addLabel(amplifiersLabel);
        addLabel(transmittersLabel);
        addLabel(receiversLabel);
        addLabel(payloadsLabel);
    }

    public void clearSelectionPanel () {
        resultsPanel.clearPanel();
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
                okPanel.add(imageLabel);
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
                resultsPanel.startResultsPanel(selectedPowerSource, selectedSignalGenerator, selectedAmplifier, selectedTransmitter, selectedReceiver, selectedPayload);
            }
        }
        else if (e.getSource() == helperPanel.getClearButton())
            clearSelectionPanel();
    }
}
