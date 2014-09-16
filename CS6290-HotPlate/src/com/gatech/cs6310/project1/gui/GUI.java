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
		pane.setLayout(null);

		String[] equipermentList = { "Tpdahp", "Tpfahp", "Twfahp", "Tpdohp" };
		JComboBox simulationList = new JComboBox(equipermentList);
		JButton runSimulationButton = new JButton("Run");
		final JTextArea editTextDimension = new JTextArea("D");		
		JTextArea editTextLeft = new JTextArea("L");
		JTextArea editTextRight = new JTextArea("R");
		JTextArea editTextTop = new JTextArea("T");
		JTextArea editTextBottom = new JTextArea("B");
		final JTextArea outputWindow = new JTextArea("Sample Output");

		pane.add(simulationList);
		pane.add(runSimulationButton);
		pane.add(editTextDimension);
		pane.add(editTextBottom);
		pane.add(editTextTop);
		pane.add(editTextRight);
		pane.add(editTextLeft);
		pane.add(outputWindow);

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





}
