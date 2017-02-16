import static org.junit.Assert.*;

import org.junit.Test;


public class Tester {

	Plant temp = new Plant(10,50);

	@Test
	public void ConstructorTest() 
	{
		Plant temp = new Plant(10,50);
		
	}

	//@SuppressWarnings("deprecation")
	@Test
	public void calFitnessTess()
	{
		Plant temp = new Plant(10,50);
		temp.calcFitness();
		
		assertEquals(1.0,temp.getFitness(), 2.0);
		//System.out.println(temp);
	}
	@Test
	public void willMutate()
	{
		Plant temp = new Plant(14,51);
		//temp.calcFitness();
		System.out.println(temp);
		assertEquals(temp.willMutate(),false);
	}

}
