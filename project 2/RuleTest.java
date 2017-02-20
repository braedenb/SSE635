import static org.junit.Assert.*;
import org.junit.Test;

public class RuleTest
{
	@Test
	public void testRule()
	{
		Rule rule = new Rule("low", "constant", "resting", "sugar");
		
		assertTrue(rule.level.equals("low"));
		assertTrue(rule.change.equals("constant"));
		assertTrue(rule.activity.equals("resting"));
		assertTrue(rule.output.equals("sugar"));
		
		Rule rule2 = new Rule("low", null, null, "sugar");
		
		assertTrue(rule2.level.equals("low"));
		assertTrue(rule2.change == null);
		assertTrue(rule2.activity == null);
		assertTrue(rule2.output.equals("sugar"));
	}
	
	@Test
	public void testGetOutput()
	{
		Rule rule = new Rule("low", "constant", "resting", "sugar");
		
		assertTrue(rule.getOutput().equals("sugar"));
	}
	
	@Test
	public void testGetResult()
	{
		Rule rule = new Rule("low", "constant", "resting", "sugar");
		rule.result = 0.1;
		
		assertTrue(rule.getResult() == 0.1);
	}
	
	@Test
	public void TestCalcResult()
	{
		Rule rule = new Rule("low", "constant", "resting", "sugar");
		
		rule.calcResult(0.1, 0.9, 0.0, 0.35, 0.65, 0.0, 1.0, 0.0);

		assertTrue(rule.getResult() == 0.1);
		
		Rule rule2 = new Rule("low", null, null, "sugar");
		
		rule.calcResult(0.4, 0.6, 0.0, 0.3, 0.7, 0.0, 1.0, 0.0);
		
		assertTrue(rule.getResult() == 0.4);
	}
	
	@Test
	public void TestFindMin()
	{
		Rule rule = new Rule("low", "constant", "resting", "sugar");
		
		assertTrue(rule.findMin(0.3, 0.55, 0.4) == 0.3);
	}
}