package edu.rit.se.Double.item;

import edu.rit.se.Double.employee.Cook;


/**
 * @author        Jacob Juby, Timothy Cameron, Cody Pugliese, 
 * Heriberto Munoz, Ken Van Dalsum
 * @version       0.0.6
 * Class BaseItem
 * BaseItem is any MenuItem that is not a toping some BaseItems can have
 * topings but not all baseItems can have topings
 * 
 * Jacob Juby
 * I am changing the status portion of this class to have 2 constants
 * NOT_COOKED and COOKED.  Also adding a readyForCooking field that can 
 * be queried from the cook's side of things.  Sent variable size to 
 * super no need to store the variable locally here.  Overrode the method 
 * run() from TimerTask.  Added the cook field to help with the threading. 
 */
public class BaseItem extends MenuItem {

	//
	//constants
    //
  public final static String NOT_COOKED = "not-cooked";
  public final static String COOKED = "cooked";
	
	//
    // Fields
    //

  private int time;//cooking time toping has prep time
  private String status;
  private boolean readyForCooking;
  private Cook cook;//variable to know who ding!
  private int myNumber;//variable to hold order id
  
    //
    // Constructors
    //
    public BaseItem (String name, double price, int time, int size) 
    {
    	super(name, price, size);
        this.time = time;
        this.status = NOT_COOKED;
        readyForCooking = false;
    }
  
    //
    // Methods
    //

    /**
     * This method will be what happens to this item while 
     * its in the oven.  It will probably do nothing for 
     * 1000*time which will be the total cooking time that
     * it takes to cook this item.
     * 
     * @Override MenuItem.run()
     */
    public void run()
    {
    	cook.ding(myNumber);
    }
    

    //
    // Accessor methods
    //

    /**
     * Set the value of time
     * @param newVar the new value of time
     */
  public void setTime ( int newVar ) {
      time = newVar;
  }

    /**
     * Get the value of time
     * @return the value of time
     */
  public int getTime ( ) {
      return time;
  }

    /**
     * Set the value of status
     */
  public void setCooked () {
      status = COOKED;
  }

    /**
     * Get the value of status
     * @return the value of status
     */
  public String getStatus ( ) {
      return status;
  }
  
  
    /**
     * Set the value of time
     * @param newVar the new value of time
     */
  public void makeReady () 
  {
      readyForCooking = true;
  }

    /**
     * see if the Item is ready for cooking
     * @return the value of readyForCooking
     */
  public boolean isReadyForCooking ( ) {
      return readyForCooking;
  }

  /**
   * this method just assigns a variable to hold who is cooking this Item.
   * 
   * @param cook the cook to ding
   */
  public void whoIsCookingMe(Cook cook, int myNumber) {
	  this.cook = cook;
	  this.myNumber = myNumber;
  }

}
