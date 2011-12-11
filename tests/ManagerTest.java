import static org.junit.Assert.*;

import org.junit.Test;

import com.upcloo.client.Manager;


public class ManagerTest {

	@Test
	public void testSingletonInstance() {
		Manager manager = Manager.getInstance();
		
		Manager manager2 = Manager.getInstance();
		
		assertSame(manager, manager2);
	}

}
