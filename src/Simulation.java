import java.util.ArrayList;
import java.util.Scanner;

public class Simulation
{
	static double idealTemp;
	static double idealPrec;
	static double minTemp;
	static double maxTemp;
	static double minPrec;
	static double maxPrec;
	static ArrayList<Plant> population;
	
	public static void main(String[] args)
	{	
		// Set the ideal conditions (temperature between -10C and 40C, precipitation between 0% and 100%).
		setConditions();
		
		// Set the initial acceptable range for both temperature and precipitation.
		setInitialRange();
		
		// Create a new population of Plants.
		population = new ArrayList<Plant>();
		
		// Add 20 Plants to population.
		populate();
		
		// Select all plants that lie within the ideal ranges for both temperature and precipitation.
		population = selectBestFit();
		
		System.out.println(population.size());
		
		// Create children by pairing the remaining Plants from population.
		ArrayList<Plant> children = crossPollinate();
		
		System.out.println(children.size());
		
		// Carry over as many parents as possible from population.
		carryOver(children);
		
		// population should now become children.
		population = children;
		
		System.out.println(population.size());
		
		// Add enough Plants to have 20 total Plants in population.
		populate();
		
		System.out.println(population.size() + "\n");
		
		// Mutate all the Plants in population.
		for(int i=0; i<population.size(); i++)
		{
			System.out.println("Before mutation:");
			System.out.print(population.get(i).toString());
			System.out.println("After mutation:");
			population.get(i).mutate(minTemp, maxTemp, minPrec, maxPrec);
			System.out.println(population.get(i).toString());
		}
	}
	
	// Accept user input to set the ideal temperature and precipitation.
	public static void setConditions()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter ideal temperature: ");
		idealTemp = in.nextDouble();
		System.out.println("Enter ideal precipitation: ");
		idealPrec = in.nextDouble();
	}
	
	// Set the initial acceptable range to be the 25th to 75th percentile.
	public static void setInitialRange()
	{
		if(idealTemp <= 15.0)
		{
			minTemp = -10.0 + (idealTemp + 10.0) / 2.0;
			maxTemp = idealTemp + (idealTemp + 10.0) / 2.0;
		}
		else
		{
			minTemp = idealTemp - (40.0 - idealTemp) / 2.0;
			maxTemp = 40.0 - (40.0 - idealTemp) / 2.0;
		}
		
		if(idealPrec <= 50.0)
		{
			minPrec = 0.0 + (idealPrec + 0.0) / 2.0;
			maxPrec = idealPrec + (idealPrec + 0.0) / 2.0;
		}
		else
		{
			minPrec = idealPrec - (100.0 - idealPrec) / 2.0;
			maxPrec = 100.0 - (100.0 - idealPrec) / 2.0;
		}
	}

	// Add enough plants to population so the population size is 20.
	public static void populate()
	{
		while(population.size() < 20)
		{
			double temp = -10 + 50 * Math.random();
			double prec = 0 + 100 * Math.random();
			Plant plant = new Plant(temp, prec);
			population.add(plant);
		}
	}
	
	// Return an arrayList of all the plants that lie within the ideal ranges for both temperature and precipitation.
	public static ArrayList<Plant> selectBestFit()
	{
		ArrayList<Plant> bestFit = new ArrayList<Plant>();
		
		for(int i=0; i<population.size(); i++)
		{
			if(population.get(i).getTemp() >= minTemp &&
				population.get(i).getTemp() <= maxTemp &&
				population.get(i).getPrecipitation() >= minPrec &&
				population.get(i).getPrecipitation() <= maxPrec)
			{
				bestFit.add(population.get(i));
			}
		}
		
		return bestFit;
	}
	
	// Create children by pairing the remaining Plants from population.
	public static ArrayList<Plant> crossPollinate()
	{
		ArrayList<Plant> children = new ArrayList<Plant>();
		
		for(int i=0; i<population.size(); i=i+2)
		{
			if(i != population.size() - 1)
			{
				Plant child1 = new Plant(population.get(i).getTemp(), population.get(i+1).getPrecipitation());
				Plant child2 = new Plant(population.get(i+1).getTemp(), population.get(i).getPrecipitation());
				children.add(child2);
				children.add(child1);
			}			
		}
		
		return children;
	}
	
	// Carry over as many parents as possible from population.
	public static void carryOver(ArrayList<Plant> children)
	{		
		while(children.size() < 20 && population.size() > 0)
		{
			children.add(population.get(0));
			population.remove(0);
		}
	}
}