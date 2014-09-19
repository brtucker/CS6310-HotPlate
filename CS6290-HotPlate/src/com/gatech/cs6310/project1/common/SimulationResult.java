package com.gatech.cs6310.project1.common;

/*
 * The common class for all simulations to return their results.
 */
public class SimulationResult {
	public int duration;  //milliseconds as determined by the OS
	public int iterations;
	public long memoryUsage;  //bytes
	private Plate[] plates;
	
	public void setPlate(int iteration, Plate plate)
	{
		plates[iteration] = plate;
	}
	public Plate getPlate(int iteration)
	{
		if (iteration > iterations || iteration < 0)
			throw new IllegalArgumentException("The iteration you asked for is not in range:  select 0 to " + (iterations-1));
		return plates[iteration];
	}
	public SimulationResult(int iterations) {
		this.iterations = iterations;
		plates = new Plate[iterations];
	}
}
