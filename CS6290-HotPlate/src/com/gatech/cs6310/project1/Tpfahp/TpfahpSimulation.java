package com.gatech.cs6310.project1.Tpfahp;

public class TpfahpSimulation {

	public String simulate(int dimension, float tempLeft,
			float tempTop, float tempRight,
			float tempBottom){

		float[][] oldPlate = new float[dimension + 2][dimension + 2];
		float[][] newPlate = new float[dimension + 2][dimension + 2];

		oldPlate = this.initializePlate(oldPlate, tempTop, tempBottom, tempLeft, tempRight);
		newPlate = this.initializePlate(newPlate, 0,0,0,0);

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
			float[][] tempPlate;
			tempPlate = oldPlate;
			oldPlate = newPlate;
			newPlate = tempPlate;

		}

		String result = this.toString(newPlate);

		return result;

	}

	private String toString(float[][] plate) {
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

	private float[][] initializePlate(float[][] plate, float top,
			float bottom, float left, float right){
		int dimension = plate[0].length;
		int halfDimension = dimension/2;
		plate[halfDimension][0] = left;
		plate[0][halfDimension] = top;
		plate[dimension][halfDimension] = bottom;
		plate[halfDimension][dimension] = right;

		return plate;
	}

}
