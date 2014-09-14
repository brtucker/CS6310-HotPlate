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
		simulationList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox tmpCombo = (JComboBox) e.getSource();
				String returnItem = (String) tmpCombo.getSelectedItem();
			}
		});
		add(simulationList, BorderLayout.WEST);
		add(editTextLeft, BorderLayout.SOUTH);

		add(editTextTop, BorderLayout.NORTH);
		add(editTextRight, BorderLayout.SOUTH);
		add(editTextBottom, BorderLayout.SOUTH);
		add(runSimulationButton, BorderLayout.WEST);

	}
	public static void main(String s[]) {
		JFrame frame = new JFrame("Heated Plate Simulation");
		frame.addWindowListener(new WindowAdapter() {

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.setContentPane(new GUI());
		frame.pack();
		frame.setVisible(true);
	}
}
