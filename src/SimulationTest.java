import static org.junit.Assert.*;
import org.junit.Test;

public class SimulationTest
{
	@Test
	public void test()
	{
		Simulation.main(null);
		
		assertTrue(Simulation.idealTemp == 15.0);
		assertTrue(Simulation.idealPrec == 50.0);
		
		assertTrue(Simulation.minTemp == 2.5);
		assertTrue(Simulation.maxTemp == 27.5);
		assertTrue(Simulation.minPrec == 25.0);
		assertTrue(Simulation.maxPrec == 75.0);
	}
}