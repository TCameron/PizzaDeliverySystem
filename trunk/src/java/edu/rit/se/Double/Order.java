package edu.rit.se.Double;


/**
 * @author        Jacob Juby, Timothy Cameron, Cody Pugliese, 
 * Heriberto Munoz, Ken Van Dalsum
 * @version       0.0.9
 * Class Order
 * an order is the class that basically holds and controls all of the 
 * attributes of an order consisting of price, time, items, and more 
 * it interfaces with the MenuItem classes and it interfaces with the 
 * Employee + customer classes
 * 
 * Refactor 1
 * By: Jacob Juby
 *     
 *     I have decided to extend TimerTask to make time keeping of an 
 * order more accessible.  It will allow us to count time from inside 
 * the run() function.  This is a experimental idea, so lets go with 
 * it for a while and see where we end up.  I have also changed the end 
 * function to a private function because I can end the time counting 
 * by testing the value of status which I have implemented.  I have added 
 * a toString method as well and made price a calculated field.
 */

//imports
import java.util.*;

import edu.rit.se.Double.employee.Employee;
import edu.rit.se.Double.item.BaseItem;
import edu.rit.se.Double.item.MenuItem;
import edu.rit.se.Double.item.Toping;

public class Order extends TimerTask {

	
	//
	//constants
	//
  final int HALF_MINUTE = 30000;
  public final static String[] STATUSES = {"Ready for prep", 
                                    "Ready for cook", 
                                    "Ready for delivery", 
                                    "finished"};
    
    //
    // Fields
    //

  private Timer timer = new Timer();
  private ArrayList<MenuItem> listOfItems;
  
  private double price; //calculated value
  
  private Customer customer;
  private Employee employee;
  private int id;
  private String status;
  
  //this time keeper is a count of the half minutes
  //that have passed since the Order was ordered
  private long timeAlive = 0;
    
    //
    // Constructors
    //
  
    public Order (ArrayList<MenuItem> listOfItems, 
    		      Customer customer, Employee employee, int id) 
    { 
    	this.listOfItems = listOfItems;
    	this.customer = customer;
    	this.employee = employee;
    	this.id = id;
    	
    	price = 0;//this is because we are going to calculate
    	          //this field see getPrice()
    	status = STATUSES[0];
    	start();
    }


    //
    // Accessor methods
    //

    /**
     * Set the value of listOfItems
     * @param newList the new value of listOfItems
     */
    public void setListOfItems ( ArrayList<MenuItem> newList ) {
      listOfItems = newList;
    }

    /**
     * Get the value of listOfItems
     * @return the value of listOfItems
     */
    public ArrayList<MenuItem> getListOfItems ( ) {
      return listOfItems;
    }

    /**
     * Set the value of price
     * @param newPrice the new value of price
     */
    public void setPrice ( double newPrice ) {
      price = newPrice;
    }

    /**
     * Get the value of price
     * @return the value of price
     */
    public double getPrice ( ) {
    	if(price > 0)
    	{
    		for(MenuItem item : listOfItems)
    		{
    			price += item.getPrice();
    		}
    	}
    	return price;
    }

    /**
     * Set the value of customer
     * @param newCustomer the new value of customer
     */
    public void setCustomer ( Customer newCustomer ) {
      customer = newCustomer;
    }

    /**
     * Get the value of customer
     * @return the value of customer
     */
    public Customer getCustomer ( ) {
      return customer;
    }

    /**
     * Set the value of employee
     * @param newEmployee the new value of employee
     */
    public void setEmployee ( Employee newEmployee ) {
      employee = newEmployee;
    }

    /**
     * Get the value of employee
     * @return the value of employee
     */
    public Employee getEmployee ( ) 
    {
      return employee;
    }

    /**
     * Set the value of id
     * @param newID the new value of id
     */
    public void setId ( int newID ) 
    {
      id = newID;
    }

    /**
     * Get the value of id
     * @return the value of id
     */
    public int getId ( ) 
    {
      return id;
    }

    /**
     * Get the value of timeAlive to get total seconds of alive time
     * @return the value of timeAlive
     */
    public long getTimeAlive ( ) 
    {
      return timeAlive*30;
    }

    //
    // Other methods
    //

    /**
     * private function for ending the time counter
     */
  private void end(  )
  {
	  timer.cancel();
  }


    /**
     * so the basic idea here is that cook time has to do with only
     * base items because base items are the only things that need cooking
     * last edited by: Jacob Juby
     * 
     * @return       int the calced value of cooking time for the items
     */
  public int getCookTime(  )
  {
	  int answer = 0;
	  for(MenuItem item : listOfItems)//for each loop here
	  {
		  if(item instanceof BaseItem)
		  {
              answer += ((BaseItem)item).getTime();
		  }
	  }
	  return answer;
  }


    /**
     * similar to getCookTime the only Items that need preping are
     * toppings but this may change soon I think we need another class
     * for Items that are never cooked such as salads
     * last edited by: Jacob Juby
     * 
     * @return       int
     */
  public int getPrepTime(  )
  {
	  int answer = 0;
	  for(MenuItem item : listOfItems)//for each loop here
	  {
		  if(item instanceof Toping)
		  {
              answer += ((Toping)item).getTime();
		  }
	  }
	  return answer;
  }


    /**
     * basically just the time it takes to prep, cook, and deliver
     * and returning that value
     * 
     * @return       int
     */
  public int estimateTime(  )
  {
	  int answer = getPrepTime() + getCookTime();
	  return answer;
  }


    /**
     * there is an ArrayLsit of approved statuses this function will check
     * the String status against these approved Strings
     * last edited by: Jacob Juby
     * 
     * @param        status a string that will contain the current status
     *                 of the order
     */
  public void setStatus( String status )
  {
	  for( int i = 0; i < STATUSES.length ;i++ )
	  {
		  if(STATUSES[i].equalsIgnoreCase(status))
			  this.status = STATUSES[i];
	  }
	  
	  if(this.status.equalsIgnoreCase(STATUSES[3]))
	  {
		  end();
	  }
  }
  
  /**
   * return the value of the Object field status
   * @return the value of this.status
   */
  public String getStatus()
  {
	  return status;
  }


    /**
     * @return       MenuItem
     * @param        item this menu item is going to be preped or 
     * cooked it doesn't matter what item or what function is to 
     * be performed on it this method does not care about any of that
     */
  public MenuItem getNextItem( MenuItem item )
  {
	  return null;
  }


    /**
     * start counting time
     */
  private void start(  )
  {
	  timer.scheduleAtFixedRate(this ,0, HALF_MINUTE);
  }

  public void run()
  {
      timeAlive++;
  }
  
  /**
   * this function provides a nice text representation of the order and 
   * its current status giving you a good representation of how the order
   * is doing
   * 
   * @see java.lang.Object#toString()
   * @return String representation of this Order
   */
  @Override
  public String toString()
  {
	  return "Order #       :  "+id+"\n"+
	  		 "Price         :  "+getPrice()+"\n"+
	  		 "Status        :  "+getStatus()+"\n"+
	  		 "Estimated Time:  "+estimateTime()+"\n"+
	  		 "Current Time  :  "+getTimeAlive()+"\n"+
	  		 "Location      :  "+customer.getLocation()+"\n"+
	  		 "Name          :  "+customer.getName()+"\n";
	  
  }
}
