package com.gatech.cs6310.project1.Tpdahp;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TpdahpSimulation simulation = new TpdahpSimulation();
		
		int dimension = Integer.parseInt(args[1]);
		double leftTemp = Double.parseDouble(args[2]);
		double rightTemp = Double.parseDouble(args[3]);
		double topTemp = Double.parseDouble(args[4]);
		double bottomTemp = Double.parseDouble(args[5]);
		
		System.out.println(simulation.simulate(dimension, leftTemp, topTemp, rightTemp, bottomTemp));
		
	}

}
