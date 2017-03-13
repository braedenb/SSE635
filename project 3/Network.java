import java.util.Scanner;
public class Network 
{
	static  Neuron[] inputLayer = new  Neuron[5];
	static  Neuron[] hiddenLayer = new  Neuron[3];
	static  Neuron[] outputLayer = new  Neuron[1]; 	
	static  double[] entries = new  double[5];
 	public static void main(String[] args) 
 	{
 		double result=0, output = .6, deviation = 0;
		inputSet();
 		System.out.println("Grade \tOutput");
 		do 
 		{
 			InputLayer(deviation);
 			HiddenLayer(deviation);
 			result = OutputLayer(deviation);
 			print(result);
 			if(result<output)
 				deviation+=.05;
 			else
 				deviation-=.05;
 		}
 		while(result<output);
	}
 	public static void inputSet()
 	{
 		Scanner in = new Scanner(System.in);
 		System.out.print("Enter earnings per year: ");
 		double earning;
 		earning = in.nextDouble();
 		System.out.print("Enter funding: ");
 		double funding = in.nextDouble();
 		System.out.print("Enter liquidity: ");
 		double liquidity = in.nextDouble();
 		System.out.print("Enter cost: ");
 		double cost = in.nextDouble();
 		System.out.print("Enter credit score: ");
 		double creditScore = in.nextDouble();
 		entries[0] = (earning);
 		entries[1] = (funding);
 		entries[2] = (liquidity);
 		entries[3] = (cost);
 		entries[4] = (creditScore);
 		in.close();	
 	}
 	public static void InputLayer(double deviation)
 	{
 		double [] min={30000,40000,45000,40000,250};
 		double [] max={1000000, 9000000,90000,1000000,850};
 		char[] functions = {'p','n','p','n','p'};
 		for(int i=0; i<entries.length; i++)
 		{
 	 		 double[] temp = new  double[1];
 	 		temp[0] = entries[i];
 	 		inputLayer[i] = new Neuron(temp, functions[i],min[i], max[i]);
 	 		
 		}
 		for(int i=0; i>inputLayer.length;i++)
 		{
 			inputLayer[i].setWeight(deviation);
 			inputLayer[i].calcOutput();
 		}	
 	}
 	public static void HiddenLayer(double deviation)
 	{
 		int size = inputLayer.length;
 		for(int i=0; i<3 ;i++)
 		{
 	 		 double[] temp = new  double[2];
 	 		temp[0] = (inputLayer[i].getOutput());
 	 		temp[1] = (inputLayer[Math.abs(i-size+1)].getOutput());
 	 		hiddenLayer[i] = new Neuron(temp,'s',0,0);
 	 		hiddenLayer[i].setWeight(deviation);
 		}
 	}
 	public static double OutputLayer(double deviation)
 	{
	 	 double[] temp = new  double[3];
	 	for(int i=0; i<hiddenLayer.length;i++)
	 		temp[i] = (hiddenLayer[i].getOutput());
	 	outputLayer[0] = new Neuron(temp,'s',0,0);
	 	outputLayer[0].setWeight(deviation);
	 	return outputLayer[0].getOutput();

 	}
 	public static void print(double result)
 	{
 		String out;
 		if(result <= 1 && result >= 0)
 			{
 			if(result > .857)
 				out = "AAA";
 			else if(result > .714)
 				out = "AA";
 			else if(result > .571)
 				out = "A";
 			else if(result > .428)
 				out = "BBB";
 			else if(result > .285)
 				out = "B";
 			else if(result > .142)
 				out = "CCC";
 			else
 				out = "CC";
 			}
 		else
 			out = "Invalid output";
 		System.out.println(out + "\t" + result);
 	}
 	
}
