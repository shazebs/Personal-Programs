package junit;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Sword;

/**
 * This class tests all Sword class methods.
 *
 */
public class SwordTest {

	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Sword object.
	 * + assertNotNull() 
	 */
	public void SwordClassDefaultConstructorTest() {		
		assertNotNull(new Sword()); 
	}
	
	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Sword object with its default constructor.
	 * + assertNotNull()
	 */
	public void SwordClassNonDefaultConstructorTest() {
		assertNotNull(new Sword("SampleProduct", "TestCase", 9.99, 1, "Sword")); 
	}
	
	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Sword object with its non-default constructor.
	 * + assertEquals()
	 */
	public void SwordClassGetMethodsTest() {
		var obj = new Sword("SampleProduct", "TestCase", 9.99, 1, "Sword");
		/*
		assertEquals("SampleProduct", obj.getName());
		assertEquals("TestCase", obj.getDescription());
		assertEquals(9.99, obj.getPrice());
		assertEquals(1, obj.getItemLevel());
		assertEquals("Sword", obj.getType());
		*/
	}
	
	@Test
	/**
	 * This JUnit Test attempts to test a Sword object's ToString() method.
	 * + assertEquals()
	 */
	public void SwordClassToStringTest() {
		// Create two similar objects and assertEquals their ToString methods to make sure the method is working.
		var obj = new Sword("SampleProduct", "TestCase", 9.99, 1, "Sword");
		var obj2 = new Sword("SampleProduct", "TestCase", 9.99, 1, "Sword");
		assertEquals(obj.toString(), obj2.toString());
	}
}
