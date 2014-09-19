package Tpdohp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import common.DiffusionMethod;
import common.Plate;
import common.SimulationResult;

public class Simulation extends DiffusionMethod{
	public Simulation() {	}
	Map<Integer, LatticePoint> oldPlate = null;
	Map<Integer, LatticePoint> newPlate = null;
	//double[][] oldPlate = null;
	//double[][] newPlate = null;
	public SimulationResult simulate(int dimension, double tempLeft, double tempTop, double tempRight, double tempBottom)
	{	
		oldPlate = initializePlate(dimension, tempTop, tempBottom, tempLeft, tempRight);
		newPlate = initializePlate(dimension, tempTop, tempBottom, tempLeft, tempRight);
		
		int iterationsMax = 0, iterations = 0;
		if (maxIterations == 0)
			iterationsMax = dimension * dimension * dimension * dimension  * dimension;
		else
			iterationsMax = maxIterations;
		ArrayList<Plate> plates = new ArrayList<Plate>(); 
		int durationSeconds = 0 ;
		long startTime  = System.currentTimeMillis();
		long startingMemory = Runtime.getRuntime().totalMemory();
		while(iterations < iterationsMax)
		{
			Plate plt = new Plate(dimension);
			int d = (int)Math.sqrt(newPlate.size());
			int outerCnt = 0;
			double deltaTempAccumulation = 0.0;
			for(int outerIndex = d + 1; outerCnt < d-2; outerIndex+=d)
			{
				int innerCnt= 0;
				for(int innerIndex = outerIndex + 1; innerIndex < outerIndex+d-1 ; innerIndex++)
				{
					int cellpos = innerIndex;
					int top = cellpos - d;
					int bottom = cellpos + d;
					int left = cellpos - 1;
					int right = cellpos + 1;
					//System.out.println("c: " + cellpos + "\t: " + top + "\tb: " + bottom + "\tl: " + left + "\tr: " + right);
					double t = (oldPlate.get(top).getTemp() + oldPlate.get(bottom).getTemp()
							+ oldPlate.get(left).getTemp() + oldPlate.get(right).getTemp()) /4.0;
					newPlate.get(cellpos).setTemp( t ); 
					//System.out.println("outercnt: " + outerCnt + "\tinnerCnt: " + innerCnt);
					deltaTempAccumulation += t - oldPlate.get(cellpos).getTemp(); 
					plt.setCell(outerCnt, innerCnt, t);
					innerCnt++;
				}
				outerCnt++;
			}

			plates.add(plt);
			//Iteration count
			iterations++;
			
			//Change check.  This picks the middle on odd values
			if( deltaTempAccumulation / dimension < stabilizationDelta)
			{
				break; //delta is under the threshold exit the loop
			}
			else
			{
				//Swap Plates
				Map<Integer, LatticePoint> tempPlate;
				tempPlate = oldPlate;
				oldPlate = newPlate;
				newPlate = tempPlate;
			}
			durationSeconds = (int)(System.currentTimeMillis() - startTime) * 1000;
			if (maxDuration > 0 && durationSeconds > maxDuration)
				break;
		}
		SimulationResult sr = new SimulationResult(iterations);
		sr.duration = (int)(System.currentTimeMillis() - startTime) * 1000;
		sr.memoryUsage = Runtime.getRuntime().totalMemory() - startingMemory;
		for (int i = 0; i < iterations; i++)
			sr.setPlate(i, plates.get(i));
		return sr;
	}
	
	public String toString() {
		String result = "";
		int dimension = (int)Math.sqrt(newPlate.size());
		int cnt = 0;
		for(int outerIndex = dimension + 1; cnt < dimension-2; outerIndex+=dimension)
		{
			for(int innerIndex = outerIndex + 1; innerIndex <= outerIndex+dimension-1; innerIndex++)
			{
				if (innerIndex % dimension != 0) //right side don't do anything
				{
					result += String.format( "%.2f", newPlate.get(innerIndex).getTemp()) + "\t";
				}
			}
			result += "\n";
			cnt++;
		}
		return result;
	}

	/**
	 * Set the edges of the plate to the values supplied.  The interior is zero.  That is created by the compiler as 
	 * that is the default.  http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
	 * @param top
	 * @param bottom
	 * @param left
	 * @param right
	 * @return
	 */
	private Map<Integer, LatticePoint> initializePlate(int dimension, double top, double bottom, double left, double right)
	{
		/*
		creates a HashMap where each location is a number.  add 2 then square it.  You have an addressing scheme like this:
+---+-----+------+------+-----+
|   |     |      |      |     |
|1  |  2  |   3  |   4  |   5 |
+-----------------------------+
|   |     |      |      |     |
|  6|  7  |  8   |   9  | 10  |
+-----------------------------+
|   | 12  |   13 |  14  |     |
|11 |     |      |      |  15 |
+-----------------------------+
|   |     | 18   |      |     |
|16 |  17 |      |  19  |  20 |
+-----------------------------+
|   |  22 |  23  |  24  |     |
|21 |     |      |      | 25  |
+---+-----+------+------+-----+
		 * 
		 */
		int dim = (dimension+2) * (dimension + 2);
		Map<Integer, LatticePoint> plate = new HashMap<Integer, LatticePoint>(dim);
		for (int i = 1; i <= dim; i++)
		{
			if (i < dimension+2) //top
				plate.put(i, new LatticePoint(top));
			else if (i >= dim - dimension - 1) //bottom side
				plate.put(i, new LatticePoint(bottom));
			else if (i % (dimension + 2) == 0) //right
				plate.put(i, new LatticePoint(right));
			else if ((i-1) % (dimension + 2) == 0) //left
				plate.put(i, new LatticePoint(left));
			else 
				plate.put(i, new LatticePoint(0));
		}
		return plate;
	}
	private class LatticePoint {
		private double temp = 0.0;
		public LatticePoint(double t) { temp = t;}
		public double getTemp() { return temp; }
		public void setTemp(double t) { temp = t; }
	}
}
