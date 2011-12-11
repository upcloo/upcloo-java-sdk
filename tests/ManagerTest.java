import static org.junit.Assert.*;
import junit.framework.TestCase;

import com.upcloo.client.Manager;
import com.upcloo.client.http.UpCloo;


public class ManagerTest extends TestCase
{

	public void testSingletonInstance() 
	{
		Manager manager = Manager.getInstance();
		
		Manager manager2 = Manager.getInstance();
		
		assertSame(manager, manager2);
	}
	
	public void testBaseConnectionParameters()
	{
		Manager manager = Manager.getInstance();
		
		manager.setCredential("username", "sitekey", "password");
		
		assertEquals("username", manager.getUsername());
		assertEquals("password", manager.getPassword());
		assertEquals("sitekey", manager.getSiteKey());
		
		assertArrayEquals(new String[0], manager.getVirtualSiteKeys());
	}
	
	public void testBaseVirtualSiteConnectionParameters()
	{
		Manager manager = Manager.getInstance();
		
		manager.setCredential("username", "sitekey", "password", "one", "two");
		
		assertArrayEquals(new String[]{"one", "two"}, manager.getVirtualSiteKeys());
	}
	
	public void testSetters()
	{
		Manager manager = Manager.getInstance();
		
		manager.setUsername("username");
		manager.setPassword("password");
		manager.setSiteKey("sitekey");
		
		assertEquals("username", manager.getUsername());
		assertEquals("password", manager.getPassword());
		assertEquals("sitekey", manager.getSiteKey());
	}
	
	public void testDefaultClientInstance()
	{
		Manager manager = Manager.getInstance();
		
		assertTrue(manager.getClient() instanceof UpCloo);
	}
}
