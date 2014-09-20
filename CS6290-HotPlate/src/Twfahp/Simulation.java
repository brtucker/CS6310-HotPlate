package Twfahp;
import common.*;

import java.util.ArrayList;
/*
 * The simulation class for the boxed float - Float
 */
public class Simulation extends DiffusionMethod {
	
	public Simulation() {	}
	Float[][] oldPlate = null;
	Float[][] newPlate = null;
	public SimulationResult simulate(int dimension, double tempLeft, double tempTop, double tempRight, double tempBottom)
	{	
		oldPlate = new Float[dimension + 2][dimension + 2];
		newPlate = new Float[dimension + 2][dimension + 2];
		
		oldPlate = this.initializePlate(oldPlate, tempTop, tempBottom, tempLeft, tempRight);
		newPlate = this.initializePlate(newPlate, tempTop, tempBottom, tempLeft, tempRight);
		
		int iterationsMax = 0, iterations = 0;
		if (maxIterations == 0)
			iterationsMax =   dimension * dimension * dimension * dimension;
		else
			iterationsMax = maxIterations;
		ArrayList<Plate> plates = new ArrayList<Plate>(); 
		int durationSeconds = 0 ;
		long startTime  = System.currentTimeMillis();
		long startingMemory = Runtime.getRuntime().totalMemory();
		while(iterations < iterationsMax)
		{
			Plate plt = new Plate(dimension);
			Float deltaTempAccumulation = 0.0F;
			for(int outerIndex = 1; outerIndex <= dimension; outerIndex++){
				for(int innerIndex = 1; innerIndex <= dimension; innerIndex++){
					newPlate[outerIndex][innerIndex] = (oldPlate[outerIndex + 1][innerIndex] + oldPlate[outerIndex - 1][innerIndex]
														+ oldPlate[outerIndex][innerIndex + 1] + oldPlate[outerIndex][innerIndex-1]) /4.0F;
					deltaTempAccumulation += newPlate[outerIndex][innerIndex] - oldPlate[outerIndex][innerIndex];
					plt.setCell(outerIndex-1, innerIndex-1, newPlate[outerIndex][innerIndex] );
				}
			}
			plates.add(plt);
			//Iteration count
			iterations++;
			
			//if we are out of time then exit.
			durationSeconds = (int)(System.currentTimeMillis() - startTime) / 1000;
			if (maxDuration > 0 && durationSeconds > maxDuration)
				break;
			//Change check.
			if( deltaTempAccumulation / dimension < stabilizationDelta)
			{
				break; //delta is under the threshold exit the loop
			}
			else
			{
				//Swap Plates
				Float[][] tempPlate;
				tempPlate = oldPlate;
				oldPlate = newPlate;
				newPlate = tempPlate;
			}
		}
		SimulationResult sr = new SimulationResult(iterations);
		sr.duration = (int) (System.currentTimeMillis() - startTime)   ;
		//sr.memoryUsage = Runtime.getRuntime().totalMemory() - startingMemory;
		
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		long memory = runtime.totalMemory() - runtime.freeMemory();
		sr.memoryUsage = memory / 1024; 

		for (int i = 0; i < iterations; i++)
			sr.setPlate(i, plates.get(i));
		return sr;
	}
	/*
	 * Write the grid as a string separating each cell by a tab and each row by a newline
	 */
	public String toString() {
		String result = "";
		int dimension = newPlate.length - 1;
		
		for(int outerIndex = 1; outerIndex < dimension; outerIndex++){
			
			for(int innerIndex = 1; innerIndex < dimension; innerIndex++){
				result += String.format( "%.2f", newPlate[outerIndex][innerIndex]) + "\t";
			}
			result += "\n";
		}
		return result;
	}

	/**
	 * Set the edges of the plate to the values supplied.  The interior is zero.  That is created by the compiler as 
	 * that is the default.  http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
	 * @param plate
	 * @param top
	 * @param bottom
	 * @param left
	 * @param right
	 * @return
	 */
	private Float[][] initializePlate(Float[][] plate, double top, double bottom, double left, double right)
	{
		for (int i = 0; i < plate.length; i++)
		{
			//set the edges
			plate[0][i] = Float.valueOf((float)top);	
			plate[i][0] = Float.valueOf((float)left);	
			plate[plate.length - 1][i] = Float.valueOf((float)bottom);
			plate[i][plate.length - 1] = Float.valueOf((float)right);
			//set the interior of the plate to zero
			if (i > 0 && i < plate.length - 1)
				for (int j = 1; j < plate.length - 1; j++ )
					plate[j][i] = 0.0F;
		}
		
		return plate;
	}
}
