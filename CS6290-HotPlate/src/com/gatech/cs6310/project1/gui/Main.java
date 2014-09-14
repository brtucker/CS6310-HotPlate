package com.gatech.cs6310.project1.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Main {

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
		frame.setSize(1000, 600);
		frame.setLayout(null);
	}

}
