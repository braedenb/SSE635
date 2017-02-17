import java.util.ArrayList;
import java.util.Scanner;

public class Fuzzy
{
	static ArrayList<Rule> rules;
	static double glucose, rate;
	static String activity;
	
	public static void main(String[] args)
	{
		rules = new ArrayList<Rule>();
		
		// Populate rules with all 47 rule combinations.
		populateRules();
		
		// Ask for user input for current glucose level, rate of change, and activity.
		userInput();
	}
	
	// Populate rules with all 47 rule combinations.
	public static void populateRules()
	{
		rules.add(new Rule("low", null, null, "sugar"));
		rules.add(new Rule("ideal", null, null, "nothing"));
		rules.add(new Rule("high", null, null, "insulin"));
		rules.add(new Rule(null, "decreasing", null, "sugar"));
		rules.add(new Rule(null, "constant", null, "nothing"));
		rules.add(new Rule(null, null, "resting", "nothing"));
		rules.add(new Rule(null, null, "present", "sugar"));
		rules.add(new Rule("low", "decreasing", "resting", "sugar"));
		rules.add(new Rule("low", "decreasing", "present", "sugar"));
		
//		11.	If glucose is low and constant and activity is resting, then add sugar.
//		12.	If glucose is low and constant and activity is present, then add sugar.
//		13.	If glucose is low and increasing and activity is resting, then add sugar.
//		14.	If glucose is low and increasing and activity is present, then add sugar.
//		15.	If glucose is ideal and decreasing and activity is resting, then add sugar.
//		16.	If glucose is ideal and decreasing and activity is present, then add sugar.
//		17.	If glucose is ideal and constant and activity is resting, then do nothing.
//		18.	If glucose is ideal and constant and activity is present, then add sugar.
//		19.	If glucose is ideal and increasing and activity is resting, then add insulin.
//		20.	If glucose is ideal and increasing and activity is present, then do nothing.
//		21.	If glucose is high and decreasing and activity is resting, then do nothing.
//		22.	If glucose is high and decreasing and activity is present, then add sugar.
//		23.	If glucose is high and constant and activity is resting, then add insulin.
//		24.	If glucose is high and constant and activity is present, then do nothing.
//		25.	If glucose is high and increasing and activity is resting, then add insulin.
//		26.	If glucose is high and increasing and activity is present, then add insulin.
//		27.	If glucose is low and decreasing, then add sugar.
//		28.	If glucose is low and constant, then add sugar.
//		29.	If glucose is low and increasing, then do nothing.
//		30.	If glucose is ideal and decreasing, then add sugar.
//		31.	If glucose is ideal and constant, then do nothing.
//		32.	If glucose is ideal and increasing, then add insulin.
//		33.	If glucose is high and decreasing, then do nothing.
//		34.	If glucose is high and constant, then add insulin.
//		35.	If glucose is high and increasing, then add insulin. 
//		36.	If glucose is low and activity is present, then add sugar.
//		37.	If glucose is low and activity is resting, then add sugar.
//		38.	If glucose is ideal and activity is present, then add sugar.
//		39.	If glucose is ideal and activity is resting, then do nothing.
//		40.	If glucose is high and activity is present, then do nothing.
//		41.	If glucose is high and activity is resting, then add insulin.
//		42.	If glucose is decreasing and activity is present, then add sugar.
//		43.	If glucose is decreasing and activity is resting, then add sugar.
//		44.	If glucose is constant and activity is present, then add sugar.
//		45.	If glucose is constant and activity is resting, then do nothing.
//		46.	If glucose is increasing and activity is present, then do nothing. 
//		47.	If glucose is increasing and activity is resting, then add insulin.
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
		String response = in.nextLine();
		
		if(response.equalsIgnoreCase("y"))
			activity = "present";
		else if(response.equalsIgnoreCase("n"))
			activity = "resting";
	}
}