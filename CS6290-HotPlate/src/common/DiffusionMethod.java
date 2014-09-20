package common;


public abstract class DiffusionMethod {
	public int maxDuration = 0;
	public int maxIterations = 800;
	public double stabilizationDelta = 1.0;
	
	abstract public SimulationResult simulate(int dimension, double tempLeft,
			double tempTop, double tempRight,
			double tempBottom);

}
