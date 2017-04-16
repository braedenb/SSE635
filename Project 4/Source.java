import java.util.ArrayList;


public class Source {

	static int numOfMeans=4; //number of means
	static ArrayList<Cluster> clusters =  new ArrayList<Cluster>(numOfMeans);//ArrayList that will hold all clusters
	static ArrayList<Point> means =  new ArrayList<Point>(numOfMeans);//ArrayList that will hold all means

	public static void main(String[] args) 
	{
		ArrayList<Point> input = new ArrayList<Point>();
		ArrayList<Point> prevMean = new ArrayList<Point>();
		input.add(new Point(0,.3,.4,.7));
		input.add(new Point(1,.3,.1,.7));
		input.add(new Point(0,1,.2,.9));
		input.add(new Point(.2,.5,.3,.8));
		input.add(new Point(.1,.5,.1,.0));
		input.add(new Point(.3,.7,.7,.4));
		input.add(new Point(.9,.6,.9,.9));
		input.add(new Point(.3,.0,.4,.2));
		initialize();//initialize the arrayLists
		do
		{
			prevMean =  means;
			for(int i=0; i<input.size();i++)
				assignCluster(input.get(i));
			calcMeans();//calculate means which updates the means ArrayList
			
		}
		while(!isEqual(prevMean, means));//loop until the means are not changing anymore
		print();
	}
	public static void initialize()
	{
		for(int i=0; i<numOfMeans; i++)
		{
			clusters.add(new Cluster());//Initializing the cluster
			means.add(clusters.get(i).getMean());//Assigning random values calculated by the cluster constructor to 
												//the means arrayList
		}
	}
	public static double assignCluster(Point point) //Method that assigns a point to the closest cluster
	{										
				
		double min = 1000;//double variable that will be used to compute the shortest distance
		int index, currIndexCluster = find(point) ;//the currIndexCluster will be used to remove the point  
		//from its current cluster before we assign the point to its new cluster. The index variable will used to 
		//store the index of the mean with the shortest distance from the passed point. 
		ArrayList<Double> distance = new ArrayList<Double>();//ArrayList that will the distances between the 
														//passed point and all means
		for(int i=0; i<numOfMeans; i++)	//Getting all the distances
		{
			distance.add(point.getDistance(means.get(i)));
			min = Math.min(distance.get(i), min);
		}
		if(currIndexCluster >= 0 && currIndexCluster < clusters.size())//checking if the index is within bounds
			clusters.get(currIndexCluster).getPoints().remove(point);//removing the point from its current cluster
																	// before adding it to its new cluster
		index = distance.indexOf(min);	//Index of the mean with the shortest distance 
										//which corresponds to its cluster index
		if(clusters.get(index).getPoints().indexOf(point) == -1)//if the point is not already in the cluster
			clusters.get(index).addPoints(point);//adding the point to its new cluster.
		
		return min;
			
	}
	public static void calcMeans()
	{
		for(int i=0; i<numOfMeans; i++)
			means.set(i, clusters.get(i).getMean()); 
	}
	public static void print()
	{
		for(int i=0; i<numOfMeans; i++)
			System.out.println( i+1 + ". " + clusters.get(i));
	}
	public static int  find(Point point)//Find the index of a point in a cluster
	{
		int index = -1;
		for(int i=0; i< numOfMeans; i++)
		{
			index = clusters.get(i).getPoints().indexOf(point);
			if(index >= 0)
				return index;
		}
		return index;
	}
	public static boolean isEqual(ArrayList<Point> a, ArrayList<Point> b)
	{
		if(a.size() != b.size())
			return false;
		for(int i=0; i<a.size(); i++)
			if(!(a.get(i).equals(b.get(i))))
				return false;
		return true;
		
	}
	public static void printArrayListOfPoints(ArrayList<Point> m)
	{
		for(int i=0; i<m.size();i++)
			System.out.println(m.get(i));
	}
	
	
}
