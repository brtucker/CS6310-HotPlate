package com.gatech.cs6310.project1.models;

import java.util.ArrayList;
import java.util.List;

public class Plate {
	public int dimension;
	public Cell[][] plate;
	
	
	public Plate(int dimension) {
		// TODO Auto-generated constructor stub
		
	}

	public Cell getCell(int x, int y){
		return null;
	}
	
	public List<Cell> getCellByRow(int x){
		List<Cell> row = new ArrayList<Cell>();
		
		for(int index = 0; index < plate[x].length; index++){
			row.add(plate[x][index]);
		}
		
		return row;
	}

	public String toTableFormattedString(){
		return null;
	}
}
