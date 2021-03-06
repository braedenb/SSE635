
public class Plant 
{
	double temp=0, precipitation=0, 
			fitness=0,
			tempDifference = 15, precipDifference = 50;
	Plant(double tempParameter, double precipitationParameter)
	{
		temp = tempParameter;
		precipitation = precipitationParameter;
		calcFitness();
		calcMutation();
	}
	void mutate( double minTemp, double maxTemp, double minPrecip, double maxPrecip)
	{
		calcFitness();
		if(willMutate())
		{
			double tempMutation = 2*Math.random();
			if(Math.random() %2 < .5)
				temp += tempMutation;
			else
				temp -= tempMutation;
			if(temp < minTemp)
				temp += 2*tempMutation;
			if(temp > maxTemp)
				temp -= 2*tempMutation;
			
			
			double tempPrecipitation = 4*Math.random();
			if(Math.random()%2 > .5)
				precipitation += tempPrecipitation;
			else
				precipitation -= tempPrecipitation;
			if(precipitation < minPrecip)
				precipitation += 2*tempPrecipitation;
			if(precipitation > maxPrecip)
				precipitation -= 2*tempPrecipitation;
		}
		calcFitness();
		calcMutation();
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
	void calcMutation()
	{
		calcFitness();
	}
	void calcFitness()
	{
		fitness = 1 - (((Math.abs(temp - tempDifference)/25) + Math.abs((precipitation - precipDifference)/50))/2);
	}
	boolean willMutate()
	{
		return fitness < .9;
	}
	public String toString()
	{
		return temp+"\t"+precipitation+"\t"+fitness+"\n";
	}
}
