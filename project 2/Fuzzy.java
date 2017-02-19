import java.util.ArrayList;
import java.util.Scanner;

public class Fuzzy
{
	static ArrayList<Rule> rules;
	static double glucose, rate;
	static String activity;
	static double low, ideal, high, decreasing, constant, increasing, resting, present;
	
	public static void main(String[] args)
	{
		rules = new ArrayList<Rule>();
		
		// Populate rules with all 47 rule combinations.
		populateRules();
		
		// Ask for user input for current glucose level, rate of change, and activity.
		userInput();
		
		// Calculate the memberships for the various qualified parameters.
		calcLow();
		calcIdeal();
		calcHigh();
		calcDecreasing();
		calcConstant();
		calcIncreasing();
		calcResting();
		calcPresent();
	}
	
	// Populate rules with all 47 rule combinations.
	public static void populateRules()
	{
		rules.add(new Rule("low", null, null, "sugar"));
		rules.add(new Rule("ideal", null, null, "nothing"));
		rules.add(new Rule("high", null, null, "insulin"));
		rules.add(new Rule(null, "decreasing", null, "sugar"));
		rules.add(new Rule(null, "constant", null, "nothing"));
		rules.add(new Rule(null, "increasing", null, "insulin"));
		rules.add(new Rule(null, null, "resting", "nothing"));
		rules.add(new Rule(null, null, "present", "sugar"));
		rules.add(new Rule("low", "decreasing", "resting", "sugar"));
		rules.add(new Rule("low", "decreasing", "present", "sugar"));
		rules.add(new Rule("low", "constant", "resting", "sugar"));
		rules.add(new Rule("low", "constant", "present", "sugar"));
		rules.add(new Rule("low", "increasing", "resting", "nothing"));
		rules.add(new Rule("low", "increasing", "present", "sugar"));
		rules.add(new Rule("ideal", "decreasing", "resting", "sugar"));
		rules.add(new Rule("ideal", "decreasing", "present", "sugar"));
		rules.add(new Rule("ideal", "constant", "resting", "nothing"));
		rules.add(new Rule("ideal", "constant", "present", "sugar"));
		rules.add(new Rule("ideal", "increasing", "resting", "insulin"));
		rules.add(new Rule("ideal", "increasing", "present", "nothing"));
		rules.add(new Rule("high", "decreasing", "resting", "nothing"));
		rules.add(new Rule("high", "decreasing", "present", "sugar"));
		rules.add(new Rule("high", "constant", "resting", "insulin"));
		rules.add(new Rule("high", "constant", "present", "nothing"));
		rules.add(new Rule("high", "increasing", "resting", "insulin"));
		rules.add(new Rule("high", "increasing", "present", "insulin"));
		rules.add(new Rule("low", "decreasing", null, "sugar"));
		rules.add(new Rule("low", "constant", null, "sugar"));
		rules.add(new Rule("low", "increasing", null, "nothing"));
		rules.add(new Rule("ideal", "decreasing", null, "sugar"));
		rules.add(new Rule("ideal", "constant", null, "nothing"));
		rules.add(new Rule("ideal", "increasing", null, "insulin"));
		rules.add(new Rule("high", "decreasing", null, "nothing"));
		rules.add(new Rule("high", "constant", null, "insulin"));
		rules.add(new Rule("high", "increasing", null, "insulin"));
		rules.add(new Rule("low", null, "resting", "sugar"));
		rules.add(new Rule("low", null, "present", "sugar"));
		rules.add(new Rule("ideal", null, "resting", "nothing"));
		rules.add(new Rule("ideal", null, "present", "sugar"));
		rules.add(new Rule("high", null, "resting", "insulin"));
		rules.add(new Rule("high", null, "present", "nothing"));
		rules.add(new Rule(null, "decreasing", "resting", "sugar"));
		rules.add(new Rule(null, "decreasing", "present", "sugar"));
		rules.add(new Rule(null, "constant", "resting", "nothing"));
		rules.add(new Rule(null, "constant", "present", "sugar"));
		rules.add(new Rule(null, "increasing", "resting", "insulin"));
		rules.add(new Rule(null, "increasing", "present", "nothing"));
	}
	
	// Ask for user input for current glucose level, rate of change, and activity.
	public static void userInput()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input current glucose level (mg/dL): ");
		glucose = in.nextDouble();
		
		System.out.print("Input rate of change of glucose (mg/dL/min): ");
		rate = in.nextDouble();
		
		System.out.print("Is activity present (y or n)? ");
		String response = in.next();
		
		if(response.equalsIgnoreCase("y"))
			activity = "present";
		else if(response.equalsIgnoreCase("n"))
			activity = "resting";
	}
	
	// Calculate the low membership.
	public static void calcLow()
	{
		if(glucose < 50.0)
			low = 1.0;
		else
			low = (100 - 2*Math.abs(glucose-50))/100;
		
		if(low < 0.0)
			low = 0.0;
	}
	
	// Calculate the ideal membership.
	public static void calcIdeal()
	{
		ideal = (100 - 2*Math.abs(glucose-100))/100;
		
		if(ideal < 0.0)
			ideal = 0.0;
	}
	
	// Calculate the high membership.
	public static void calcHigh()
	{
		if(glucose > 150.0)
			high = 1;
		else
			high = (100 - 2*Math.abs(150-glucose))/100;
		
		if(high < 0)
			high = 0;
	}
	
	// Calculate the decreasing membership.
	public static void calcDecreasing()
	{
		if(rate < -1)
			decreasing = 1.0;
		else if(rate >= 0)
			decreasing = 0;
		else
			decreasing = Math.abs(rate);
	}
	
	// Calculate the constant membership.
	public static void calcConstant()
	{
		constant = 1 - Math.abs(rate);
		
		if(constant < 0.0)
			constant = 0.0;
	}
	
	// Calculate the increasing membership.
	public static void calcIncreasing()
	{
		if(rate > 1)
			increasing = 1;
		else
			increasing = rate;
		
		if(increasing < 0)
			increasing = 0;
	}
	
	// Calculate the resting membership.
	public static void calcResting()
	{
		if(activity.equals("resting"))
			resting = 1;
		else
			resting = 0;
	}
	
	// Calculate the present membership.
	public static void calcPresent()
	{
		if(activity.equals("present"))
			present = 1;
		else
			present = 0;
	}
}