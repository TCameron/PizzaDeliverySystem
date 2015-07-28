package edu.rit.se.Double.employee;
/**
 * @author        Jacob Juby, Timothy Cameron, Cody Pugliese, 
 * Heriberto Munoz, Ken Van Dalsum
 * @version       0.0.3
 * Class Oven
 * Oven will be a wrapper class around a Map object that will map integer
 * order numbers to menu_items that are currently in the Oven Cooks will keep 
 * the time on these items
 * 
 * Jacob Juby
 *     Added field capacity for keeping a lid on oven size.  Added a boolean
 * function for making sure there is space in this oven to add a item.
 */

//imports
import java.util.*;

import edu.rit.se.Double.item.BaseItem;
import edu.rit.se.Double.item.MenuItem;

public class Oven 
{

    //
    // Fields
    //

	Map<Integer, BaseItem> oven;
	int capacity;
  
    //
    // Constructors
    //
    public Oven (int capacity) 
    { 
        this.capacity = capacity;
    }
    
    /**
     * put something in the oven
     * @param item the item to be cooked
     * @param orderNumber the number to map to the item
     */
    public void putIn(BaseItem item, int orderNumber)
    {
    	//just throwing this in feel free to change
    	//to a better implementation -Jake
    	oven.put(orderNumber, item);
    }
    
    /**
     * take the associated Item out of the oven
     * @return a MenuItem that has been cooked
     */
    public BaseItem takeOut(int orderNumber)
    {
    	//again just throwing this in here 
    	//feel free to change this to a better implementation -Jake
    	oven.get(orderNumber).setCooked();
    	return oven.remove(orderNumber);
    }

    /**
     * Test to see if the MenuItem item will overflow the ovens capacity
     * 
     * @param item see if this item overflows the oven
     * @return true if item overflows oven false otherwise
     */
    public boolean willOverflow(MenuItem item)
    {
    	int currentSize = 0;
    	for(MenuItem m : oven.values())
    	{
    		currentSize += m.getSize();
    	}
    	
    	if(currentSize + item.getSize() > capacity)
    	{
    		return true;
    	}
    	return false;
    }
}
