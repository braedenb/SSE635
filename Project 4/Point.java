public class Point 
{
	private double xVal, yVal, zVal, wVal;
	Point(double w, double x, double y, double z)
	{
		wVal = w;
		xVal = x;
		yVal = y;
		zVal = z;
	}
	double getW()
	{
		return wVal;
	}
	double getX()
	{
		return xVal;
	}
	double getY()
	{
		return yVal;
	}
	double getZ()
	{
		return zVal;
	}
	
	double getDistance(Point kPoint)
	{
		return Math.sqrt(Math.pow(kPoint.getW() -wVal, 2) + Math.pow(kPoint.getX() -xVal, 2) 
				+Math.pow(kPoint.getY() -yVal, 2)+Math.pow(kPoint.getZ() -zVal, 2));
	}
	boolean equals(Point p)
	{
		return (getW() == p.getW()) && (getX() == p.getX()) && (getY() == p.getY()) && (getZ() == p.getZ());
	}
	public String toString()
	{
		return "W = " + getW() + "\tX = " + getX() + "\tY = " + getY() + "\tZ = " + getZ();
	}
}
