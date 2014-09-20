package common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Plate {
	public int dimension;
	//chosen because of this post
	//http://stackoverflow.com/questions/916081/convert-float-to-double-without-losing-precision
	private BigDecimal[][] plate;
	
	
	public Plate(int dimension) {
		this.dimension = dimension;
		plate = new BigDecimal[dimension][dimension];
	}

	public BigDecimal getCell(int x, int y){
		return plate[x][y];
	}
	public void setCell(int x, int y, double temp){
		plate[x][y] = BigDecimal.valueOf(temp);
	}
	public void setCell(int x, int y, float temp){
		plate[x][y] = BigDecimal.valueOf(temp);
	}
	public void setCell(int x, int y, Float temp){
		plate[x][y] = BigDecimal.valueOf(temp);
	}
	
	public BigDecimal[] getCellByRow(int x){
		return plate[x];
	}

	public String toTableFormattedString(){
		String result = "";
		int dimension = plate.length;
		
		for(int outerIndex = 0; outerIndex < dimension; outerIndex++){
			
			for(int innerIndex = 0; innerIndex < dimension; innerIndex++){
				result += String.format( "%.2f", plate[outerIndex][innerIndex]) + "\t";
			}
			result += "\n";
		}
		return result;
	}
}
