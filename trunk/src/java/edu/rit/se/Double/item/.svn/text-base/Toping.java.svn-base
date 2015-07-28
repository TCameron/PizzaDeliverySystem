package edu.rit.se.Double.item;



/**
 * @author        Jacob Juby, Timothy Cameron, Cody Pugliese, 
 * Heriberto Munoz, Ken Van Dalsum
 * @version       0.0.5
 * Class Toping
 * toping is subclass of MenuItem it is a special menu item
 * toppings have prep time associated with them that is the time
 * field
 * 
 * Jacob Juby
 * I am changing the status portion of this class to have 2 constants
 * NOT_PREPED and PREPED.  Also added a status field for easy checking.
 * Sent size of 0 to super because Topings don't have a size.  Overrode the 
 * run() function from TimerTask. 
 */
public class Toping extends MenuItem {

	//
	//constants
	//
  public final static String NOT_PREPED = "not-preped";
  final static String PREPED = "preped";
  
    //
    // Fields
    //

  private BaseItem base;
  private int time;
  private String status;
  private boolean working;
  
    //
    // Constructors
    //
    public Toping (BaseItem base, String name, double price, int time) 
    {
    	super(name, price, 0);//sending 0 to super because this is a toping
        this.base = base;
        this.status = Toping.NOT_PREPED;
        this.time = time;
    }
  
    //
    // Methods
    //

    /**
     * This method will be what happens to this item while 
     * its in the oven.  It will probably do nothing for 
     * 1000*time which will be the total cooking time that
     * it takes to cook this item.  At the moment we have no 
     * need for a Timer in this object this is a necessary override.
     * 
     * @Override MenuItem.run()
     */
    public void run()
    {}
    

    //
    // Accessor methods
    //

    /**
     * Set the value of base
     * @param newVar the new value of base
     */
    public void setBase ( BaseItem newVar ) {
      base = newVar;
    }

    /**
     * Get the value of base
     * @return the value of base
     */
    public BaseItem getBase ( ) {
      return base;
    }
    
    /**
     * Get the value of time
     * @return the value of time
     */
    public int getTime()
    {
    	return time;
    }
    
    /**
     * Set the value of time
     * @param time the new value of this.time
     */
    public void setTime ( int time ) 
    {
        this.time = time;
    }
    
    /**
     * Set the value of status
     */
    public void setPreped () {
        status = Toping.PREPED;
    }

    /**
     * Get the value of status
     * @return the value of status
     */
    public String getStatus ( ) {
        return status;
    }
    
    /**
     * Get the value of working
     * @return the value of working
     */
    public boolean getWorking()
    {
    	return working;
    }
    
    /**
     * set the value of working
     * @param boolean the value to set as working
     */
    public void setWorking (boolean f) {
        working = f;
    }
    
    
    
    //
    // Other methods
    //

}
