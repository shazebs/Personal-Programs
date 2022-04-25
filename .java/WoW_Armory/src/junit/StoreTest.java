package junit;

import static org.junit.Assert.*;
import org.junit.Test;
import app.SalableProduct;
import app.Store;

/**
 * This class tests all Store class methods. 
 * 
 */
public class StoreTest {

	@Test
	/**
	 * This TestCase tests the "newline" functions. 
	 */
	public void Newline_Tests() {
		var func = new Store(); 
		func.newline(); 
		func.newline(10); 
	}
	
	@Test
	/**
	 * This TestCase tests the "PrintMenu" function.
	 */
	public void PrintMenu_Test() {
		var func = new Store();
		func.printMenu();
	}
	
	@Test
	/**
	 * This TestCase tests the "PrintInventory" function.
	 */
	public void PrintInventory_Test() {
		var func = new Store();
		func.printInventory();
	}

	@Test
	/**
	 * This TestCase tests the "PrintShoppingCart" function.
	 */
	public void PrintShoppingCart_Test() {
		var func = new Store();
		func.printShoppingCart();
	}	

	@Test
	/**
	 * This TestCase tests the "ViewInventory" function.
	 */
	public void ViewInventory_Test() {
		var func = new Store();
		// func.viewInventory();
	}
	
	@Test
	/**
	 * This TestCase tests the "ViewCart" function.
	 */
	public void ViewCart_Test() {
		var func = new Store();
		// func.viewCart();
	}
	
	@Test
	/**
	 * This TestCase tests the "ManageInventory" function.
	 */
	public void ManageInventory_Test() {
		var func = new Store();
		// func.manageInventory();
	}
	
	@Test
	/**
	 * This TestCase tests the "createInventoryItem" function.
	 */
	public void CreateInvetoryItem_Test() {
		var func = new Store();
		var salableProduct = new SalableProduct(); 
		// func.createInventoryItem(salableProduct, "TestCase", true);
	}
	
	@Test
	/**
	 * This TestCase tests the "initializeInventory" function.
	 */
	public void InitializeInventory_Test() {
		var func = new Store();
		var salableProduct = new SalableProduct(); 
		// func.initializeInventory("InventoryItems.txt");
	}
	
	@Test
	/**
	 * This TestCase tests the "createNewItem" function.
	 */
	public void CreateNewItem_Test() {
		var func = new Store();
		func.createNewItem(null, null);
	}
	
	@Test
	/**
	 * This TestCase tests the "sortBy" function.
	 */
	public void SortBy_Test() {
		var func = new Store();
		func.sortBy(0, null, null, null);
	}
	
	@Test
	/**
	 * This TestCase tests the "printItemsE" function.
	 */
	public void PrintItemsE_Test() {
		var func = new Store();
		func.printItemsE(null); 
	}
	
	@Test
	/**
	 * This TestCase tests the "startServer" function. 
	 */
	public void StartServer_Test() {
		var func = new Store(); 
		// func.startServer(); 
	}
	
	@Test
	/**
	 * This TestCase tests the "sendInventoryItems" function.
	 */
	public void SendInventoryItems_Test() {
		var func = new Store(); 
		func.sendInventoryItems(); 
	}
	
	@Test
	/**
	 * This TestCase tests the "recieveInventoryItems" function.
	 */
	
	public void RecieveInventoryItems_Test() {
		var func = new Store(); 
		func.receiveInventoryItems(null);		
	}
	
}
















