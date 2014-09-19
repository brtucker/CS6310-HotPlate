package Gallhp;

import java.awt.Insets;
import javax.swing.JFrame;

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