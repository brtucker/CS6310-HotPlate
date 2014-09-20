package Gallhp;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.StyledDocument;

//import Tpdahp.Simulation;
//import Tpfahp.Simulation;
//import Twfahp.Simulation;
//import Tpdohp.Simulation;

import common.DiffusionMethod;
import common.SimulationResult;


public class GUI extends JPanel{

	public static void addComponentsToPane(final Container pane) {		

		// drop down list
		String[] experimentNames = { "Tpdahp", "Tpfahp", "Twfahp", "Tpdohp" };
		final JComboBox simulationList = new JComboBox(experimentNames);
		
		// button
		JButton runSimulationButton = new JButton("Run");
		
		// input/output boxes
		final JTextField editTextDimension = new JTextField("5");		
		final JTextField editTextLeft = new JTextField("100");
		final JTextField editTextRight = new JTextField("100");
		final JTextField editTextTop = new JTextField("100");
		final JTextField editTextBottom = new JTextField("100");
		
		
		
		
		final JTextArea editTextDurationLabel = new JTextArea("Duration");

		final JTextArea editTextMemoryLabel = new JTextArea("Memory");
		final JTextArea editTextDuration = new JTextArea("");

		final JTextArea editTextMemory = new JTextArea("sadf");

		final JTextField textResults = new JTextField("");
		
		
		// scrolling output window for displaying results
		final JTextArea outputWindow = new JTextArea();
		outputWindow.setEditable(false);
		JScrollPane scroll = new JScrollPane(outputWindow);
		

		
		final JTextField editTextMaxDuration = new JTextField("0"); //"maxDuration"
		final JTextField editTextMaxIterations = new JTextField("0"); //"maxIterations"
		final JTextField editTextStabilizationDelta = new JTextField("1"); //stabilizationDelta
		

		

		
		// panels
		JPanel panelMiscInput = new JPanel();
		panelMiscInput.setLayout(new BoxLayout(panelMiscInput, BoxLayout.Y_AXIS));


		// add all objects to main window (pane)
		pane.add(simulationList);
		pane.add(runSimulationButton);
		pane.add(editTextDimension);
		pane.add(editTextBottom);
		pane.add(editTextTop);
		pane.add(editTextRight);
		pane.add(editTextLeft);
		pane.add(editTextMemory);
		pane.add(editTextDuration);
		pane.add(scroll);
		pane.add(panelMiscInput);
		pane.add(textResults);


		
		// one of two sub panels for input values
		// these are the "misc" ones...
		panelMiscInput.add(editTextMaxDuration);
		panelMiscInput.add(Box.createRigidArea(new Dimension(0,MISCPANELSPACING)));
		panelMiscInput.add(editTextMaxIterations);
		panelMiscInput.add(Box.createRigidArea(new Dimension(0,MISCPANELSPACING)));
		panelMiscInput.add(editTextStabilizationDelta);
		panelMiscInput.add(Box.createRigidArea(new Dimension(0,MISCPANELSPACING)));
		

		
		Insets insets = pane.getInsets();
		Dimension size;
		

		
		size = panelMiscInput.getPreferredSize();
		panelMiscInput.setBounds(35 + insets.left, 60 + insets.top, size.width,
				size.height);
		
		size = simulationList.getPreferredSize();
		simulationList.setBounds(25 + insets.left, 5 + insets.top, size.width,
				size.height);
		size = runSimulationButton.getPreferredSize();
		runSimulationButton.setBounds(145 + insets.left, 5 + insets.top, size.width, size.height);

		size = outputWindow.getPreferredSize();
		
		outputWindow.setBounds(insets.left,insets.top,size.width ,size.height);	
		size = scroll.getPreferredSize();
		scroll.setBounds(25 + insets.left, 200 + insets.top, size.width + 540,size.height + 140);
		size = editTextDimension.getPreferredSize();
		editTextDimension.setBounds(175 + insets.left, 75 + insets.top, size.width + 50,
				size.height);
		editTextLeft.setBounds(300 + insets.left, 75 + insets.top, size.width + 50,
				size.height);
		editTextRight.setBounds(440 + insets.left, 75 + insets.top, size.width + 50,
				size.height);		
		editTextTop.setBounds(370 + insets.left, 25 + insets.top, size.width + 50,
				size.height);
		editTextBottom.setBounds(370 + insets.left, 125 + insets.top, size.width + 50,
				size.height);
		editTextMemory.setBounds(370 + insets.left, 160 + insets.top, size.width + 50,
				size.height);
		textResults.setBounds(270 + insets.left, 160 + insets.top, size.width + 50,
				size.height);
		
		runSimulationButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){

				String simulationname = simulationList.getSelectedItem().toString();
				//{ "Tpdahp", "Tpfahp", "Twfahp", "Tpdohp" };
				DiffusionMethod simulation = null;
				if (simulationname.equals("Tpdahp"))
					simulation = new Tpdahp.Simulation();
				else if (simulationname.equals("Tpfahp"))
					simulation = new Tpfahp.Simulation();
				else if (simulationname.equals("Twfahp"))
					simulation = new Twfahp.Simulation();
				else if (simulationname.equals("Tpdohp"))
					simulation = new Tpdohp.Simulation();

				
				// convert input from string to int also validate that they are numbers from 0 - 100
				int dimension = (int) validateInput(pane, editTextDimension);
				int maxDuration = (int) validateInput(pane, editTextMaxDuration);
				int maxIterations = (int) validateInput(pane, editTextMaxIterations); 
				double stabilizationDelta = Double.parseDouble(editTextStabilizationDelta.getText());
				double leftTemp = validateInput(pane, editTextLeft);
				double rightTemp = validateInput(pane, editTextRight);
				double topTemp = validateInput(pane, editTextTop);
				double bottomTemp = validateInput(pane, editTextBottom);

				simulation.maxDuration = maxDuration;
				simulation.maxIterations = maxIterations;
				simulation.stabilizationDelta= stabilizationDelta;
				SimulationResult output = simulation.simulate(dimension, leftTemp, topTemp, rightTemp, bottomTemp);

				String results = output.getPlate(output.iterations-1).toTableFormattedString();
				results = results + "\nDuration: " + output.duration + " mS" + "\nMemory Usage: " +output.memoryUsage+ " KB";
			

				outputWindow.setText(results);

				

			}

			private double validateInput(final Container pane,
					final JTextField editTextDimension) {
				double input = 0;
				try 
				{
					input = Integer.parseInt(editTextDimension.getText());
					
				} 
				catch (NumberFormatException exp)
				{
					JOptionPane.showMessageDialog(pane,
						    "Please enter a value from 0 - 100.");
				};
				if (input < LOWINPUTVALUE || input > HIINPUTVALUE){
					JOptionPane.showMessageDialog(pane,
						    "Please enter a value from 0 - 100.");
				}
				return input;
			}


		});
		
		simulationList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox tmpCombo = (JComboBox) e.getSource();
				outputWindow.setText((String) tmpCombo.getSelectedItem());
			}
		});
		
	}
	

	
	 /**
     * Size of the containing window in pixels
     */
    private final static int WINDOW_SIZE = 3000;
    
    /**
     * Amount of border space around the DrawnGrid in pixels
     */
    private final static int BORDER_SIZE = 50;


	private static final int MISCPANELSPACING = 15;

	
	protected static final int LOWINPUTVALUE = 0;

	protected static final int HIINPUTVALUE = 100;

}
