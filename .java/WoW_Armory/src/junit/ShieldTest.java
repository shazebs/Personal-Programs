package junit;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Shield;


/**
 * This class tests all Shield class methods.
 *
 */
public class ShieldTest {

	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Shield object.
	 * + assertNotNull() 
	 */
	public void ShieldClassDefaultConstructorTest() {		
		assertNotNull(new Shield()); 
	}
	
	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Shield object with its default constructor.
	 * + assertNotNull()
	 */
	public void ShieldClassNonDefaultConstructorTest() {
		assertNotNull(new Shield("SampleProduct", "TestCase", 9.99, 1, "Shield")); 
	}
	
	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Shield object with its non-default constructor.
	 * + assertEquals()
	 */
	public void ShieldClassGetMethodsTest() {
		var obj = new Shield("SampleProduct", "TestCase", 9.99, 1, "Shield");
		/*
		assertEquals("SampleProduct", obj.getName());
		assertEquals("TestCase", obj.getDescription());
		assertEquals(9.99, obj.getPrice());
		assertEquals(1, obj.getItemLevel());
		assertEquals("Shield", obj.getType());
		*/
	}
	
	@Test
	/**
	 * This JUnit Test attempts to test a Shield object's ToString() method.
	 * + assertEquals()
	 */
	public void ShieldClassToStringTest() {
		// Create two similar objects and assertEquals their ToString methods to make sure the method is working.
		var obj = new Shield("SampleProduct", "TestCase", 9.99, 1, "Shield");
		var obj2 = new Shield("SampleProduct", "TestCase", 9.99, 1, "Shield");
		assertEquals(obj.toString(), obj2.toString());
	}
}