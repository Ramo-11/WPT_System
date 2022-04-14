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
    Transmitter selectedMetamaterial;
    Receiver selectedReceiver;
    Load selectedPayload;

    PowerSourcePanel powerSourcesPanel;
    SignalGeneratorPanel signalGeneratorsPanel;
    AmplifierPanel amplifiersPanel;
    TransmitterPanel transmittersPanel;
    MetamaterialPanel metamaterialPanel;
    ReceiverPanel receiverPanel;
    LoadPanel loadPanel;

    ResultsPanels resultsPanel;
    HelperPanel helperPanel;

    SelectionPanel selectionPanel;

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
        selectedMetamaterial = new Transmitter("");
        selectedReceiver = new Receiver("");
        selectedPayload = new Load("");
        
        powerSourcesPanel = new PowerSourcePanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        signalGeneratorsPanel = new SignalGeneratorPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        amplifiersPanel = new AmplifierPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        transmittersPanel = new TransmitterPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        metamaterialPanel = new MetamaterialPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        receiverPanel = new ReceiverPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));
        loadPanel = new LoadPanel(new FlowLayout(FlowLayout.CENTER, 0, 20));

        selectionPanel = new SelectionPanel(new FlowLayout(FlowLayout.CENTER, 50, 40));

        resultsPanel = new ResultsPanels(new FlowLayout(FlowLayout.CENTER, 5, 10));
        helperPanel = new HelperPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
    }

    public void setupPanels () {

        powerSourcesPanel.setBounds(30, 30, 160, 170);
        signalGeneratorsPanel.setBounds(powerSourcesPanel.getX() + powerSourcesPanel.getWidth() + GAP, powerSourcesPanel.getY(), 160, 170);
        amplifiersPanel.setBounds(signalGeneratorsPanel.getX() + signalGeneratorsPanel.getWidth() + GAP, signalGeneratorsPanel.getY(), 160,170);
        transmittersPanel.setBounds(powerSourcesPanel.getX(), powerSourcesPanel.getY() + powerSourcesPanel.getHeight() + GAP, 160, 170);
        receiverPanel.setBounds(transmittersPanel.getX() + transmittersPanel.getWidth() + GAP, transmittersPanel.getY(), 160, 170);
        loadPanel.setBounds(receiverPanel.getX() + receiverPanel.getWidth() + GAP, receiverPanel.getY(), 160, 170);

        selectionPanel.setBounds(loadPanel.getX() + loadPanel.getWidth() + 50, powerSourcesPanel.getY(), 550, amplifiersPanel.getHeight() + loadPanel.getHeight() + GAP - 40);
        
        metamaterialPanel.setBounds(selectionPanel.getX() + 215, loadPanel.getY() + loadPanel.getHeight() - 30, 120, 30);

        resultsPanel.setBounds(transmittersPanel.getX(), transmittersPanel.getY() + transmittersPanel.getHeight() + 10, 1180, 170);
        helperPanel.setBounds(resultsPanel.getX(), resultsPanel.getY() + resultsPanel.getHeight() + 10, resultsPanel.getWidth(), 50);

        createSetupPanelsTitles();

        addPanel(powerSourcesPanel);
        addPanel(signalGeneratorsPanel);
        addPanel(amplifiersPanel);
        addPanel(transmittersPanel);
        addPanel(receiverPanel);
        addPanel(loadPanel);
        addPanel(metamaterialPanel);
        addPanel(resultsPanel);
        addPanel(helperPanel);
        addPanel(selectionPanel);

        assignListenerToHelpersButtons();
    }

    public void assignListenerToHelpersButtons () {
        helperPanel.getSelectButton().addActionListener(this);
        helperPanel.getSubmitButton().addActionListener(this);
        helperPanel.getClearButton().addActionListener(this);
    }

    public void createSetupPanelsTitles () {
        Label powerSourceLabel = new Label("Power Sources*", powerSourcesPanel.getX() + 30, powerSourcesPanel.getY() - 30);
        Label signalGeneratorsLabel = new Label("Signal Generators*", signalGeneratorsPanel.getX() + 20, signalGeneratorsPanel.getY() - 30);
        Label amplifiersLabel = new Label("Amplifiers", amplifiersPanel.getX() + 50, amplifiersPanel.getY() - 30);
        Label transmittersLabel = new Label("Transmitters*", transmittersPanel.getX() + 40, transmittersPanel.getY() - 30);
        Label receiversLabel = new Label("Receivers*", receiverPanel.getX() + 50, receiverPanel.getY() - 30);
        Label payloadsLabel = new Label("Loads*", loadPanel.getX() + 60, loadPanel.getY() - 30);

        addLabel(powerSourceLabel);
        addLabel(signalGeneratorsLabel);
        addLabel(amplifiersLabel);
        addLabel(transmittersLabel);
        addLabel(receiversLabel);
        addLabel(payloadsLabel);
    }

    public void clearPanels () {
        Transmitter c = new Transmitter("", 1.0, "");
        Amplifier a = new Amplifier("", 0, "");

        selectionPanel.clearPanel();
        powerSourcesPanel.setNumSelections(0);
        powerSourcesPanel.setColorToDefault();
        signalGeneratorsPanel.setNumSelections(0);
        signalGeneratorsPanel.setColorToDefault();
        amplifiersPanel.setNumSelections(0);
        amplifiersPanel.setColorToDefault();
        amplifiersPanel.setSelectedComponent(a);
        selectedAmplifier = (Amplifier) amplifiersPanel.getComponent();
        transmittersPanel.setNumSelections(0);
        transmittersPanel.setColorToDefault();
        metamaterialPanel.setNumSelections(0);
        metamaterialPanel.setColorToDefault();
        metamaterialPanel.setSelectedComponent(c);
        selectedMetamaterial = (Transmitter) metamaterialPanel.getComponent();
        receiverPanel.setNumSelections(0);
        receiverPanel.setColorToDefault();
        loadPanel.setNumSelections(0);
        loadPanel.setColorToDefault();
    }

    public void clearEverything() {
        clearPanels();
        resultsPanel.clearPanel();
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
            else if (metamaterialPanel.getNumSelections() == 1) {
                imageLabel = new Label(metamaterialPanel.getComponent().getImage());
                metamaterialPanel.setNumSelections(metamaterialPanel.getNumSelections() + 1);
            }
            else if (receiverPanel.getNumSelections() == 1) {
                imageLabel = new Label(receiverPanel.getComponent().getImage());
                receiverPanel.setNumSelections(receiverPanel.getNumSelections() + 1);
            }
            else if (loadPanel.getNumSelections() == 1) {
                imageLabel = new Label(loadPanel.getComponent().getImage());
                loadPanel.setNumSelections(loadPanel.getNumSelections() + 1);
            }
            if (imageLabel != null)
                selectionPanel.add(imageLabel);
            refresh();
        }
        else if (e.getSource() == helperPanel.getSubmitButton()) {
            if ((powerSourcesPanel.getNumSelections() != 2) || (signalGeneratorsPanel.getNumSelections() != 2) || (transmittersPanel.getNumSelections() != 2)
                  || (receiverPanel.getNumSelections() != 2) || (loadPanel.getNumSelections() != 2))
                JOptionPane.showMessageDialog(null, "Fail: Select exactly one element from each subsystem, amplifiers are optional", "Error", JOptionPane.ERROR_MESSAGE);
            else {
                selectedPowerSource = (PowerSource) powerSourcesPanel.getComponent();
                selectedSignalGenerator = (SignalGenerator) signalGeneratorsPanel.getComponent();
                selectedTransmitter = (Transmitter) transmittersPanel.getComponent();
                selectedReceiver = (Receiver) receiverPanel.getComponent();
                selectedPayload = (Load) loadPanel.getComponent();
                try {
                    selectedAmplifier = (Amplifier) amplifiersPanel.getComponent();
                } catch (Exception ex) {
                    System.out.println("Exception was caught: No amplifier was picked");
                }
                try {
                    selectedMetamaterial = (Transmitter) metamaterialPanel.getComponent();
                } catch (Exception ex) {
                    System.out.println("Exception was caught: No metamaterial was picked");
                }
                JOptionPane.showMessageDialog(null, "Success: Your selections have been submitted", "Success", JOptionPane.INFORMATION_MESSAGE);
                resultsPanel.startResultsPanel(selectedPowerSource, selectedSignalGenerator, selectedAmplifier, selectedTransmitter, selectedMetamaterial, selectedReceiver, selectedPayload);
            }
        }
        else if (e.getSource() == helperPanel.getClearButton())
            clearEverything();
    }
}
