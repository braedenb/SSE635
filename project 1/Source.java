import java.util.ArrayList;


public class Source 
{

	private double idealTempMin = -10, 
					idealTempMax = 40,
					idealPrepMin = 0,
					idealPrepMax = 100;
	static ArrayList<Plant> pop =  new ArrayList<Plant>();
	public static void main(String[] args) 
	{

		double k = 35*Math.random();
		System.out.println(k);
	}
	public static void populate(int num)
	{
		for(int i = 0 ; i < num ; i++)
		{
			double temperature = -10 + 50*Math.random();
			double precipitation = 100*Math.random();
			Plant plant = new Plant(temperature, precipitation);
			pop.add(plant);
		}
	}
	ArrayList<Plant> crossPollinate(Plant parent1, Plant parent2)
	{
		ArrayList<Plant> children = new ArrayList<Plant>() ;
		Plant child1 = new Plant(parent1.getTemp(), parent2.getPrecipitation());
		Plant child2 = new Plant(parent2.getTemp(), parent1.getPrecipitation());
		children.add(child2);
		children.add(child1);
		return children;
	}

}
