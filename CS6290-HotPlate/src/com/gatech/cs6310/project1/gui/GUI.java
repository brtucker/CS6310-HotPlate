package com.gatech.cs6310.project1.gui;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class GUI extends JPanel{
	
	
	public void paintComponent(Graphics g) {
		  // super.paintComponent(g);
		   Graphics2D g2d = (Graphics2D)g;
		   g.drawOval(10, 10, 10, 10);
		  
		}
	
	public static void addComponentsToPane(Container pane) {
		//pane.setLayout(null);
		

		String[] equipermentList = { "Tpdahp", "Tpfahp", "Twfahp", "Tpdohp" };
		JComboBox simulationList = new JComboBox(equipermentList);
		JButton runSimulationButton = new JButton("Run");
		final JTextArea editTextDimension = new JTextArea("D");		
		final JTextArea editTextLeft = new JTextArea("L");
		final JTextArea editTextRight = new JTextArea("R");
		final JTextArea editTextTop = new JTextArea("T");
		final JTextArea editTextBottom = new JTextArea("B");
		final JTextArea outputWindow = new JTextArea("Sample Output");

		pane.add(simulationList);
		pane.add(runSimulationButton);
		pane.add(editTextDimension);
		pane.add(editTextBottom);
		pane.add(editTextTop);
		pane.add(editTextRight);
		pane.add(editTextLeft);
		pane.add(outputWindow);
		
		DrawnGrid dg = new DrawnGrid(BORDER_SIZE, BORDER_SIZE, 
                WINDOW_SIZE, WINDOW_SIZE);
		
		pane.add(dg);

		
		Insets insets = pane.getInsets();
		Dimension size = simulationList.getPreferredSize();

		
		simulationList.setBounds(25 + insets.left, 5 + insets.top, size.width,
				size.height);
		size = runSimulationButton.getPreferredSize();
		runSimulationButton.setBounds(55 + insets.left, 40 + insets.top, size.width, size.height);
		size = outputWindow.getPreferredSize();
		outputWindow.setBounds(20 + insets.left, 250 + insets.top, size.width + 500,
				size.height + 100);
		size = editTextDimension.getPreferredSize();
		editTextDimension.setBounds(200 + insets.left, 125 + insets.top, size.width + 50,
				size.height);
		editTextLeft.setBounds(300 + insets.left, 125 + insets.top, size.width + 50,
				size.height);
		editTextRight.setBounds(440 + insets.left, 125 + insets.top, size.width + 50,
				size.height);		
		editTextTop.setBounds(370 + insets.left, 75 + insets.top, size.width + 50,
				size.height);
		editTextBottom.setBounds(370 + insets.left, 175 + insets.top, size.width + 50,
				size.height);
		
		
		runSimulationButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){
				outputWindow.setText(editTextDimension.getText());
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
    private final static int WINDOW_SIZE = 400;
    
    /**
     * Amount of border space around the DrawnGrid in pixels
     */
    private final static int BORDER_SIZE = 50;

    /**
     * Height and width of the DrawnGrid in pixels 
     */
    private final static int GRID_SIZE = WINDOW_SIZE - 2 * BORDER_SIZE;
    
    /**
     * Number of rows of cells in the DrawnGrid 
     */
    private static final int NUMBER_OF_ROWS = 6;
    
    /**
     * Number of cells in a row 
     */
    private static final int NUMBER_OF_COLUMNS = 6;
    
    /**
     * The height of a cell in pixels 
     */
    private static final int CELL_HEIGHT = GRID_SIZE / NUMBER_OF_COLUMNS;

    /**
     * The width of a cell in pixels
     */
    private static final int CELL_WIDTH = GRID_SIZE / NUMBER_OF_ROWS;





}
