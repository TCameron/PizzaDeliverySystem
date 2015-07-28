package edu.rit.se.Double.employee;
import java.util.ArrayList;

import edu.rit.se.Double.Customer;
import edu.rit.se.Double.Order;
import edu.rit.se.Double.item.MenuItem;



/**
 * @author        Jacob Juby, Timothy Cameron, Cody Pugliese, 
 * Heriberto Munoz, Ken Van Dalsum
 * @version       0.0.3
 * Class FunctionalEmployee you must login before you can issue
 * Orders.
 * 
 * Jacob Juby
 *     Added functionality to the constructor, and added the field 
 * permissions to control logins.  You must login before you can 
 * instantiate an Object of Order. 
 */
abstract public class FunctionalEmployee extends Employee {

    //
    // Fields
    //
  private boolean permission;
  
    //
    // Constructors
    //
    public FunctionalEmployee (String name, String passwd) 
    { 
        super(name, passwd);
        permission = false;
    }
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    //
    // Other methods
    //

    /**
     * @param        name the name used to login
     * @param        passwd the password used to log in
     */
  public void login( String name, String passwd )
  {
	  if((name.equalsIgnoreCase(this.getName()))&& 
			  (passwd.equalsIgnoreCase(this.getPasswd())))
	  {
          permission = true;
	  }
  }


    
    /**
     * This method sort of acts like a tunnel so that the declaration of 
     * the Order can grab a Employee on the way through.  Once this method 
     * passes its ok for the interface to go directly to the order to get 
     * statuses but the interface should not change anything.  More 
     * functionality should be added to this class so that it can forward 
     * things from here to the order and the kitchen. 
     * 
     * @param listOfItems a list of items that should be ordered
     * @param customer the customer that has ordered this order
     * @param id the numerical id that separates this order from all other orders
     * @return a reference to the order we created
     */
  public Order createOrder(ArrayList<MenuItem> listOfItems, 
	                       Customer customer, int id)
  {
	  if(permission)
	  {
          Order order = new Order ( listOfItems, customer, this, id);
          return order;
      }
	  return null;
  }


}
