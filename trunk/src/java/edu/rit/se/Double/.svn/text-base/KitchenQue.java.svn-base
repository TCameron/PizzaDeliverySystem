/**
 * 
 */
package edu.rit.se.Double;

import java.util.LinkedList;
import edu.rit.se.Double.employee.Prep;
/**
 * @author Jake Juby
 * @version 0.0.1
 * The Kitchen Que this class controls getting an order from 
 * point A to point B.
 */
public class KitchenQue extends Thread 
{
	private LinkedList<Order> orders = new LinkedList<Order>();
	private Prep preps = new Prep(null,null,4);
	public KitchenQue()
	{}
	
	public void run()
	{
        for(;;)
        {
            if(!orders.isEmpty())
            {
                preps.perform(orders.getFirst());
            }
        }
	}
	
	public void addToList(Order order)
	{
        orders.add(order);
	}
	
	public Order getOrder(int orderNum)
	{
		for(Order o: orders)
		{
			if(orderNum == o.getId())
			{
				return o;
			}
		}
		return null;
	}
}
