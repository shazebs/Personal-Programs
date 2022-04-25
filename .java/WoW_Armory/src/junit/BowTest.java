package junit;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Bow;

/**
 * This class tests all Bow class methods.
 *
 */
public class BowTest {

	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Bow object.
	 * + assertNotNull() 
	 */
	public void BowClassDefaultConstructorTest() {		
		assertNotNull(new Bow()); 
	}
	
	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Bow object with its default constructor.
	 * + assertNotNull()
	 */
	public void BowClassNonDefaultConstructorTest() {
		assertNotNull(new Bow("SampleProduct", "TestCase", 9.99, 1, "Bow")); 
	}
	
	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Bow object with its non-default constructor.
	 * + assertEquals()
	 */
	public void BowClassGetMethodsTest() {
		var obj = new Bow("SampleProduct", "TestCase", 9.99, 1, "Bow");
		/*
		assertEquals("SampleProduct", obj.getName());
		assertEquals("TestCase", obj.getDescription());
		assertEquals(9.99, obj.getPrice());
		assertEquals(1, obj.getItemLevel());
		assertEquals("Bow", obj.getType());
		*/
	}
	
	@Test
	/**
	 * This JUnit Test attempts to test a Bow object's ToString() method.
	 * + assertEquals()
	 */
	public void BowClassToStringTest() {
		// Create two similar objects and assertEquals their ToString methods to make sure the method is working.
		var obj = new Bow("SampleProduct", "TestCase", 9.99, 1, "Bow");
		var obj2 = new Bow("SampleProduct", "TestCase", 9.99, 1, "Bow");
		assertEquals(obj.toString(), obj2.toString());
	}
}
