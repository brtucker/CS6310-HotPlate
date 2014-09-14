package com.gatech.cs6310.project1.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.gatech.cs6310.project1.experiments.diffusion;

public class GUI extends JPanel {
	
	
	diffusion diffusionMethod;

	public GUI() {
		String[] equipermentList = { "Tpdahp", "Tpfahp", "Twfahp","Tpdohp" };
		JComboBox simulationList = new JComboBox(equipermentList);
		JButton runSimulationButton = new JButton("Run");
		JTextArea editTextLeft = new JTextArea("L");
		JTextArea editTextRight = new JTextArea("R");
		JTextArea editTextTop = new JTextArea("T");
		JTextArea editTextBottom = new JTextArea("B");
		JTextArea outputWindow = new JTextArea("Sample Output");
		
		
		simulationList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox tmpCombo = (JComboBox) e.getSource();
				String returnItem = (String) tmpCombo.getSelectedItem();
			}
		});
		this.setLayout(new BorderLayout());
		add(simulationList, BorderLayout.LINE_START);
		
		JPanel panel = new JPanel(new BorderLayout());
		//panel.setSize(600, 600);
		panel.add(editTextLeft, BorderLayout.EAST);
		panel.add(editTextTop, BorderLayout.NORTH);
		panel.add(editTextRight, BorderLayout.SOUTH);
		panel.add(editTextBottom, BorderLayout.WEST);
		add(panel, BorderLayout.CENTER);	
		JPanel bpanel = new JPanel(new BorderLayout());		
		bpanel.add(runSimulationButton, BorderLayout.PAGE_START);
		bpanel.add(outputWindow, BorderLayout.PAGE_END);
		add(bpanel,BorderLayout.PAGE_END);


//		
//		JTextArea e = new JTextArea("Basdfdsf");
//		panel.add(e,BorderLayout.PAGE_END);


		

	}
	
	

}
