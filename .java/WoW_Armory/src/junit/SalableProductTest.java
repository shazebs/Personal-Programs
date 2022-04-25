package junit;

import static org.junit.Assert.*;
import org.junit.Test;
import app.AdminClient;

/**
 * This class tests all AdminClient methods.
 */
public class AdminClientTest 
{
	
	// @Test
	/**
	 * This TestCase tests the "displayOptions" function. 
	 */
	/*public void DisplayOptions_Test() {
		var func = new AdminClient();
		func.displayOptions(); 
	}*/
	
	@Test
	/**
	 * This TestCase tests the "processServerResponse" function. 
	 */
	public void ProcessServerResponse_Test() {
		var func = new AdminClient(); 
		func.processServerResponse("TestCase Response"); 
	}
	
	@Test
	/**
	 * This TestCase tests the "Command U" function. 
	 */
	public void CommandU_Test() {
		var func = new AdminClient(); 
		assertEquals("bruh", func.COMMAND_U()); 
	}
	
	@Test 
	/**
	 * This TestCase tests the "Command R" function. 
	 */
	public void CommandR_Test() {
		var func = new AdminClient(); 
		String json = "{\"type\": \"Sword\"|\"name\": \"Jaithys, the Prison Blade\"|\"description\": \"224-374 Damage\"|\"price\": 15370.46|\"ilvl\": 259}@{\"type\": \"Bow\"|\"name\": \"Rae'shalare, Death's Whisper\"|\"description\": \"212-287 Damage\"|\"price\": 23226.85|\"ilvl\": 233}@{\"type\": \"Shield\"|\"name\": \"Guard of the Sundered Defender\"|\"description\": \"1,992 Block\"|\"price\": 8016.86|\"ilvl\": 259}@{\"type\": \"Helmet\"|\"name\": \"Dark Tormentor's Gaze\"|\"description\": \"195 Armor\"|\"price\": 6321.23|\"ilvl\": 252}@{\"type\": \"Potion\"|\"name\": \"Spiritual Healing Potion\"|\"description\": \"Restores 10,000 HP\"|\"price\": 50.0|\"ilvl\": 0}@{\"type\": \"Food\"|\"name\": \"Mon'Dazi\"|\"description\": \"Restores 7,692 HP\"|\"price\": 200.0|\"ilvl\": 0}@{\"type\": \"Sword\"|\"name\": \"Great-Sword\"|\"description\": \"100 Damage\"|\"price\": 999.0|\"ilvl\": 69}@{\"type\": \"Shield\"|\"name\": \"Large Shield\"|\"description\": \"2000 Block\"|\"price\": 655.99|\"ilvl\": 15}"; 
		func.COMMAND_R(json);
	}
}
