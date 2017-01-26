
public class Plant 
{
	double temp=0, precipitation=0, 
			fitness=0, mutation=0,
			tempDifference = 15, precipDifference = 50;
	Plant(double tempParameter, double precipitationParameter)
	{
		temp = tempParameter;
		precipitation = precipitationParameter;
		calcFitness();
	}
	double getTemp()
	{
		return temp;
	}
	
	double getPrecipitation()
	{
		return precipitation;
	}
	double getFitness()
	{
		return fitness;
	}
	double getMutation()
	{
		return mutation;
	}
	void calcFitness()
	{
		fitness = 1 - (((Math.abs(temp - tempDifference)/25) + Math.abs((precipitation - precipDifference)/50))/2);
	}
	boolean willMutate()
	{
		return fitness < .95;
	}
	public String toString()
	{
		return temp+"\t"+precipitation+"\t"+fitness+"\t"+mutation+"\n";
	}
}
