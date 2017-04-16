import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;


public class ClusterTest {

	@Test 
	public void TestIsEqual()
	{
		Point input = new Point(1,.3,.4,.7);
		Point input1 = new Point(1,.3,.4,.7);
		assertTrue(input.equals(input1));
	}
	@Test 
	public void TestSourceEqual()
	{
		ArrayList<Point> input = new ArrayList<Point>();
		ArrayList<Point> input1 = new ArrayList<Point>();
		input.add(new Point(1,.3,.4,.7));
		input.add(new Point(0,.5,.4,.7));
		input1.add(new Point(1,.3,.4,.7));
		input1.add(new Point(0,.5,.4,.7));
		assertTrue(Source.isEqual(input, input1));
	}
	@Test 
	public void TestCalcMean()
	{
		Source.initialize();
		ArrayList<Point> input = new ArrayList<Point>();
		ArrayList<Point> input1 = new ArrayList<Point>();
		input.add(new Point(1,.3,.4,.7));
		input.add(new Point(0,.5,.4,.7));
		input1.add(new Point(1,.3,.4,.7));
		input1.add(new Point(0,.5,.4,.7));
	}

}
