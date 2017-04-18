public class InputMap
{
	public static double convertPrice(double price)
	{
		// $40,000 : 0
		// $90,000 : 1
		return (price-40000)/50000;
	}
	
	public static double convertCrime(double crime)
	{
		// 3,000 : 0
		// 5,500 : 1
		return (crime-3000)/2500;
	}
	
	public static double convertPopulation(double population)
	{
		// 800 people per square mile : 0
		// 2,500 people per square mile : 1
		return (population-800)/1700;
	}
	
	public static double[] convertAll(double price, double schools, double crime, double population)
	{
		double[] inputs = new double[4];
		inputs[3] = convertPrice(price);
		inputs[2] = schools;
		inputs[1] = convertCrime(crime);
		inputs[0] = convertPopulation(population);
		return inputs;
	}
}
