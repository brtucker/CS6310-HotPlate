package Gallhp;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;

//import Tpdahp.Simulation;
//import Tpfahp.Simulation;
//import Twfahp.Simulation;
//import Tpdohp.Simulation;

import common.DiffusionMethod;
import common.SimulationResult;


public class GUI extends JPanel{
	
	

	
	public static void addComponentsToPane(Container pane) {		

		// drop down list
		String[] experimentNames = { "Tpdahp", "Tpfahp", "Twfahp", "Tpdohp" };
		final JComboBox simulationList = new JComboBox(experimentNames);
		
		// button
		JButton runSimulationButton = new JButton("Run");
		
		// input/output boxes
		final JTextArea editTextDimension = new JTextArea("5");		
		final JTextArea editTextLeft = new JTextArea("5");
		final JTextArea editTextRight = new JTextArea("5");
		final JTextArea editTextTop = new JTextArea("5");
		final JTextArea editTextBottom = new JTextArea("5");
		final JTextArea outputWindow = new JTextArea("Sample Output");
		final JTextArea editTextMaxDuration = new JTextArea("maxDuration");
		final JTextArea editTextMaxIterations = new JTextArea("maxIterations");
		final JTextArea editTextStabilizationDelta = new JTextArea("stabilizationDelta");
		
		
		DrawnGrid dg = new DrawnGrid(550, BORDER_SIZE, 
                WINDOW_SIZE, WINDOW_SIZE);
		
		
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
		pane.add(outputWindow);
		pane.add(panelMiscInput);
		pane.add(dg);

		
		// one of two sub panels for input values
		// these are the "misc" ones...
		panelMiscInput.add(editTextMaxDuration);
		panelMiscInput.add(Box.createRigidArea(new Dimension(0,MISCPANELSPACING)));
		panelMiscInput.add(editTextMaxIterations);
		panelMiscInput.add(Box.createRigidArea(new Dimension(0,MISCPANELSPACING)));
		panelMiscInput.add(editTextStabilizationDelta);
		panelMiscInput.add(Box.createRigidArea(new Dimension(0,MISCPANELSPACING)));
		
		
		
		


		
		Insets insets = pane.getInsets();
		Dimension size = dg.getPreferredSize();
			

		
		size = dg.getPreferredSize();
		dg.setBounds(25 + insets.left, 50 + insets.top, size.width,
				size.height);
		
		size = panelMiscInput.getPreferredSize();
		panelMiscInput.setBounds(PANELMISCINPUTX + insets.left, 100 + insets.top, size.width,
				size.height);
		
		size = simulationList.getPreferredSize();
		simulationList.setBounds(25 + insets.left, 5 + insets.top, size.width,
				size.height);
		size = runSimulationButton.getPreferredSize();
		runSimulationButton.setBounds(145 + insets.left, 5 + insets.top, size.width, size.height);
		size = outputWindow.getPreferredSize();
		outputWindow.setBounds(20 + insets.left, 200 + insets.top, size.width + 395,
				size.height + 140);
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
//				int dimension = Integer.parseInt(editTextDimension.getText());
//				double leftTemp = Double.parseDouble(editTextLeft.getText());
//				double rightTemp = Double.parseDouble(editTextRight.getText());
//				double topTemp = Double.parseDouble(editTextTop.getText());
//				double bottomTemp = Double.parseDouble(editTextBottom.getText());
				SimulationResult output = simulation.simulate(5, 5, 5, 5, 5);
				//outputWindow.setText(output);
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

	private static final int PANELMISCINPUTX = 25;




}
