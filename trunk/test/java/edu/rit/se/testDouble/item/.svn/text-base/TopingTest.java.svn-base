/**
 * 
 */
package edu.rit.se.testDouble.item;


import java.util.ArrayList;

import edu.rit.se.Double.item.*;
import junit.framework.*;

/**
 * @author Timothy Cameron
 *
 */
public class TopingTest extends TestCase{

	public void testBaseItemInList() {
		BaseItem baseItem1 = new BaseItem("TestBase", 15, 30, 3);
		Toping testItem1 = new Toping(baseItem1, "Test", 15, 30);
		ArrayList<MenuItem> testList1 = new ArrayList<MenuItem>();
		testList1.add(testItem1);
		assertTrue(testList1.contains(testItem1));
	}

}
