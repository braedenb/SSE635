public class Rule
{
	String level, change, activity, output;
	double result;
	
	Rule(String glucose, String rate, String act, String action)
	{
		level = glucose;
		change = rate;
		activity = act;
		output = action;
	}
	
	// The parameters are the membership values for each level, change, and activity.
	void calcResult(double low, double ideal, double high, double decreasing, double constant, double increasing, double resting, double present)
	{
		double a = 0.0, b = 0.0, c = 0.0;
		
		if(level.equals("low"))
			a = low;
		else if(level.equals("ideal"))
			a = ideal;
		else if(level.equals("high"))
			a = high;
		else if(level == null)
			a = 1.0;
		
		if(change.equals("decreasing"))
			b = decreasing;
		else if(change.equals("constant"))
			b = constant;
		else if(change.equals("increasing"))
			b = increasing;
		else if(change == null)
			b = 1.0;
		
		if(activity.equals("resting"))
			c = resting;
		else if(activity.equals("present"))
			c = present;
		else if(activity == null)
			c = 1.0;
		
		result = findMin(a, b, c);
	}
	
	// Find the minimum of a, b, and c.
	double findMin(double a, double b, double c)
	{
		double min = a;
		
		if(b < min)
			min = b;
		
		if(c < min)
			min = c;
		
		return min;
	}
	
	String getOutput()
	{
		return output;
	}
	
	double getResult()
	{
		return result;
	}
}