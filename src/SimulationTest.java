import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class SimulationTest
{
	@Test
	public void test()
	{
		Simulation.setConditions();
		
		assertTrue(Simulation.idealTemp == 15.0);
		assertTrue(Simulation.idealPrec == 50.0);
		
		Simulation.setInitialRange();
		
		assertTrue(Simulation.minTemp == 2.5);
		assertTrue(Simulation.maxTemp == 27.5);
		assertTrue(Simulation.minPrec == 25.0);
		assertTrue(Simulation.maxPrec == 75.0);
		
		Simulation.population = new ArrayList<Plant>();
		
		Simulation.populate();
		
		assertTrue(Simulation.population.size() == 20);
		
		Simulation.population = Simulation.selectBestFit();
		
		assertTrue(Simulation.population.size() <= 20);
		
		ArrayList<Plant> children = Simulation.crossPollinate();
		
		assertTrue(children.size() == Simulation.population.size() || children.size() == Simulation.population.size() - 1);
		
		Simulation.carryOver(children);
		
		Simulation.population = children;
		
		assertTrue(Simulation.population.size() <= 20);
	}
}