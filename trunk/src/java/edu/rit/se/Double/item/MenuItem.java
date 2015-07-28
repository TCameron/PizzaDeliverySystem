package edu.rit.se.Double.item;


/**
 * @author        Jacob Juby, Timothy Cameron, Cody Pugliese, 
 * Heriberto Munoz, Ken Van Dalsum
 * @version       0.0.2
 * Class MenuItem
 * MenuItem consists of all the items on the menu for any given day.  the 
 * menu can change so a list of these will have to be dynamic.  MenuItems is a base 
 * abstract class that will be extended to be more specific
 * 
 * Jacob Juby:
 *     Added field size for oven functionality.  Extended TimerTask for better
 * timing functionality in BaseItem.
 */
abstract public class MenuItem extends java.util.TimerTask {

    //
    // Fields
    //

  private String name;
  private double price;
  private int size;
  
    //
    // Constructors
    //
    public MenuItem (String name, double price, int size) 
    {
        this.name = name;
        this.price = price;
        this.size = size;
    }
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of name
     * @param newVar the new value of name
     */
    public void setName ( String newVar ) {
      name = newVar;
    }

    /**
     * Get the value of name
     * @return the value of name
     */
    public String getName ( ) {
      return name;
    }

    /**
     * Set the value of price
     * @param newVar the new value of price
     */
    public void setPrice ( double newVar ) {
      price = newVar;
    }

    /**
     * Get the value of price
     * @return the value of price
     */
    public double getPrice ( ) {
      return price;
    }

    /**
     * get the value of size
     * @return the value of size
     */
	public int getSize() 
	{	
		return size;
	}

	/**
	 * This method will need to be implemented by anything that
	 * Extends this method.  This method allows me to add timing 
	 * functionality to MenuItems.
	 * 
	 * @Override TimerTask.run()
	 */
	public abstract void run();
}
