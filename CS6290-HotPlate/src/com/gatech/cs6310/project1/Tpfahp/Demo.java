package com.gatech.cs6310.project1.Tpfahp;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TpfahpSimulation simulation = new TpfahpSimulation();
		
		int dimension = Integer.parseInt(args[1]);
		float leftTemp = Float.parseFloat(args[2]);
		float rightTemp = Float.parseFloat(args[3]);
		float topTemp = Float.parseFloat(args[4]);
		float bottomTemp = Float.parseFloat(args[5]);
		
		System.out.println(simulation.simulate(dimension, leftTemp, topTemp, rightTemp, bottomTemp));
		
	}

}
