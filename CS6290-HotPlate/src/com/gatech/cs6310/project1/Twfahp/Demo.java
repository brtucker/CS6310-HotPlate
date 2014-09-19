package com.gatech.cs6310.project1.Twfahp;
import com.gatech.cs6310.project1.common.SimulationResult;

public class Demo {

	private final static String usageMg = "java <packageName>.Demo -d # -l # -r # -t # -b # "
			+ "\npackageName is one of the four alternatives given above: Tpdahp, Tpfahp, Twfahp, Tpdohp. "
			+ "\nThe -d flag indicates that the next argument is the dimension of the square lattice (number "
			+ "\nof rows and columns, not counting the edge values). It is a positive integer value greater "
			+ "\nthan zero. The -l, -r, -t, and -b options respectively denote the edge temperatures for the "
			+ "\nleft, right, top, and bottom edges. Their values are any integer between zero and one hundred, "
			+ "\ninclusive. The Demo class should itself contain only enough code (e.g. main method) to start up "
			+ "\nthe program and process the command line arguments"; 
	public static void main(String[] args) {
		
		if (args.length == 0)
		{
			printUsage();
		}
		else 
		{
			int dimension =0;
			double leftTemp =0, rightTemp = 0, topTemp = 0, bottomTemp = 0;
			for (int i = 0; i< args.length; i++)
			{
				//these should all test to see if i+1 goes off the end of the array
				//bigger fish to fry at this moment
				if (args[i].equals("-d"))
				{
					dimension = Integer.parseInt(args[i+1]);
				}
				else if (args[i].equals("-l"))
				{
					leftTemp = Double.parseDouble(args[i+1]);
				}	
				else if (args[i].equals("-b"))
				{
					bottomTemp= Double.parseDouble(args[i+1]);						
				}	
				else if (args[i].equals("-r"))
				{
					rightTemp= Double.parseDouble(args[i+1]);						
				}	
				else if (args[i].equals("-t"))
				{
					topTemp= Double.parseDouble(args[i+1]);						
				}	
			}
			
			Simulation simulation = new Simulation();
			SimulationResult sr = simulation.simulate(dimension, leftTemp, topTemp, rightTemp, bottomTemp);
			System.out.println(simulation.toString());
			//System.out.println("plate values");
			//System.out.println("This took " + sr.duration + "seconds");
			//System.out.print(sr.getPlate(sr.iterations -1 ).toTableFormattedString());
		}
	}
	private static void printUsage()
	{
		System.out.print(usageMg);
	}

}
