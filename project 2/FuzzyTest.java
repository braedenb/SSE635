import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FuzzyTest
{
	@Test
	public void testPopulateRules()
	{
		Fuzzy.rules = new ArrayList<Rule>();
		Fuzzy.populateRules();
		
		assertTrue(Fuzzy.rules.size() == 47);
	}
	
	@Test
	public void testUserInput()
	{
		Fuzzy.userInput();
		
		assertTrue(Fuzzy.glucose == 75.0);
		assertTrue(Fuzzy.rate == -0.5);
		assertTrue(Fuzzy.activity == "present");
	}
	
	@Test
	public void testCalcLow()
	{
		Fuzzy.glucose = 0.0;
		Fuzzy.calcLow();
		assertTrue(Fuzzy.low == 1.0);
		
		Fuzzy.glucose = 50.0;
		Fuzzy.calcLow();
		assertTrue(Fuzzy.low == 1.0);
		
		Fuzzy.glucose = 75.0;
		Fuzzy.calcLow();
		assertTrue(Fuzzy.low == 0.5);
		
		Fuzzy.glucose = 150.0;
		Fuzzy.calcLow();
		assertTrue(Fuzzy.low == 0.0);
	}
	
	@Test
	public void testCalcIdeal()
	{
		Fuzzy.glucose = 0.0;
		Fuzzy.calcIdeal();
		assertTrue(Fuzzy.ideal == 0.0);
		
		Fuzzy.glucose = 100.0;
		Fuzzy.calcIdeal();
		assertTrue(Fuzzy.ideal == 1.0);
		
		Fuzzy.glucose = 125.0;
		Fuzzy.calcIdeal();
		assertTrue(Fuzzy.ideal == 0.5);
		
		Fuzzy.glucose = 200.0;
		Fuzzy.calcIdeal();
		assertTrue(Fuzzy.ideal == 0.0);
	}
	
	@Test
	public void testCalcHigh()
	{
		Fuzzy.glucose = 50.0;
		Fuzzy.calcHigh();
		assertTrue(Fuzzy.high == 0.0);
		
		Fuzzy.glucose = 125.0;
		Fuzzy.calcHigh();
		assertTrue(Fuzzy.high == 0.5);
		
		Fuzzy.glucose = 150.0;
		Fuzzy.calcHigh();
		assertTrue(Fuzzy.high == 1.0);
		
		Fuzzy.glucose = 250.0;
		Fuzzy.calcHigh();
		assertTrue(Fuzzy.high == 1.0);
	}
	
	@Test
	public void testCalcDecreasing()
	{
		Fuzzy.rate = -2.0;
		Fuzzy.calcDecreasing();
		assertTrue(Fuzzy.decreasing == 1.0);
		
		Fuzzy.rate = -1;
		Fuzzy.calcDecreasing();
		assertTrue(Fuzzy.decreasing == 1.0);
		
		Fuzzy.rate = -.5;
		Fuzzy.calcDecreasing();
		assertTrue(Fuzzy.decreasing == 0.5);
		
		Fuzzy.rate = 1;
		Fuzzy.calcDecreasing();
		assertTrue(Fuzzy.decreasing == 0.0);
	}
	
	@Test
	public void testCalcConstant()
	{
		Fuzzy.rate = -1.5;
		Fuzzy.calcConstant();
		assertTrue(Fuzzy.constant == 0.0);
		
		Fuzzy.rate = 0;
		Fuzzy.calcConstant();
		assertTrue(Fuzzy.constant == 1.0);
		
		Fuzzy.rate = .5;
		Fuzzy.calcConstant();
		assertTrue(Fuzzy.constant == 0.5);
		
		Fuzzy.rate = 1.5;
		Fuzzy.calcConstant();
		assertTrue(Fuzzy.constant == 0.0);
	}
	
	@Test
	public void testCalcIncreasing()
	{
		Fuzzy.rate = -1;
		Fuzzy.calcIncreasing();
		assertTrue(Fuzzy.increasing == 0.0);
		
		Fuzzy.rate = .5;
		Fuzzy.calcIncreasing();
		assertTrue(Fuzzy.increasing == .5);
		
		Fuzzy.rate = 1;
		Fuzzy.calcIncreasing();
		assertTrue(Fuzzy.increasing == 1);
		
		Fuzzy.rate = 2;
		Fuzzy.calcIncreasing();
		assertTrue(Fuzzy.increasing == 1);
	}
	
	@Test
	public void testCalcResting()
	{
		Fuzzy.activity = "resting";
		Fuzzy.calcResting();
		assertTrue(Fuzzy.resting == 1);
		
		Fuzzy.activity = "present";
		Fuzzy.calcResting();
		assertTrue(Fuzzy.resting == 0);
	}
	
	@Test
	public void testCalcPresent()
	{
		Fuzzy.activity = "present";
		Fuzzy.calcPresent();
		assertTrue(Fuzzy.present == 1);
		
		Fuzzy.activity = "resting";
		Fuzzy.calcPresent();
		assertTrue(Fuzzy.present == 0);
	}
}