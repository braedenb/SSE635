public class Neuron 
{
	double max;
	double min;	
	double[] inputs  = new double[5];
	double[] weights = new double[5];
	double output;
	double activation = 0;
	char func;	
	public Neuron(double[] inputsTemp, char function,double minT, double maxT)
	{
		inputs = inputsTemp;
		output = 0;
		func= function;
		min = minT;
		max = maxT;
		for(int i=0; i<inputs.length; i++)
		{	
			double temp = Math.random();
			if(temp > .05)
				weights[i] = temp;	
			else
				i--;
		}
	}
	protected void function()
	{
		if(func =='p')
			output = linearPos(); 
		
		else if (func =='n')
			output = linearNeg();
			
		else if(func =='s')
			output = sigmoid();	
	}
	protected void calcOutput()
	{
		for(int i=0; i<inputs.length; i++)
			activation +=inputs[i]*weights[i];
		function();
	}
	protected double getOutput()
	{
		calcOutput();
		if(output > activation)
				return output;
		else
			return 0;
	}
	protected double[] getWeight()
	{
		return weights;
	}
	protected void setWeight(double deviation)
	{
		for(int i=0; i<inputs.length; i++)
			weights[i] +=  deviation;
	}
	protected double sigmoid()
	{
		return 1/(1 + Math.pow(Math.E, -activation));
	}
	protected double linearNeg()
	{
		return  -(inputs[0]-min)/(max-min);
	}
	protected double linearPos()
	{
		return  (inputs[0]-min)/(max-min);
	}
}
