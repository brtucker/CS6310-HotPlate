package com.gatech.cs6310.project1.common;

public abstract class DiffusionMethod {
	public int maxDuration = 0;
	public int maxIterations = 0;
	public double stabilizationDelta = 1.0;
	
	abstract public SimulationResult simulate(int dimension, double tempLeft,
			double tempTop, double tempRight,
			double tempBottom);

}
