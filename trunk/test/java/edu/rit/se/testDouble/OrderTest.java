package edu.rit.se.testDouble;

import java.util.ArrayList;
import edu.rit.se.Double.*;
import edu.rit.se.Double.item.*;
import edu.rit.se.Double.employee.*;
import junit.framework.*;

/**
 * @author Timothy Cameron
 * 
 */
public class OrderTest extends TestCase {

	public void testOrderCreation() {
		BaseItem base = new BaseItem("baseTest", 15, 30, 3);
		ArrayList<MenuItem> itemList = new ArrayList<MenuItem>();
		itemList.add(base);
		assertTrue(itemList.contains(base));
		Customer cusTest = new Customer("Bob", "5555555", "house");
		Cashier cash = new Cashier("Cash","123");
		Order testOrder = new Order(itemList, cusTest, cash, 1);
	}

}
