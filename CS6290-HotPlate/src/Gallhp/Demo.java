package Gallhp;
import common.DiffusionMethod;
import common.SimulationResult;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.JTextArea;

public class Demo {

	private JFrame frame;
	private JTextField textFieldTop;
	private JTextField textFieldLeft;
	private JTextField textFieldRight;
	private JTextField textFieldBottom;
	private JTextField textFieldMaxIterations;
	private JTextField textFieldMaxDuration;
	private JTextField textFieldStabilDelta;
	private JTextField textFieldDimension;
	private JTextField textFieldIterations;
	private JTextField textFieldDuration;
	private JTextField textFieldMemUsage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo window = new Demo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Demo() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 534, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Intial Edge Temperatures", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(65, 51, 235, 116);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		textFieldTop = new JTextField();
		textFieldTop.setText("100");
		textFieldTop.setBounds(81, 16, 69, 20);
		panel.add(textFieldTop);
		textFieldTop.setColumns(10);
		//lblTop.setLabelFor(textFieldTop);
		
		JLabel lblTop = new JLabel("Top");
		lblTop.setBounds(48, 16, 27, 14);
		panel.add(lblTop);
		lblTop.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblLeft = new JLabel("Left");
		lblLeft.setBounds(6, 41, 27, 14);
		panel.add(lblLeft);
		lblLeft.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLeft.setLabelFor(textFieldLeft);
		
		textFieldLeft = new JTextField();
		textFieldLeft.setText("100");
		textFieldLeft.setBounds(6, 58, 69, 20);
		panel.add(textFieldLeft);
		textFieldLeft.setColumns(10);
		
		JLabel lblRight = new JLabel("Right");
		lblRight.setBounds(160, 41, 27, 14);
		panel.add(lblRight);
		lblRight.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRight.setLabelFor(textFieldRight);
		
		textFieldRight = new JTextField();
		textFieldRight.setText("100");
		textFieldRight.setBounds(160, 58, 69, 20);
		panel.add(textFieldRight);
		textFieldRight.setColumns(10);
		
		JLabel lblBottom = new JLabel("Bottom");
		lblBottom.setBounds(23, 89, 52, 14);
		panel.add(lblBottom);
		lblBottom.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBottom.setLabelFor(textFieldBottom);
		
		textFieldBottom = new JTextField();
		textFieldBottom.setText("100");
		textFieldBottom.setBounds(81, 89, 69, 20);
		panel.add(textFieldBottom);
		textFieldBottom.setColumns(10);
		
		final JComboBox comboBoxSimulationList = new JComboBox();
		comboBoxSimulationList.setModel(new DefaultComboBoxModel(new String[] {"Tpdahp", "Tpfahp", "Twfahp", "Tpdohp"}));
		comboBoxSimulationList.setBounds(93, 20, 68, 20);
		frame.getContentPane().add(comboBoxSimulationList);
		
		JLabel lblSimulationName = new JLabel("Simulation Name");
		lblSimulationName.setBounds(10, 23, 79, 14);
		frame.getContentPane().add(lblSimulationName);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Options", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(340, 43, 167, 92);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		textFieldMaxIterations = new JTextField();
		textFieldMaxIterations.setBounds(101, 16, 60, 20);
		panel_1.add(textFieldMaxIterations);
		textFieldMaxIterations.setText("0");
		textFieldMaxIterations.setColumns(10);
		
		textFieldMaxDuration = new JTextField();
		textFieldMaxDuration.setBounds(101, 40, 60, 20);
		panel_1.add(textFieldMaxDuration);
		textFieldMaxDuration.setText("0");
		textFieldMaxDuration.setColumns(10);
		
		textFieldStabilDelta = new JTextField();
		textFieldStabilDelta.setBounds(101, 65, 60, 20);
		panel_1.add(textFieldStabilDelta);
		textFieldStabilDelta.setText("1.0");
		textFieldStabilDelta.setColumns(10);
		
		JLabel lblMaxIterations = new JLabel("Max Iterations");
		lblMaxIterations.setBounds(16, 22, 79, 14);
		panel_1.add(lblMaxIterations);
		lblMaxIterations.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblMaxDuration = new JLabel("Max Duration");
		lblMaxDuration.setBounds(16, 46, 79, 14);
		panel_1.add(lblMaxDuration);
		lblMaxDuration.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblStabilizationDelta = new JLabel("Stabilization Delta");
		lblStabilizationDelta.setBounds(6, 68, 92, 14);
		panel_1.add(lblStabilizationDelta);
		lblStabilizationDelta.setHorizontalAlignment(SwingConstants.RIGHT);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Results", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 162, 501, 264);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblIterations = new JLabel("Iterations");
		lblIterations.setBounds(16, 22, 79, 14);
		panel_2.add(lblIterations);
		lblIterations.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldIterations = new JTextField();
		textFieldIterations.setBounds(101, 16, 60, 20);
		panel_2.add(textFieldIterations);
		textFieldIterations.setText("0");
		textFieldIterations.setColumns(10);
		
		textFieldDuration = new JTextField();
		textFieldDuration.setBounds(256, 16, 60, 20);
		panel_2.add(textFieldDuration);
		textFieldDuration.setText("0");
		textFieldDuration.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setBounds(171, 22, 79, 14);
		panel_2.add(lblDuration);
		lblDuration.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblMemoryUsage = new JLabel("Memory Usage");
		lblMemoryUsage.setBounds(340, 19, 92, 14);
		panel_2.add(lblMemoryUsage);
		lblMemoryUsage.setHorizontalAlignment(SwingConstants.RIGHT);
		
		textFieldMemUsage = new JTextField();
		textFieldMemUsage.setBounds(435, 16, 60, 20);
		panel_2.add(textFieldMemUsage);
		textFieldMemUsage.setText("1.0");
		textFieldMemUsage.setColumns(10);

		final JTextArea textAreaResults = new JTextArea();
		textAreaResults.setBounds(6, 49, 489, 208);
		panel_2.add(textAreaResults);
		
		JButton btnRun = new JButton("Run");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String simulationname = comboBoxSimulationList.getSelectedItem().toString();
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
				int dimension;
				int maxDuration;
				int maxIterations;
				double stabilizationDelta;
				double leftTemp;
				double rightTemp;
				double topTemp;
				double bottomTemp;
				try {
					dimension = Integer.parseInt(textFieldDimension.getText());
					maxDuration = Integer.parseInt(textFieldMaxDuration.getText());
					maxIterations = Integer.parseInt(textFieldMaxIterations.getText()); 
					stabilizationDelta = Double.parseDouble(textFieldStabilDelta.getText());
					leftTemp = Double.parseDouble(textFieldLeft.getText());
					rightTemp = Double.parseDouble(textFieldRight.getText());
					topTemp = Double.parseDouble(textFieldTop.getText());
					bottomTemp = Double.parseDouble(textFieldBottom.getText());

					if (dimension < 2 || dimension > 100)
					{
						JOptionPane.showMessageDialog (null, "Dimension must be between 1 and 100");
						return;
					}
					if (maxDuration < 0)
					{
						JOptionPane.showMessageDialog (null, "Max Duration must be greater than -1");
						return;
					}
					if (maxIterations < 0)
					{
						JOptionPane.showMessageDialog (null, "Max Iterations must be greater than -1");
						return;
					}
					simulation.maxDuration = maxDuration;
					simulation.maxIterations = maxIterations;
					simulation.stabilizationDelta= stabilizationDelta;

					SimulationResult output = simulation.simulate(dimension, leftTemp, topTemp, rightTemp, bottomTemp);
					String results = output.getPlate(output.iterations-1).toTableFormattedString();
					textAreaResults.setText(results);
					textFieldIterations.setText(String.valueOf(output.iterations));
					textFieldDuration.setText(String.valueOf(output.duration));
					textFieldMemUsage.setText(String.valueOf(output.memoryUsage));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog (null, "All inputs are numeric.  The dimension, top, left, right and bottom values are between 1-100.  Max Duration and Max Iterations are 0 or greater.  Zero uses the default value for the simulation.  Stabilization delta is between 0.0 and 1.0");

					e.printStackTrace();
				}

			}
		});
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{comboBoxSimulationList, textFieldDimension, textFieldTop, textFieldLeft, textFieldRight, textFieldBottom, textFieldMaxIterations, textFieldMaxDuration, textFieldStabilDelta, btnRun}));
		btnRun.setBounds(416, 140, 89, 23);
		frame.getContentPane().add(btnRun);
		
		JLabel lblPlateDimension = new JLabel("Plate Dimension");
		lblPlateDimension.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPlateDimension.setBounds(171, 20, 78, 20);
		frame.getContentPane().add(lblPlateDimension);
		
		textFieldDimension = new JTextField();
		textFieldDimension.setText("100");
		textFieldDimension.setColumns(10);
		textFieldDimension.setBounds(259, 20, 41, 20);
		frame.getContentPane().add(textFieldDimension);
		
		
	}
}
