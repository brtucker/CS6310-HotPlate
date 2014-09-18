package com.gatech.cs6310.project1.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Plate {
	public int dimension;
	HashMap<String, Cell> cellMap = new HashMap<String,Cell>();
	
	public Plate(int dimension) {
		// TODO Auto-generated constructor stub
		
	}

	public Plate() {
		// TODO Auto-generated constructor stub
	}

	public void initialize(double top, double bottom, 
						double left, double right){
		int halfDimension = this.dimension/2;	
		
		for(int outerIndex = 1; outerIndex <= dimension; outerIndex++){
			for(int innerIndex = 1; innerIndex <= dimension; innerIndex++){
				if(outerIndex == halfDimension && innerIndex ==1){
					this.cellMap.put(outerIndex + " " + innerIndex, new Cell(outerIndex, innerIndex, left));
				}
				else if(outerIndex == 1 && innerIndex == halfDimension){
					this.cellMap.put(outerIndex + " " + innerIndex, new Cell(outerIndex, innerIndex, top));
				}
				else if(outerIndex == this.dimension && innerIndex ==halfDimension){
					this.cellMap.put(outerIndex + " " + innerIndex, new Cell(outerIndex, innerIndex, bottom));
				}
				else if(outerIndex == halfDimension && innerIndex == this.dimension){
					this.cellMap.put(outerIndex + " " + innerIndex, new Cell(outerIndex, innerIndex, right));
				}
				else
					this.cellMap.put(outerIndex + " " + innerIndex, new Cell(outerIndex, innerIndex, 0.0));
			}
		}
		
	}
	
	public Cell getCell(int x, int y){
		return this.cellMap.get(x + " " + y);
	}
	
	public void setCell(int x, int y, double temp){
		Cell updateCell = new Cell();
		updateCell = this.cellMap.get(x + " "+ y);
		this.cellMap.remove(x + " " + y);
		
		updateCell.temp = temp;
		this.cellMap.put(x+" "+y, updateCell);
	}
	
	public List<Cell> getCellByRow(int x){
		List<Cell> row = new ArrayList<Cell>();
		
		Iterator<String> keySetIterator = cellMap.keySet().iterator();

		while(keySetIterator.hasNext()){
		  String key = keySetIterator.next();
		  
		  if(key.contains(String.valueOf(x))){
			  row.add(cellMap.get(key));
		  }
	
		}
		
		return row;
	}

	public String toTableFormattedString(){
		Iterator<String> keySetIterator = cellMap.keySet().iterator();
		String result = "";
		int index = 0;
		
		while(keySetIterator.hasNext()){
			String key = keySetIterator.next();
			index++;
			
			result += cellMap.get(key).temp + " ";
			
			//System.out.println("key: " + key + " value: " + cellMap.get(key));
			if(index%this.dimension == 0){
				result += "\n";
			}
			
		}
		return result;
	}


	public double getTemp(int outerIndex, int innerIndex) {
		return this.cellMap.get(outerIndex + " " + innerIndex).temp;
	}
}
