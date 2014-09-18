package com.gatech.cs6310.project1.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Main {
	
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
	
	
	


	private static void createAndShowGUI() {

		JFrame frame = new JFrame("Hot Plate Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GUI.addComponentsToPane(frame.getContentPane());


		Insets insets = frame.getInsets();
		frame.setSize(890 + insets.left + insets.right, 400 + insets.top
				+ insets.bottom);
		frame.setVisible(true);
	}


}