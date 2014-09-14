package com.gatech.cs6310.project1.gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.gatech.cs6310.project1.experiments.diffusion;

public class GUI extends JPanel {
	
	
	diffusion diffusionMethod;

	public GUI() {
		String[] comboTypes = { "Tpdahp", "Tpfahp", "Twfahp","Tpdohp" };
		JComboBox simulationList = new JComboBox(comboTypes);
		simulationList.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JComboBox jcmbType = (JComboBox) e.getSource();
				String cmbType = (String) jcmbType.getSelectedItem();
			}
		});
		setLayout(new BorderLayout());
		add(simulationList, BorderLayout.NORTH);
		setBorder(BorderFactory.createEmptyBorder(300, 300, 300, 300));
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
