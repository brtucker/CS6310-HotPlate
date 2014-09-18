package com.gatech.cs6310.project1.Tpdohp;

import com.gatech.cs6310.project1.models.*;

public class TpdohpSimulation {

	public String simulate(int dimension, double leftTemp, double topTemp,
			double rightTemp, double bottomTemp) {
		// TODO Auto-generated method stub
		
		Plate oldPlate = new Plate(dimension);
		Plate newPlate = new Plate(dimension);
		
		oldPlate.initialize(topTemp, bottomTemp, leftTemp, rightTemp);
		newPlate.initialize(0, 0, 0, 0);
		
		int iterationsMax = 0, iterations = 0;
		boolean isNoLongerChanging = false;
		
		iterationsMax = dimension * dimension * dimension;
		
		while(iterations < iterationsMax || isNoLongerChanging){
			for(int outerIndex = 1; outerIndex <= dimension; outerIndex++){
				
				for(int innerIndex = 1; innerIndex <= dimension; innerIndex++){
					double temp = (oldPlate.getTemp(outerIndex + 1,innerIndex) + oldPlate.getTemp(outerIndex - 1, innerIndex)
									+ oldPlate.getTemp(outerIndex, innerIndex + 1) + oldPlate.getTemp(outerIndex, innerIndex - 1))/4.0;
					newPlate.setCell(outerIndex, innerIndex, temp);
					
				}
				
			}
			//iteration count
			iterations++;
			
			//Change check
			if(oldPlate.getTemp(dimension/2, dimension/2) == newPlate.getTemp(dimension/2, dimension/2) && iterations > (dimension * dimension)){
				isNoLongerChanging = true;
			}
			
			//Swap Plates
			Plate tempPlate = new Plate();
			tempPlate = oldPlate;
			oldPlate = newPlate;
			newPlate = tempPlate;
			
		}
		
		return newPlate.toTableFormattedString();
	}

}
