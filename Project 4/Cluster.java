import java.util.ArrayList;
import java.util.Random;


public class Cluster 
{
	protected ArrayList<Point> points;
	protected Point mean;
	private Random generator = new Random();

	Cluster()
	{
		points = new ArrayList<Point>();
		mean =new Point(generator.nextDouble() ,generator.nextDouble()  ,generator.nextDouble()  ,generator.nextDouble());//new Point(0 ,0  ,0  ,0);
	}
	protected void addPoints(Point newPoint)
	{
		points.add(newPoint);
	}
	private void calcCentroid()
	{
		double sumX=0, sumY = 0, sumW = 0, sumZ = 0;
		int size = points.size();
		if(size > 0) //Ensures that we only return a mean of points
		{
			for(int i=0; i< size; i++)
			{	
			sumW += points.get(i).getW();
			sumX += points.get(i).getX();
			sumY += points.get(i).getY();
			sumZ += points.get(i).getZ();
			}
			mean =  new Point(sumW/size, sumX/size, sumY/size, sumZ/size);
		}
		else//if the cluster is empty, generate a new mean
			mean = new Point(generator.nextDouble() ,generator.nextDouble()  ,generator.nextDouble()  ,generator.nextDouble());

	}
	protected Point getMean()
	{
		calcCentroid();
		return mean;
	}
	protected ArrayList<Point> getPoints()
	{
		return points;
	}
	public String toString()
	{
		String val = "Cluster \nMean :  " + mean.toString()+ "\n";
		for(int i=0; i<points.size(); i++)
			val += "\t" + (i+1) +". " +points.get(i).toString() + "\tDistance from mean = " + points.get(i).getDistance(mean) + "\n";
		return val;
	}
	
	

}
