package com.gatech.cs6310.project1.Twfahp;

public class TwfahpSimulation {
	
	public String simulate(int dimension, Float tempLeft,
			Float tempTop, Float tempRight,
			Float tempBottom){

		Float[][] oldPlate = new Float[dimension + 2][dimension + 2];
		Float[][] newPlate = new Float[dimension + 2][dimension + 2];

		oldPlate = this.initializePlate(oldPlate, tempTop, tempBottom, tempLeft, tempRight);
		newPlate = this.initializePlate(newPlate, 0f,0f,0f,0f);

		int iterationsMax = 0, iterations = 0;
		boolean isNoLongerChanging = false;

		iterationsMax = dimension * dimension * dimension;

		while(iterations < iterationsMax || isNoLongerChanging){
			for(int outerIndex = 1; outerIndex <= dimension; outerIndex++){

				for(int innerIndex = 1; innerIndex <= dimension; innerIndex++){
					newPlate[outerIndex][innerIndex] = (float) ((oldPlate[outerIndex + 1][innerIndex] + oldPlate[outerIndex - 1][innerIndex]
							+ oldPlate[outerIndex][innerIndex + 1] + oldPlate[outerIndex][innerIndex-1]) /4.0);
				}

			}
			//Iteration count
			iterations++;

			//Change check
			if(oldPlate[dimension/2][dimension/2] == newPlate[dimension/2][dimension/2]){
				isNoLongerChanging = true;
			}

			//Swap Plates
			Float[][] tempPlate;
			tempPlate = oldPlate;
			oldPlate = newPlate;
			newPlate = tempPlate;

		}

		String result = this.toString(newPlate);

		return result;

	}

	private String toString(Float[][] plate) {
		String result = "";
		int dimension = plate[0].length;

		for(int outerIndex = 1; outerIndex <= dimension; outerIndex++){

			for(int innerIndex = 1; innerIndex <= dimension; innerIndex++){
				result += plate[outerIndex][innerIndex] + " ";
			}
			result += "\n";

		}

		return result;
	}

	private Float[][] initializePlate(Float[][] plate, Float top,
			Float bottom, Float left, Float right){
		int dimension = plate[0].length;
		int halfDimension = dimension/2;
		plate[halfDimension][0] = left;
		plate[0][halfDimension] = top;
		plate[dimension][halfDimension] = bottom;
		plate[halfDimension][dimension] = right;

		return plate;
	}
}
