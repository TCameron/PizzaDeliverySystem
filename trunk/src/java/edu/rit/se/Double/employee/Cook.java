package edu.rit.se.Double.employee;

import java.util.Timer;

import edu.rit.se.Double.Order;
import edu.rit.se.Double.item.BaseItem;
import edu.rit.se.Double.item.MenuItem;
/**
 * @author        Jacob Juby, Timothy Cameron, Cody Pugliese, 
 * Heriberto Munoz, Ken Van Dalsum
 * @version       0.0.3
 * Class Cook
 * 
 * Jacob Juby
 *     I have developed the perform function to sort through
 * a list of items that need to be cooked.  I have yet to come 
 * up with a way of getting the time to represent the cooking 
 * part.  Also I have added Constructor functionality.  Added ding()
 * the method for being notified that there is a pizza in the oven 
 * that is done.  Changed the Constructor for more functionality.
 */
public class Cook extends PerformanceEmployee {

    //
    // Fields
    //
	Oven oven;

  
    //
    // Constructors
    //
    public Cook (String name, String passwd, Oven oven) 
    {
    	super(name, passwd);
    	this.oven = oven;
    }
  
    //
    // Methods
    //
    /**
     * @Override     method perform(Order order) from class 
     * PerformanceEmployee
     * 
     * @param        order the order that comes in will have some task 
     * performed on its contents by this method
     */
    public void perform( Order order ) 
    {
    	boolean done = false;
    	while(!done) {
            for(MenuItem item : order.getListOfItems())
            {
                if(item instanceof BaseItem)
                {
                    if(((BaseItem)item).isReadyForCooking())
                    {
                	    ((BaseItem)item).whoIsCookingMe(this, order.getId());
                        oven.putIn((BaseItem)item, order.getId());
                        (new Timer()).schedule((BaseItem)item, 
                    		              ((BaseItem)item).getTime()*1000);
                    }
                }
            }
            int i = 0;
            for(MenuItem item : order.getListOfItems())
            {
                if(((BaseItem)item).getStatus().equals(BaseItem.COOKED))
                {
                	i++;
                }
            }
            
            if(i == order.getListOfItems().size())
            {
            	done = true;
            }
    	}
        order.setStatus(Order.STATUSES[2]);
    }

    /**
     * method for being notified that something has finished cooking
     * 
     * @param id the id of the MenuItem that is done
     */
    public void ding(int id)
    {
    	//um DING!
    	oven.takeOut(id);
    	
    }

}
