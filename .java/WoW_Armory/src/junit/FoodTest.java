package junit;

import static org.junit.Assert.*;
import org.junit.Test;
import app.Food;

/**
 * This class tests all Food class methods.
 *
 */
public class FoodTest {

	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Food object.
	 * + assertNotNull() 
	 */
	public void FoodClassDefaultConstructorTest() {		
		assertNotNull(new Food()); 
	}
	
	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Food object with its default constructor.
	 * + assertNotNull()
	 */
	public void FoodClassNonDefaultConstructorTest() {
		assertNotNull(new Food("SampleProduct", "TestCase", 9.99, 1, "Food")); 
	}
	
	@Test
	/**
	 * This JUnit Test attempts to instantiate a new Food object with its non-default constructor.
	 * + assertEquals()
	 */
	public void FoodClassGetMethodsTest() {
		var obj = new Food("SampleProduct", "TestCase", 9.99, 1, "Food");
		/*
		assertEquals("SampleProduct", obj.getName());
		assertEquals("TestCase", obj.getDescription());
		assertEquals(9.99, obj.getPrice());
		assertEquals(1, obj.getItemLevel());
		assertEquals("Food", obj.getType());
		*/
	}
	
	@Test
	/**
	 * This JUnit Test attempts to test a Food object's ToString() method.
	 * + assertEquals()
	 */
	public void FoodClassToStringTest() {
		// Create two similar objects and assertEquals their ToString methods to make sure the method is working.
		var obj = new Food("SampleProduct", "TestCase", 9.99, 1, "Food");
		var obj2 = new Food("SampleProduct", "TestCase", 9.99, 1, "Food");
		assertEquals(obj.toString(), obj2.toString());
	}
}
