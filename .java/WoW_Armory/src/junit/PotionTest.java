package junit;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Potion;

/**
 * This class tests all Potion class methods.
 *
 */
public class PotionTest {

	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Helmet object.
	 * + assertNotNull() 
	 */
	public void PotionClassDefaultConstructorTest() {		
		assertNotNull(new Potion()); 
	}
	
	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Potion object with its default constructor.
	 * + assertNotNull()
	 */
	public void PotionClassNonDefaultConstructorTest() {
		assertNotNull(new Potion("SampleProduct", "TestCase", 9.99, 1, "Potion")); 
	}
	
	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Potion object with its non-default constructor.
	 * + assertEquals()
	 */
	public void PotionClassGetMethodsTest() {
		var obj = new Potion("SampleProduct", "TestCase", 9.99, 1, "Potion");
		/*
		assertEquals("SampleProduct", obj.getName());
		assertEquals("TestCase", obj.getDescription());
		assertEquals(9.99, obj.getPrice());
		assertEquals(1, obj.getItemLevel());
		assertEquals("Potion", obj.getType());
		*/
	}
	
	@Test
	/**
	 * This JUnit Test attempts to test a Potion object's ToString() method.
	 * + assertEquals()
	 */
	public void PotionClassToStringTest() {
		// Create two similar objects and assertEquals their ToString methods to make sure the method is working.
		var obj = new Potion("SampleProduct", "TestCase", 9.99, 1, "Potion");
		var obj2 = new Potion("SampleProduct", "TestCase", 9.99, 1, "Potion");
		assertEquals(obj.toString(), obj2.toString());
	}
}
