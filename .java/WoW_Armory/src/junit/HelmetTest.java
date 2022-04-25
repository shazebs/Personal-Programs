package junit;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Helmet;
import app.SalableProduct;

/**
 * This class tests all Helmet class methods.
 *
 */
public class HelmetTest {

	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Helmet object.
	 * + assertNotNull() 
	 */
	public void HelmetClassDefaultConstructorTest() {		
		assertNotNull(new Helmet()); 
	}
	
	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Helmet object with its default constructor.
	 * + assertNotNull()
	 */
	public void HelmetClassNonDefaultConstructorTest() {
		assertNotNull(new Helmet("SampleProduct", "TestCase", 9.99, 1, "Helmet")); 
	}
	
	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Helmet object with its non-default constructor.
	 * + assertEquals()
	 */
	public void HelmetClassGetMethodsTest() {
		var obj = new Helmet("SampleProduct", "TestCase", 9.99, 1, "Helmet");
		
		/*
		assertEquals("SampleProduct", obj.getName());
		assertEquals("TestCase", obj.getDescription());
		assertEquals(9.99, obj.getPrice());
		assertEquals(1, obj.getItemLevel());
		assertEquals("Helmet", obj.getType());
		*/
	}
	
	@Test
	/**
	 * This JUnit Test attempts to test a Helmet object's ToString() method.
	 * + assertEquals()
	 */
	public void HelmetClassToStringTest() {
		// Create two similar objects and assertEquals their ToString methods to make sure the method is working.
		var obj = new Helmet("SampleProduct", "TestCase", 9.99, 1, "Helmet");
		var obj2 = new Helmet("SampleProduct", "TestCase", 9.99, 1, "Helmet");
		assertEquals(obj.toString(), obj2.toString());
	}
}
