import java.util.Scanner;

public class Simulation
{
	static double idealTemp;
	static double idealPrec;
	static double minTemp;
	static double maxTemp;
	static double minPrec;
	static double maxPrec;
	
	public static void main(String[] args)
	{	
		// Set the ideal conditions (temperature between -10C and 40C, precipitation between 0% and 100%).
		setConditions();
		
		// Set the initial acceptable range for both temperature and precipitation.
		setInitialRange();
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
}