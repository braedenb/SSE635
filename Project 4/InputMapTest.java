import static org.junit.Assert.*;
import org.junit.Test;

public class InputMapTest {

	@Test
	public void testConvertPrice() {
		assertTrue(InputMap.convertPrice(40000) == 0);
		assertTrue(InputMap.convertPrice(90000) == 1);
		assertTrue(InputMap.convertPrice(65000) == 0.5);
	}
	
	@Test
	public void testConvertCrime() {
		assertTrue(InputMap.convertCrime(3000) == 0);
		assertTrue(InputMap.convertCrime(5500) == 1);
		assertTrue(InputMap.convertCrime(4250) == 0.5);
	}
	
	@Test
	public void testConvertPopulation() {
		assertTrue(InputMap.convertPopulation(800) == 0);
		assertTrue(InputMap.convertPopulation(2500) == 1);
		assertTrue(InputMap.convertPopulation(1650) == 0.5);
	}
	
	@Test
	public void testConvertAll() {
		double[] inputs = InputMap.convertAll(65000, 0.5, 4250, 1650);
		assertTrue(inputs[3] == 0.5);
		assertTrue(inputs[2] == 0.5);
		assertTrue(inputs[1] == 0.5);
		assertTrue(inputs[0] == 0.5);
	}
}
